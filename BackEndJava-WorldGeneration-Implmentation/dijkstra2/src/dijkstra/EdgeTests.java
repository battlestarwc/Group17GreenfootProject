package dijkstra;

import org.junit.Assert;
import org.junit.Test;

public class EdgeTests {

    @Test public void compareToTest() {
        Edge a = new Edge(1,2,1);
        Edge b = new Edge(1,2,1);

        //test equals to
        Assert.assertEquals("Test equal compare to", 0, a.compareTo(b));

        a = new Edge(1,2,5);
        b = new Edge(1,2,3);

        //test greater than
        Assert.assertEquals("Test greater than", 1, a.compareTo(b));
        //test less than
        Assert.assertEquals("Test less than", -1, b.compareTo(a));
    }

}
