package dijkstra;

import org.junit.Assert;
import org.junit.Test;

public class VertexTests {

    @Test
    public void testCompareTo() {
        Vertex a = new Vertex("One", 1);
        Vertex b = new Vertex("Two", 2);
        Vertex c = new Vertex("Three", 3);
        Vertex d = new Vertex("Four", 4);

        //test greater than
        a.setLastVertex(2, 25);
        b.setLastVertex(4,15);
        Assert.assertEquals("Testing Vertex compare to greater than", 1, a.compareTo(b));

        //test equal two
        c.setLastVertex(2,25);
        Assert.assertEquals("Testing Vector compare to equivalence", 0, a.compareTo(c));

        //test unset second
        Assert.assertEquals("Testing unset Vector equivalence", 1, a.compareTo(d));

        //test less than
        d.setLastVertex(2, 100);
        Assert.assertEquals("Testing Vector compare to less than", -1, a.compareTo(d));
    }

    @Test public void testEquals() {
        Vertex a = new Vertex(null, 1);
        Vertex b = new Vertex(null, 1);
        Vertex c = new Vertex(null, 2);
        Assert.assertTrue("Testing equals Vector, null, set id", a.equals(b));
        Assert.assertFalse("Testing equals Vector, null, 2 ids", a.equals(c));

        a = new Vertex("One");
        b = new Vertex("One");
        c = new Vertex("Two");
        Assert.assertTrue("Testing equals Vector, set, no id", a.equals(b));
        Assert.assertFalse("Testing equals Vector, 2 names, no id", a.equals(c));

        a = new Vertex("One",1);
        b = new Vertex("One",2);
        c = new Vertex("Two", 1);
        Assert.assertFalse("Testing equals Vector, same name, different ID", a.equals(b));
        Assert.assertFalse("Testing equals Vector, difference name, same ID", a.equals(c));

        a = new Vertex("One",1);
        b = new Vertex(null,1);
        Assert.assertFalse("Testing equals Vector, null strings", a.equals(b));

        b = new Vertex("One",1);
        a.setLastVertex(1,50);
        b.setLastVertex(1,50);
        Assert.assertTrue("Testing equals Vector, with history", a.equals(b));
    }

}
