package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    void acceptdivideby2() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        List<Integer> divisible = Arrays.asList(0, 2, 4, 8, 240);
        List<Integer> notDivisible = Arrays.asList(1, 3, 5, 7, 9, 301);

        for (int n : divisible) {
            Assertions.assertTrue(filter.accept(n));
        }

        for (int n : notDivisible) {
            Assertions.assertFalse(filter.accept(n));
        }

    }

    @Test
    void acceptdivideby3() {
        DivisibleByFilter filter = new DivisibleByFilter(3);
        List<Integer> divisible = Arrays.asList(0, 3, 6, 9, 300);
        List<Integer> notDivisible = Arrays.asList(1, 2, 10, 100, 1000, 10000);

        for (int n : divisible) {
            Assertions.assertTrue(filter.accept(n));
        }

        for (int n : notDivisible) {
            Assertions.assertFalse(filter.accept(n));
        }

    }



}
