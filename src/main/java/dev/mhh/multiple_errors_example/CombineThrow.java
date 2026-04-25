package dev.mhh.multiple_errors_example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class CombineThrow {
    public interface VarFunction<T> {
        T apply(Object... args);
    }

    public static class AggregatedException extends Exception {
        public AggregatedException(List<Exception> exceptions) {
            exceptions.forEach(this::addSuppressed);
        }
    }

    @SafeVarargs
    public static <T> T exceptionAggregator(
            VarFunction<T> function,
            Supplier<Object>... argSuppliers
    ) throws AggregatedException {
        final var args = new Object[argSuppliers.length];
        final var exceptions = new ArrayList<Exception>();
        for (int i = 0; i < argSuppliers.length; i++) {
            final var argSupplier = argSuppliers[i];
            try {
                args[i] = argSupplier.get();
            } catch (final Exception e) {
                exceptions.add(e);
            }
        }
        if (!exceptions.isEmpty()) {
            throw new AggregatedException(exceptions);
        }
        return function.apply(args);
    }


    @SuppressWarnings("unchecked")
    public static <T1, T2, T> T exceptionAggregator(
            BiFunction<T1, T2, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2);
    }
}
