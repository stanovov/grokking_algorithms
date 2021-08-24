package ru.sestanovov.math;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SumTest {

    @Test
    public void whenSeveralNumberInArray() {
        int[] arr = {1, 2, 3, 2, 1};
        int excepted = 9;
        int result = new Sum().sum(arr);
        assertThat(result, is(excepted));
    }

    @Test
    public void whenEmptyArray() {
        int expected = 0;
        int result = new Sum().sum(new int[]{});
        assertThat(result, is(expected));
    }
}