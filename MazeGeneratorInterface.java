




/**
import greenfoot.*; 
import java.util.*;

/ * Write a description of class MazeGeneratorInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeGeneratorInterface  
{
    // instance variables - replace the example below with your own
    private final World thisWorld;
    private Iterator itr; 
    /**
     * Constructor for objects of class MazeGeneratorInterface
     */
    public MazeGeneratorInterface(World world, Iterator itr)
    {
        this.thisWorld = world; 
        this.itr= itr; 
        this.loadWall();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private void loadWall()
    {
        while (this.itr.hasNext())
        {
            Cell c = this.itr.next();
        }
        
    }
}
