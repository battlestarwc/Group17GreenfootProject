package dijkstra;

import java.util.Vector;

public class Node implements Comparable<Node> {

    private Path optimalPath;

    public Node() {
        this.optimalPath = new Path();
    }

    public Node(Node last, Edge connection) {
        this.optimalPath = new Path(last.getPath());
        this.addToPath(connection.getTo(), connection.getCost());
    }

    public void addToPath(int node, double cost) {
        this.optimalPath.addToPath(node, cost);
    }

    public double getCost() {
        return this.optimalPath.getCost();
    }

    public Vector<Integer> getPathRoute() {
        return this.optimalPath.getPath();
    }

    public Integer getLastVisited() {
        return this.optimalPath.returnLast();
    }

    public Path getPath() {
        return this.optimalPath;
    }

    @Override
    public int compareTo(Node o) {
        return (this.getCost() <= o.getCost()) ? -1 : 1;
    }
}