





import greenfoot.*; 
import java.util.*;

/* Write a description of class MazeGeneratorInterface here.
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
    private void loadWall() throws RuntimeException
    {
        while (this.itr.hasNext())
        {
            Object o = this.itr.next();
            if (!(o instanceof Cell)) {
                throw new RuntimeException("Unable to trust iterator");
            }
            Cell c = (Cell) o;
            
            int x = c.getX();
            int y = c.getY();
            
            //Now map the maze X and Y values to greenfoot X and Y values
            //Center is 127,127 for maze and 300,300 for greenfoot
            //Lets assume that a Wall is 50 by 50 
            //So maze 126,126 would map to 250,250 for greenfoot
            
            
            this.thisWorld.addObject(new Wall(), x, y);

        }
        
    }
}
