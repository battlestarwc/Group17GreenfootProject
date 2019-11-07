import dijkstra.Graph;

public class Runtime {

    public static void main(String[] args) {

        Graph g = new Graph();

        g.addEdge(1,2,7);
        g.addEdge(1,3,2);
        g.addEdge(3,4,1);
        g.addEdge(2,5,4);
        g.addEdge(3,5,4);
        g.addEdge(5,6,5);
        g.addEdge(6,7,2);
        g.addEdge(7,8,2);
        g.setStartingNode(1);

        System.out.println(g.getShortestPath(8));

    }

}
