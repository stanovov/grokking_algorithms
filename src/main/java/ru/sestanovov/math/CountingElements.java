package ru.sestanovov.math;

public class CountingElements<T> {

    public int counting(T[] arr) {
        return counting(arr, 0);
    }

    private int counting(T[] arr, int i) {
        if (arr.length == i) {
            return i;
        }
        return counting(arr, i + 1);
    }
}
