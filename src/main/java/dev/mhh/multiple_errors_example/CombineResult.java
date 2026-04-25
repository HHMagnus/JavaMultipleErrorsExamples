package dev.mhh.multiple_errors_example;

import dev.mhh.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class CombineResult {
    public interface VarFunction<T> {
        T apply(Object... args);
    }

    @SafeVarargs
    public static <T, E> Result<T, List<E>> combine(
            VarFunction<T> function,
            Result<Object, E>... resultArgs
    ) {
        final var args = new Object[resultArgs.length];
        final var errors =  new ArrayList<E>();
        for (int i = 0; i < resultArgs.length; i++) {
            final var arg = resultArgs[i];
            int finalI = i;
            arg.consume(object -> args[finalI] = object)
                    .consumeError(errors::add);
        }
        if (!errors.isEmpty()) {
            return Result.err(errors);
        }
        return Result.ok(function.apply(args));
    }

    @SuppressWarnings("unchecked")
    public static <T1, T2, T, E> Result<T, List<E>> combine(
            BiFunction<T1, T2, T> function,
            Result<T1, E> result1,
            Result<T2, E> result2
    ) {
        final VarFunction<T> varFunction = (args) -> function.apply((T1)args[0], (T2)args[1]);
        return combine(varFunction, (Result<Object, E>) result1, (Result<Object, E>) result2);
    }
}
