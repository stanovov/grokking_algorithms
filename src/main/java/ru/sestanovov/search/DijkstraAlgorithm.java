package ru.sestanovov.search;

import java.util.*;

public class DijkstraAlgorithm {

    private final static double INFINITY = Double.POSITIVE_INFINITY;

    private final String startNode;

    private final String finishNode;

    private final Map<String, Map<String, Double>> graph = new HashMap<>();

    private final Map<String, Double> costs = new HashMap<>();

    private final Map<String, String> parents = new HashMap<>();

    private final Set<String> processed = new HashSet<>();

    private boolean done = false;

    public DijkstraAlgorithm(String startNode, String finishNode) {
        this.startNode = startNode;
        this.finishNode = finishNode;
        addToGraph(startNode, new HashMap<>());
        addToGraph(finishNode, new HashMap<>());
    }

    public boolean addToGraph(String node, Map<String, Double> neighbors) {
        if (done) {
            throw new IllegalArgumentException("Search done!");
        }
        graph.put(node, neighbors);
        if (node.equals(startNode)) {
            for (String key : neighbors.keySet()) {
                costs.put(key, neighbors.get(key));
                parents.put(key, node);
            }
        } else {
            costs.putIfAbsent(node, INFINITY);
            if (node.equals(finishNode)) {
                parents.put(node, null);
            }
        }
        return true;
    }

    public boolean isDone() {
        return done;
    }

    public double getResult() {
        validateNotDone();
        return costs.get(finishNode);
    }

    public Deque<String> getWay() {
        validateNotDone();
        Deque<String> way = new ArrayDeque<>();
        way.push(finishNode);
        String node = parents.get(finishNode);
        while (node != null) {
            way.push(node);
            node = parents.get(node);
        }
        return way;
    }

    public double find() {
        done = true;
        String node = findLowestCostNode();
        while (node != null) {
            double cost = costs.get(node);
            Map<String, Double> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                double newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode();
        }
        return costs.get(finishNode);
    }

    private String findLowestCostNode() {
        double lowestCost = INFINITY;
        String lowestCostNode = null;
        for (String node : costs.keySet()) {
            double cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    private void validateNotDone() {
        if (!done) {
            throw new IllegalArgumentException("Search not done!");
        }
    }

    public static void main(String[] args) {
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
        System.out.println(dijkstraAlgorithm.find());
        System.out.println(dijkstraAlgorithm.getWay());
    }
}
