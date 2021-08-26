package ru.sestanovov.search;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    @Test
    public void whenBFSUse() {
        SimpleGraph g1 = new SimpleGraph("Boris", List.of());
        SimpleGraph g2 = new SimpleGraph("Rudulf", List.of(
                new SimpleGraph("Robert", List.of())
        ));
        SimpleGraph g3 = new SimpleGraph("Semyon", List.of(g1, g2));
        boolean result = new BreadthFirstSearch<SimpleGraph>().find(
                g3,
                graph -> graph.getName().equals("Rudulf")
        );
        assertTrue(result);
    }
}