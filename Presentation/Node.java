package Presentation;

import java.util.Objects;

public class Node {

    String name;

    Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Node && name.equals(((Node) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
