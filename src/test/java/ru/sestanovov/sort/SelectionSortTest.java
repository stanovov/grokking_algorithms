package ru.sestanovov.sort;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void whenSelectionSortInArrayOfNumbers() {
        Integer[] array = {5, 3, 6, 2, 10};
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(array, Comparator.naturalOrder());
        Integer[] expected = {2, 3, 5, 6, 10};
        assertArrayEquals(array, expected);
    }
}