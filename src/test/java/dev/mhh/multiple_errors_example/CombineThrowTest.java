package dev.mhh.multiple_errors_example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombineThrowTest {
    @Test
    void combineThrow() throws CombineThrow.AggregatedException {
        final var combined = CombineThrow.exceptionAggregator(
                Long::sum,
                () -> 10L,
                () -> 20L
        );

        assertEquals(30, combined);
    }
}
