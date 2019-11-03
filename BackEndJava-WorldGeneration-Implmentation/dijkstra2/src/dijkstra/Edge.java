package dijkstra;

public class Edge implements Comparable<Edge>{

    private final String vertexFromName;
    private final Integer vertexFromId;
    private final Vertex vertexFrom;

    private final String vertexToName;
    private final Integer vertexToId;
    private final Vertex vertexTo;

    private final Double cost;


    public Edge(Vertex from, Vertex to, double cost) {
        this.vertexFrom = from;
        this.vertexTo = to;
        this.cost = cost;
        //individual elements
        this.vertexFromName = this.vertexFrom.getName();
        this.vertexFromId = this.vertexFrom.getId();
        this.vertexToName = this.vertexTo.getName();
        this.vertexToId = this.vertexTo.getId();
    }

    public Edge(int from, int to, double cost) {
        this.vertexToName = null;
        this.vertexFromName = null;
        this.vertexFromId = from;
        this.vertexToId = to;
        this.cost = cost;
        this.vertexFrom = new Vertex(from);
        this.vertexTo = new Vertex(to);
    }

    public Edge(String from, String to, double cost) {
        this.vertexToName = new String(to);
        this.vertexFromName = new String(from);
        this.vertexFromId = -1;
        this.vertexToId = -1;
        this.cost = cost;
        this.vertexFrom = new Vertex(from);
        this.vertexTo = new Vertex(to);
    }

    public Double getCost() {
        return cost;
    }

    public Integer getVertexFromId() {
        return vertexFromId;
    }

    public Integer getVertexToId() {
        return vertexToId;
    }

    public String getVertexFromName() {
        return vertexFromName;
    }

    public String getVertexToName() {
        return vertexToName;
    }

    public Vertex getVertexFrom() {
        return vertexFrom;
    }

    public Vertex getVertexTo() {
        return vertexTo;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.cost.equals(o.getCost())) {
            return 0;
        }
        return (this.cost < o.getCost()) ? -1 : 1;
    }
}
