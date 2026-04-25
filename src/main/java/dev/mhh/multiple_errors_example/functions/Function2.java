package dev.mhh.multiple_errors_example.functions;

@FunctionalInterface
public interface Function2<T1, T2, T> {
    T apply(T1 t1, T2 t2);
}
