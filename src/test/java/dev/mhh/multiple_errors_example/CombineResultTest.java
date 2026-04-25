package dev.mhh.multiple_errors_example;

import dev.mhh.result.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CombineResultTest {
    @Test
    void testCombineResult2() {
        final var result = CombineResult.combine(
                Long::sum,
                Result.ok(123L),
                Result.ok(321L)
        );

        assertTrue(result.isOk());
        assertEquals(444L, result.optionalValue().get());
    }
    @Test
    void testCombineResult3() {
        final var result = CombineResult.combine(
                (x, y, z) -> x + y + z,
                Result.ok(123L),
                Result.ok(321L),
                Result.ok(111L)
        );

        assertTrue(result.isOk());
        assertEquals(555L, result.optionalValue().get());
    }
}
