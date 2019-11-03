package dijkstra;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.Iterator;

public class Graph {
    //ALL EDGES AND VERTICES IN THE GRAPH
    private Vector<Edge> graphEdges;
    private Vector<Vertex> graphVertices;

    //hash map of shortest points
    public HashMap<Vertex,Double> minimalCostToVertex;

    //Priority Queue
    public PriorityQueue<Vertex> toBeSolved;

    public Graph() {
        this.graphEdges = new Vector<>();
        this.graphVertices = new Vector<>();
        this.minimalCostToVertex = new HashMap<>();
        this.toBeSolved = new PriorityQueue<>();
    }

    private void addEdge(Vertex from, Vertex to, double cost) {
        this.graphEdges.add(new Edge(from, to, cost));
    }

    public void addEdgeNumeric(int from, int to, double cost) {
        Vertex vFrom = null;
        Vertex vTo = null;
        boolean fromExists = false;
        boolean toExists   = false;
        Iterator<Vertex> itr = this.graphVertices.iterator();
        while(itr.hasNext()) {
            Vertex e = itr.next();;
            if (e.getId() == from) {
                vFrom = e;
                fromExists = true;
                continue;
            }
            if (e.getId() == to) {
                vTo = e;
                toExists = true;
                continue;
            }
        }
        if (!fromExists) {
            vFrom = new Vertex(from);
            this.graphVertices.add(vFrom);
        }
        if (!toExists) {
            vTo = new Vertex(to);
            this.graphVertices.add(vTo);
        }
        this.addEdge(vFrom, vTo, cost);
    }

    public void addEdgeNamed(String from, String to, double cost) {
        Vertex vFrom = null;
        Vertex vTo = null;
        boolean fromExists = false;
        boolean toExists   = false;
        Iterator<Vertex> itr = this.graphVertices.iterator();
        while(itr.hasNext()) {
            Vertex e = itr.next();;
            if (e.getName().equals(from)) {
                vFrom = e;
                fromExists = true;
                continue;
            }
            if (e.getName().equals(to)) {
                vTo = e;
                toExists = true;
                continue;
            }
        }
        if (!fromExists) {
            vFrom = new Vertex(from);
            this.graphVertices.add(vFrom);
        }
        if (!toExists) {
            vTo = new Vertex(to);
            this.graphVertices.add(vTo);
        }
        this.addEdge(vFrom, vTo, cost);
    }

    public boolean setStartingVertex(String start) {
        Iterator<Vertex> itr = this.graphVertices.iterator();
        while(itr.hasNext()) {
            Vertex v = itr.next();
            if (v.getName().equals(start)) {
                return this.setStartingVertex(v);
            }
        }
        return false;
    }

    public boolean setStartingVertex(int start) {
        Iterator<Vertex> itr = this.graphVertices.iterator();
        while(itr.hasNext()) {
            Vertex v = itr.next();
            if(v.getId() == start) {
                return this.setStartingVertex(v);
            }
        }
        return false;
    }

    public boolean setStartingVertex(Vertex start) {
       start.setLastVertex(start,0);
       return (start.getCost() == 0) ? true : false;
    }

    public Vector<Edge> getGraphEdges() {
        return graphEdges;
    }

    public Vector<Vertex> getGraphVertices() {
        return graphVertices;
    }

    public double getCostForNamedPoint(String vertex) {
        Vertex target = null;
        for (Vertex v : this.getGraphVertices()) {
            if (v.getName().equals(vertex)) {
                target = v;
                break;
            }
        }
        if (target == null) {
            return -1;
        }
        return this.minimalCostToVertex.get(target);
    }

}
