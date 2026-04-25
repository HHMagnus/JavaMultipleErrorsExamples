package dev.mhh.multiple_errors_example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombineThrowTest {
    @Test
    void combineThrow2() throws CombineThrow.AggregatedException {
        final var combined = CombineThrow.exceptionAggregator(
                Long::sum,
                () -> 10L,
                () -> 20L
        );

        assertEquals(30, combined);
    }
    @Test
    void combineThrow3() throws CombineThrow.AggregatedException {
        final var combined = CombineThrow.exceptionAggregator(
                (t1, t2, t3) -> t1 + t2 + t3,
                () -> 10L,
                () -> 20L,
                () -> 30L
        );

        assertEquals(60, combined);
    }
}
