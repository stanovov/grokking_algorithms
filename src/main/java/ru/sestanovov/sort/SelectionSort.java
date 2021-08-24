package ru.sestanovov.sort;

import java.util.Comparator;

public class SelectionSort<T> implements SortingInArray<T> {
    @Override
    public void sort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            T tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }
}
