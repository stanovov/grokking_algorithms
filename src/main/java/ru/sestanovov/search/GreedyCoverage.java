package ru.sestanovov.search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyCoverage {

    public Set<String> find(Set<String> needed, Map<String, Set<String>> mapV) {
        Set<String> result = new HashSet<>();
        Set<String> neededSet = new HashSet<>(needed);
        while (!neededSet.isEmpty()) {
            String bestV =  null;
            Set<String> vCovered = new HashSet<>();
            for (Map.Entry<String, Set<String>> entry : mapV.entrySet()) {
                String v = entry.getKey();
                Set<String> covered = new HashSet<>(entry.getValue());
                covered.retainAll(neededSet);
                if (covered.size() > vCovered.size()) {
                    bestV = v;
                    vCovered = covered;
                }
            }
            neededSet.removeAll(vCovered);
            result.add(bestV);
        }
        return result;
    }

    public static void main(String[] args) {
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
        System.out.println(result);
    }

}
