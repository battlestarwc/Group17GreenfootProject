package dijkstra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class OverallTests {

    @Test
    public void createEdges() {
        Random r = new Random();
        Graph g = new Graph();
        for (int i = 0; i < 100; i++) {
            g.addEdgeNumeric(i, r.nextInt() % 100, r.nextDouble());
        }
        Vertex a = g.getGraphVertices().firstElement();
        Vertex b = g.getGraphVertices().lastElement();
        for (Edge e : g.getGraphEdges()) {
            if (e.getVertexFrom().idEquals(a)) {
                Assert.assertTrue("Testing Ailasing", e.getVertexFrom() == a);
            }
            if (e.getVertexTo().idEquals(a)) {
                Assert.assertTrue("Testing Ailasing", e.getVertexTo() == a);
            }
            if (e.getVertexFrom().idEquals(b)) {
                Assert.assertTrue("Testing Ailasing", e.getVertexFrom() == b);
            }
            if (e.getVertexTo().idEquals(b)) {
                Assert.assertTrue("Testing Ailasing", e.getVertexTo() == b);
            }
        }
    }

}
