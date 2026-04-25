package dev.mhh.multiple_errors_example;

import dev.mhh.result.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CombineResultTest {
    @Test
    void testCombineResult() {
        final var result = CombineResult.combine(
                Long::sum,
                Result.ok(123L),
                Result.ok(321L)
        );

        assertTrue(result.isOk());
        assertEquals(444L, result.optionalValue().get());
    }
}
