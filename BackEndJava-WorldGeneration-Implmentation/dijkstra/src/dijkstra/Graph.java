package dijkstra;

import java.util.Vector;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

public class Graph {

    private Vector<Edge> edges;
    private PriorityQueue<Node> tracks;

    public Graph() {
        this.edges = new Vector<>();
        this.tracks = new PriorityQueue<>();
    }

    public void addEdge(int f, int t, double c) {
        this.edges.add(new Edge(f,t,c));
    }

    public void setStartingNode(int node) throws RuntimeException {
        Iterator<Edge> itr = this.edges.iterator();
        while(itr.hasNext()) {
            Edge e = itr.next();
            if (e.getFrom() == node) {
                Node n = new Node();
                n.addToPath(node, 0);
                this.tracks.add(n);
                return;
            }
        }
        throw new RuntimeException("No such starting node exists");
    }

    private void solve(int targetNode) {
        do {
            Node node = this.tracks.poll();
            Stack<Edge> connections = this.getEdges(node.getLastVisited());
            if(connections.empty()) {
                continue;
            }
            Vector<Node> newNodes = new Vector<>();
            while(!connections.isEmpty()) {
                newNodes.add(new Node(node, connections.pop()));
            }
            Stack<Node> nnodes = this.pruneNewNodes(newNodes);
            while(!nnodes.isEmpty()) {
                this.tracks.add(nnodes.pop());
            }
        } while(!this.edges.isEmpty() && !this.reached(targetNode));
    }

    public double getShortestPath(int target) {
        this.solve(target);
        return this.tracks.poll().getCost();
    }

    private Stack<Edge> getEdges(int from) {
        Stack<Edge> output = new Stack<>();
        Iterator<Edge> itr = this.edges.iterator();
        while(itr.hasNext()) {
            Edge e = itr.next();
            if(e.getFrom() == from) {
                output.push(e);
            }
        }
        return output;
    }

    private Stack<Node> pruneNewNodes(Vector<Node> input) {
        Set<Integer> targets = new HashSet<Integer>();
        input.forEach((n) -> targets.add(n.getLastVisited()));
        if(targets.size() < input.size()) {
            Stack<Node> output = new Stack<>();
            Iterator<Integer> itr = targets.iterator();
            while(itr.hasNext()) {
                Integer to = itr.next();
                Node shortest = null;
                Iterator<Node> vItr = input.iterator();
                while(vItr.hasNext()) {
                    if(shortest == null) {
                        shortest = vItr.next();
                    } else {
                        Node n = vItr.next();
                        if (n.getCost() < shortest.getCost()) {
                            shortest = n;
                        }
                    }
                }
                output.push(shortest);
            }
            return output;
        }

        Stack<Node> output = new Stack<>();
        Iterator<Node> itr = input.iterator();
        while(itr.hasNext()) {
            output.push(itr.next());
        }

        return output;

    }

    private boolean reached(int target) {
        for( Object o :this.tracks.toArray() ){
            Node n = (Node) o;
            if (n.getLastVisited() == target) {
                return true;
            }
        }
        return false;
    }

}