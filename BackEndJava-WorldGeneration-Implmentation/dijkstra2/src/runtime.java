import dijkstra.Algo;
import dijkstra.Graph;

public class runtime {

    public static void main(String[] args) {
        //stealing graph from computerfile for testing
        Graph overall = new Graph();
        overall.addEdgeNamed("S","A", 7);
        overall.addEdgeNamed("S", "B", 2);
        overall.addEdgeNamed("A", "B", 3);
        overall.addEdgeNamed("A", "D", 4);
        overall.addEdgeNamed("B", "D", 4);
        overall.addEdgeNamed("D", "F", 5);
        overall.addEdgeNamed("F", "H", 3);
        overall.addEdgeNamed("B", "H", 1);
        overall.addEdgeNamed("H", "G", 2);
        overall.addEdgeNamed("H", "E", 2);
        overall.setStartingVertex("E");
        Algo.DijkstraRuntime(overall, "E");
        System.out.println("Time taken is: " + overall.getCostForNamedPoint("E"));
    }

}
