package ru.sestanovov.search;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.junit.Assert.*;

public class GreedyCoverageTest {

    @Test
    public void whenGreedyAlgorithmIsUsedToFindCoverage() {
        Set<String> statesNeeded = Set.of("MT", "WA", "OR", "ID", "NV", "UT", "CA", "AZ");
        Map<String, Set<String>> stations = Map.of(
                "kone", Set.of("ID", "NV", "UT"),
                "ktwo", Set.of("WA", "ID", "MT"),
                "kthree", Set.of("OR", "NV", "CA"),
                "kfour", Set.of("NV", "UT"),
                "kfive", Set.of("CA", "AZ")
        );
        GreedyCoverage greedy = new GreedyCoverage();
        Set<String> result = greedy.find(statesNeeded, stations);
        Set<String> expected1 = Set.of("kone", "ktwo", "kthree", "kfive");
        Set<String> expected2 = Set.of("ktwo", "kthree", "kfour", "kfive");
        assertThat(result, anyOf(is(expected1), is(expected2)));
    }
}