package ru.sestanovov.search;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DijkstraAlgorithmTest {

    @Test
    public void whenAddToGraphBeforeSearching() {
        DijkstraAlgorithm dijkstraAlgorithm
                = new DijkstraAlgorithm("start", "finish");
        boolean result = dijkstraAlgorithm.addToGraph("a", Map.of());
        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToGraphAfterSearching() {
        DijkstraAlgorithm dijkstraAlgorithm
                = new DijkstraAlgorithm("start", "finish");
        dijkstraAlgorithm.find();
        dijkstraAlgorithm.addToGraph("a", Map.of());
    }

    @Test
    public void whenSearchIsOver() {
        DijkstraAlgorithm dijkstraAlgorithm
                = new DijkstraAlgorithm("start", "finish");
        dijkstraAlgorithm.find();
        boolean result = dijkstraAlgorithm.isDone();
        assertTrue(result);
    }

    @Test
    public void whenSearchingIsNotOver() {
        DijkstraAlgorithm dijkstraAlgorithm
                = new DijkstraAlgorithm("start", "finish");
        boolean result = dijkstraAlgorithm.isDone();
        assertFalse(result);
    }

    @Test
    public void whenFirstGraphOptionThenResult6() {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(
                "start", "finish"
        );
        dijkstraAlgorithm.addToGraph("start", new HashMap<>(
                Map.of("a", 6.0, "b", 2.0)
        ));
        dijkstraAlgorithm.addToGraph("a", new HashMap<>(
                Map.of("finish", 1.0)
        ));
        dijkstraAlgorithm.addToGraph("b", new HashMap<>(
                Map.of("a", 3.0, "finish", 5.0)
        ));
        double result = dijkstraAlgorithm.find();
        double expected = 6.0;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondGraphOptionThenResult6() {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(
                "start", "finish"
        );
        dijkstraAlgorithm.addToGraph("start", new HashMap<>(
                Map.of("a", 5.0, "b", 2.0)
        ));
        dijkstraAlgorithm.addToGraph("a", new HashMap<>(
                Map.of("c", 4.0, "d", 2.0)
        ));
        dijkstraAlgorithm.addToGraph("b", new HashMap<>(
                Map.of("a", 8.0, "d", 7.0)
        ));
        dijkstraAlgorithm.addToGraph("c", new HashMap<>(
                Map.of("d", 6.0, "finish", 3.0)
        ));
        dijkstraAlgorithm.addToGraph("d", new HashMap<>(
                Map.of("finish", 1.0)
        ));
        double result = dijkstraAlgorithm.find();
        double expected = 8.0;
        assertThat(result, is(expected));
    }

    @Test
    public void whenThirdGraphOptionThenResult6() {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(
                "start", "finish"
        );
        dijkstraAlgorithm.addToGraph("start", new HashMap<>(
                Map.of("a", 10.0)
        ));
        dijkstraAlgorithm.addToGraph("a", new HashMap<>(
                Map.of("b", 20.0)
        ));
        dijkstraAlgorithm.addToGraph("b", new HashMap<>(
                Map.of("finish", 30.0, "c", 1.0)
        ));
        dijkstraAlgorithm.addToGraph("c", new HashMap<>(
                Map.of("a", 1.0)
        ));
        double result = dijkstraAlgorithm.find();
        double expected = 60.0;
        assertThat(result, is(expected));
    }

}