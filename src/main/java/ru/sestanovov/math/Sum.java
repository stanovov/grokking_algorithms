package ru.sestanovov.math;

public class Sum {

    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    private int sum(int[] arr, int i) {
        if ((arr.length - i) == 0) {
            return 0;
        }
        return arr[i] + sum(arr, i + 1);
    }
}
