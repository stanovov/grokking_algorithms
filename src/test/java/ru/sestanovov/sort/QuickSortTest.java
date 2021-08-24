package ru.sestanovov.sort;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void whenQuickSortInArrayOfNumbers() {
        Integer[] array = {5, 3, 6, 2, 10};
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(array, Comparator.naturalOrder());
        Integer[] expected = {2, 3, 5, 6, 10};
        assertArrayEquals(array, expected);
    }

    @Test
    public void whenQuickSortInArrayOfStrings() {
        String[] array = {"B", "C", "A"};
        QuickSort<String> quickSort = new QuickSort<>();
        quickSort.sort(array, Comparator.naturalOrder());
        String[] expected = {"A", "B", "C"};
        assertArrayEquals(array, expected);
    }
}