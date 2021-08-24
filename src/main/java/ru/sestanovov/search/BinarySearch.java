package ru.sestanovov.search;

import java.util.Comparator;
import java.util.Objects;

public class BinarySearch<T> implements LookingForInArray<T> {

    @Override
    public int find(T[] array, T item, Comparator<? super T> c) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            T guess = array[mid];
            int r = Objects.compare(guess, item, c);
            if (r == 0) {
                return mid;
            } else if (r > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
