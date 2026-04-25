package dev.mhh.multiple_errors_example;

import dev.mhh.multiple_errors_example.functions.*;

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
            Function2<T1, T2, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T> T exceptionAggregator(
            Function3<T1, T2, T3, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2,
            Supplier<T3> supplier3
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1], (T3)args[2]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2, (Supplier<Object>) supplier3);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T4, T> T exceptionAggregator(
            Function4<T1, T2, T3, T4, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2,
            Supplier<T3> supplier3,
            Supplier<T4> supplier4
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1], (T3)args[2], (T4)args[3]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2, (Supplier<Object>) supplier3, (Supplier<Object>) supplier4);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T4, T5, T> T exceptionAggregator(
            Function5<T1, T2, T3, T4, T5, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2,
            Supplier<T3> supplier3,
            Supplier<T4> supplier4,
            Supplier<T5> supplier5
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1], (T3)args[2], (T4)args[3], (T5)args[4]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2, (Supplier<Object>) supplier3, (Supplier<Object>) supplier4, (Supplier<Object>) supplier5);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T4, T5, T6, T> T exceptionAggregator(
            Function6<T1, T2, T3, T4, T5, T6, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2,
            Supplier<T3> supplier3,
            Supplier<T4> supplier4,
            Supplier<T5> supplier5,
            Supplier<T6> supplier6
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1], (T3)args[2], (T4)args[3], (T5)args[4], (T6)args[5]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2, (Supplier<Object>) supplier3, (Supplier<Object>) supplier4, (Supplier<Object>) supplier5, (Supplier<Object>) supplier6);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T4, T5, T6, T7, T> T exceptionAggregator(
            Function7<T1, T2, T3, T4, T5, T6, T7, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2,
            Supplier<T3> supplier3,
            Supplier<T4> supplier4,
            Supplier<T5> supplier5,
            Supplier<T6> supplier6,
            Supplier<T7> supplier7
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1], (T3)args[2], (T4)args[3], (T5)args[4], (T6)args[5], (T7)args[6]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2, (Supplier<Object>) supplier3, (Supplier<Object>) supplier4, (Supplier<Object>) supplier5, (Supplier<Object>) supplier6, (Supplier<Object>) supplier7);
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T> T exceptionAggregator(
            Function8<T1, T2, T3, T4, T5, T6, T7, T8, T> function,
            Supplier<T1> supplier1,
            Supplier<T2> supplier2,
            Supplier<T3> supplier3,
            Supplier<T4> supplier4,
            Supplier<T5> supplier5,
            Supplier<T6> supplier6,
            Supplier<T7> supplier7,
            Supplier<T8> supplier8
    ) throws AggregatedException {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1], (T3)args[2], (T4)args[3], (T5)args[4], (T6)args[5], (T7)args[6], (T8)args[7]);
        return exceptionAggregator(varFunction, (Supplier<Object>) supplier1, (Supplier<Object>) supplier2, (Supplier<Object>) supplier3, (Supplier<Object>) supplier4, (Supplier<Object>) supplier5, (Supplier<Object>) supplier6, (Supplier<Object>) supplier7, (Supplier<Object>) supplier8);
    }
}
