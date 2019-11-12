package dijkstra;

public class Edge {

    private Integer nodeFrom;
    private Integer nodeTo;
    private double cost;

    public Edge(int from, int to, double cost) {
        this.nodeFrom = from;
        this.nodeTo = to;
        this.cost = cost;
    }

    public double getCost() {
        return this.cost;
    }

    public Integer getFrom() {
        return this.nodeFrom;
    }

    public Integer getTo() {
        return this.nodeTo;
    }

}