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

    @Test
    void combineThrow4() throws CombineThrow.AggregatedException {
        final var combined = CombineThrow.exceptionAggregator(
                (t1, t2, t3, t4) -> t1 + t2 + t3 + t4,
                () -> 10L,
                () -> 20L,
                () -> 30L,
                () -> 40L
        );

        assertEquals(100, combined);
    }

    @Test
    void combineThrow5() throws CombineThrow.AggregatedException {
        final var combined = CombineThrow.exceptionAggregator(
                (t1, t2, t3, t4, t5) -> t1 + t2 + t3 + t4 + t5,
                () -> 10L,
                () -> 20L,
                () -> 30L,
                () -> 40L,
                () -> 50L
        );

        assertEquals(150, combined);
    }

    @Test
    void combineThrow6() throws CombineThrow.AggregatedException {
        final var combined = CombineThrow.exceptionAggregator(
                (t1, t2, t3, t4, t5, t6) -> t1 + t2 + t3 + t4 + t5 + t6,
                () -> 10L,
                () -> 20L,
                () -> 30L,
                () -> 40L,
                () -> 50L,
                () -> 60L
        );

        assertEquals(210, combined);
    }
}
