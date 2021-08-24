package ru.sestanovov.search;

import java.util.Comparator;

public interface LookingForInArray<T> {
    int find(T[] array, T item, Comparator<? super T> c);
}
