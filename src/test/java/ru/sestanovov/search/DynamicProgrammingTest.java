package ru.sestanovov.search;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicProgrammingTest {

    @Test
    public void WhenGetBestCombination() {
        DynamicProgramming.Node water = new DynamicProgramming.Node("Вода", 3, 10);
        DynamicProgramming.Node book = new DynamicProgramming.Node("Книга", 1, 3);
        DynamicProgramming.Node food = new DynamicProgramming.Node("Еда", 2, 9);
        DynamicProgramming.Node jacket = new DynamicProgramming.Node("Куртка", 2, 5);
        DynamicProgramming.Node camera = new DynamicProgramming.Node("Камера", 1, 6);
        List<DynamicProgramming.Node> things = List.of(water, book, food, jacket, camera);
        DynamicProgramming dynamic = new DynamicProgramming(6, things);
        DynamicProgramming.Cell expected = new DynamicProgramming.Cell(
                25,
                Set.of(water, food, camera)
        );
        DynamicProgramming.Cell result = dynamic.getBestCombination();
        assertThat(result, is(expected));
    }
}