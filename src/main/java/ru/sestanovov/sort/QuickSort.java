package ru.sestanovov.sort;

import java.util.Comparator;

public class QuickSort<T> implements SortingInArray<T> {
    @Override
    public void sort(T[] arr, Comparator<? super T> c) {
        quickSort(arr, c, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, Comparator<? super T> c, int low, int high) {
        if (low < high) {
            int pi = partition(arr, c, low, high);
            quickSort(arr, c, low, pi - 1);
            quickSort(arr, c, pi + 1, high);
        }
    }

    private int partition(T[] arr, Comparator<? super T> c, int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (c.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
