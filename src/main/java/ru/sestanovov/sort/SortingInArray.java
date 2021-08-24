package ru.sestanovov.sort;

import java.util.Comparator;

public interface SortingInArray<T> {
    void sort(T[] arr, Comparator<? super T> comparator);
}
