package ru.sestanovov.math;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxValueInArrayTest {
    @Test
    public void whenSeveralNumbersInArray() {
        Integer[] numbers = {1, 2, 3, 22, 3, 2, 1};
        Integer excepted = 22;
        MaxValueInArray<Integer> maxValue = new MaxValueInArray<>();
        Integer result = maxValue.maxValue(numbers, Comparator.naturalOrder());
        assertThat(result, is(excepted));
    }
}