package com.ny.model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public int value;
    public List<GraphNode> adjacent;

    public GraphNode(int value) {
        this.value = value;
        this.adjacent = new ArrayList<>();
    }

    public GraphNode(int value, List<GraphNode> adjacent) {
        this.value = value;
        this.adjacent = adjacent;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        return value == graphNode.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
