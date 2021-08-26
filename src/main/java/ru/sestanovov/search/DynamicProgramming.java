package ru.sestanovov.search;

import java.util.*;

public class DynamicProgramming {

    private final List<Node> nodes;

    private final int capacity;

    private final List<List<Cell>> table = new ArrayList<>();

    private int index = 0;

    public static class Node {

        private final String name;

        private final int weight;

        private final int cost;

        public Node(String name, int weight, int cost) {
            this.name = name;
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "name='" + name
                    + '\'' + ", weight=" + weight
                    + ", cost=" + cost
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return weight == node.weight
                    && cost == node.cost
                    && Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, weight, cost);
        }
    }

    public static class Cell {

        private final int sum;

        private final Set<Node> nodes;

        public Cell(int sum, Set<Node> nodes) {
            this.sum = sum;
            this.nodes = nodes;
        }

        @Override
        public String toString() {
            return "Cell{"
                    + "sum=" + sum
                    + ", nodes=" + nodes
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cell cell = (Cell) o;
            return sum == cell.sum
                    && Objects.equals(nodes, cell.nodes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, nodes);
        }
    }

    public DynamicProgramming(int capacity, List<Node> nodes) {
        validate(capacity);
        this.capacity = capacity;
        this.nodes = new ArrayList<>(nodes);
        for (int i = 0; i < nodes.size(); i++) {
            addRow();
        }
    }

    public void add(Node node) {
        this.nodes.add(node);
        addRow();
    }

    public Cell getBestCombination() {
        while (index < nodes.size()) {
            List<Cell> currentRow = table.get(index);
            Node currentNode = nodes.get(index);
            List<Cell> lastRow = null;
            if (index > 0) {
                lastRow = table.get(index - 1);
            }
            for (int c = 0; c < capacity; c++) {
                int weight = c + 1;
                int sum = 0;
                Set<Node> nodes = new HashSet<>();
                if (weight >= currentNode.weight) {
                    weight -= currentNode.weight;
                    sum += currentNode.cost;
                    nodes.add(currentNode);
                }
                if (weight > 0 && lastRow != null) {
                    Cell cell = lastRow.get(weight - 1);
                    sum += cell.sum;
                    nodes.addAll(cell.nodes);
                }
                if (lastRow != null) {
                    Cell lastCell = lastRow.get(c);
                    if (lastCell.sum > sum) {
                        sum = lastCell.sum;
                        nodes.clear();
                        nodes.addAll(lastCell.nodes);
                    }
                }
                currentRow.add(new Cell(sum, nodes));
            }
            index++;
        }
        return index == 0
                ? new Cell(0, Set.of())
                : table.get(index - 1).get(capacity - 1);
    }

    private void validate(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Invalid capacity!");
        }
    }

    private void addRow() {
        table.add(new ArrayList<>(capacity));
    }
}
