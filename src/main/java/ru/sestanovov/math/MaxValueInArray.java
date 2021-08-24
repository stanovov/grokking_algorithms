package ru.sestanovov.math;

import java.util.Comparator;

public class MaxValueInArray<T> {

    public T maxValue(T[] arr, Comparator<? super T> c) {
        if (arr.length == 0) {
            return null;
        }
        maxValue(arr, c, 1, arr[0]);
        T rsl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (c.compare(rsl, arr[i]) < 0) {
                rsl = arr[i];
            }
        }
        return rsl;
    }

    private T maxValue(T[] arr, Comparator<? super T> c, int i, T rsl) {
        if (arr.length == i) {
            return rsl;
        }
        return maxValue(arr, c, i + 1, c.compare(rsl, arr[i]) > 0 ? rsl : arr[i]);
    }
}
