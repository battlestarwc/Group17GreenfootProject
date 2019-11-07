package dijkstra;

import java.util.Vector;
import java.util.Iterator;

public class Path implements Comparable<Path> {

    private Vector<Integer> path;
    private double cost;

    public Path() {
        this.path = new Vector<>();
        this.cost = 0.0;
    }

    public Path(Path copy) {
        this.cost = copy.getCost();
        this.path = new Vector<>();
        Iterator<Integer> itr = copy.getPath().iterator();
        while(itr.hasNext()) {
            this.path.add(itr.next());
        }
    }

    public void addToPath(int node, double cost) {
        this.path.add(node);
        this.cost += cost;
    }

    public double getCost() {
        return this.cost;
    }

    public Vector<Integer> getPath() {
        return this.path;
    }

    public Integer returnLast() {
        return this.path.lastElement();
    }

    @Override
    public int compareTo(Path o) {
        return (this.cost <= o.getCost()) ? -1 : 1;
    }
}