package ru.sestanovov.search;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void whenBinarySearchInArrayOfNumbersFound() {
        Integer[] array = new Integer[]{
                1, 3, 5, 7, 9
        };
        BinarySearch<Integer> search = new BinarySearch<>(Comparator.naturalOrder());
        int result = search.find(array, 3);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenBinarySearchInArrayOfNumbersNotFound() {
        Integer[] array = new Integer[]{
                1, 3, 5, 7, 9
        };
        BinarySearch<Integer> search = new BinarySearch<>(Comparator.naturalOrder());
        int result = search.find(array, -1);
        int expected = -1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenEmptyArray() {
        Integer[] array = new Integer[0];
        BinarySearch<Integer> search = new BinarySearch<>(Comparator.naturalOrder());
        int result = search.find(array, -1);
        int expected = -1;
        assertThat(result, is(expected));
    }
}