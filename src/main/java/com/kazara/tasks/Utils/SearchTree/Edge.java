package com.kazara.tasks.Utils.SearchTree;

public class Edge implements Comparable<Edge> {
    public Character label;
    private Node parent, child;
    public Edge(char label, Node parent, Node child) {
        this.label = label;
        this.parent = parent;
        this.child = child;
    }
    public Edge() {

    }
    public Character getData() {
        return label;
    }


    @Override
    public int compareTo(Edge o) {
        return Character.compare(this.label,o.label);
    }

    public Node getChild() {
        return child;
    }

    public Node getParent() {
        return parent;
    }
}
