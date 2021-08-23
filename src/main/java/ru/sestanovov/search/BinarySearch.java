package ru.sestanovov.search;

import java.util.Comparator;
import java.util.Objects;

public class BinarySearch<T> implements LookingForInArray<T> {

    private final Comparator<? super T> comparator;

    public BinarySearch(Comparator<? super  T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int find(T[] array, T item) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            T guess = array[mid];
            if (Objects.equals(guess, item)) {
                return mid;
            } else if (Objects.compare(guess, item, comparator) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
