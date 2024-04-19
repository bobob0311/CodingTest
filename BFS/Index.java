package BFS;

import java.util.*;

class Node {
    String name;
    List<Node> links;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    void link(Node node) {
        links.add(node);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    void visit() {
        this.visited = true;
    }

    boolean isVisited() {
        return this.visited;
    }

}

public class Index {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        c.link(b);
        c.link(d);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;

        Queue<Node> que = new LinkedList<>();
        que.offer(a);

        while (!que.isEmpty()) {
            Node n = que.poll();
            n.visit();
            if (n.equals(target)) {
                break;
            }
            for (Node l : n.links) {
                if (l.isVisited())
                    continue;
                if (que.contains(l))
                    continue;
                que.offer(l);
            }
        }
    }
}
