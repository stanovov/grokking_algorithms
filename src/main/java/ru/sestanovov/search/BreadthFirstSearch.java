package ru.sestanovov.search;

import java.util.*;
import java.util.function.Predicate;

public class BreadthFirstSearch<T extends Graph> {

    public boolean find(Graph t, Predicate<T> p) {
        boolean result = false;
        Deque<Graph> deque = new ArrayDeque<>(t.getList());
        Set<Graph> searched = new HashSet<>();
        while (!deque.isEmpty()) {
            Graph g = deque.pop();
            if (!searched.contains(t)) {
                if (p.test((T) g)) {
                    result = true;
                    break;
                } else {
                    deque.addAll(g.getList());
                    searched.add(g);
                }
            }
        }
        return result;
    }
}
