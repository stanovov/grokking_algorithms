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

    public static void main(String[] args) {
        SimpleGraph g1 = new SimpleGraph("Boris", List.of());
        SimpleGraph g2 = new SimpleGraph("Rudulf", List.of(
                new SimpleGraph("Robert", List.of())
        ));
        SimpleGraph g3 = new SimpleGraph("Semyon", List.of(g1, g2));
        boolean rsl = new BreadthFirstSearch<SimpleGraph>().find(
                g3,
                graph -> graph.getName().equals("Rudulf")
        );
        System.out.println(rsl);
    }
}
