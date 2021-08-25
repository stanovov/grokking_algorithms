package ru.sestanovov.search;

import java.util.List;
import java.util.Objects;

public class SimpleGraph implements Graph {

    private final String name;

    private final List<Graph> list;

    public SimpleGraph(String name, List<Graph> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Graph> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleGraph graph = (SimpleGraph) o;
        return Objects.equals(name, graph.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
