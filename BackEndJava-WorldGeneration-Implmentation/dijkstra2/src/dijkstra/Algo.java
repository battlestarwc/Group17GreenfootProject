package dijkstra;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Algo {

    public static boolean DijkstraRuntime(Graph input) {
        loadPriorityQueue(input);
        while(!input.toBeSolved.isEmpty()) {
            Vertex target = input.toBeSolved.remove();
            PriorityQueue<Vertex> neighbors = getNeighbors(input, target);
            while(!neighbors.isEmpty()) {
                Edge edg = getEdge(input, target, neighbors.remove());
                if (edg == null) {
                    continue;
                }
                UpdateMap(input, edg);
            }
        }
        return false;
    }

    private static void loadPriorityQueue(Graph input) {
        Iterator<Vertex> itr = input.getGraphVertices().iterator();
        while(itr.hasNext()) {
            input.toBeSolved.add(itr.next());
        }
    }

    private static PriorityQueue<Vertex> getNeighbors(Graph in, Vertex target) {
        PriorityQueue<Vertex> output = new PriorityQueue<>();
        Iterator<Edge> itr = in.getGraphEdges().iterator();
        while (itr.hasNext()) {
            Edge e = itr.next();
            if (e.getVertexFrom().idEquals(target)) {
                output.add(e.getVertexTo());
            }
        }
        return output;
    }

    private static Edge getEdge(Graph in, Vertex targetIn, Vertex targetOut) {
        for (Edge e : in.getGraphEdges()) {
            if(e.getVertexFrom().idEquals(targetIn) && e.getVertexTo().idEquals(targetOut)) {
                return e;
            }
        }
        return null;
    }

    public static void UpdateMap(Graph in, Edge edg) {
        if(!in.minimalCostToVertex.containsKey(edg.getVertexTo())) {
            in.minimalCostToVertex.put(edg.getVertexTo(), edg.getCost());
            return;
        }
        Double currentCost = in.minimalCostToVertex.get(edg.getVertexTo());
        Double consideringCost = in.minimalCostToVertex.get(edg.getVertexFrom()) + edg.getCost();
        if (currentCost < consideringCost) {
            edg.getVertexTo().setLastVertex(edg.getVertexFrom(), consideringCost);
            in.minimalCostToVertex.put(edg.getVertexTo(), consideringCost);
        }
    }

}
