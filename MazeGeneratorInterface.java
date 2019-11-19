





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
            
            //The way to read this:
            //if NOT c is a wall (such that c.isWall() == True -> False)
            //then continue (which causes the parent while loop to rerun)
            if (!c.isWall()) {
                continue;
            }
            int x = c.getX();
            int y = c.getY();
            
            //Now map the maze X and Y values to greenfoot X and Y values
            //Center is 127,127 for maze and 300,300 for greenfoot
            //Lets assume that a Wall is 50 by 50 
            //So maze 126,126 would map to 250,250 for greenfoot
            int deltaX = Math.abs(x - 127) * 50;
            if(x < 127) {
                deltaX *= -1;
                //is the same as deltaX = deltaX * -1;
            }
            x = deltaX;
            /*
             * This is the same as 
             * int deltaX = (x - 127) * 50;
             * Which is also the same as 
             * x += (x - 127) * 50;
             * Which is also the same as
             * x += (x - 127 >= 0) ? -50 * Math.abs(x - 127) : 50 * Math.abs(x - 127);
             */
             int deltaY = Math.abs(y -127) * 50; 
             if (y < 127)
             {
                 deltaY *= -1;
             }
             y = deltaY;
             if((x > -25 && x < 25) || (y > -25 && y < 25)) {
                 continue;
                }
            this.thisWorld.addObject(new Wall(), x, y);

        }
        
    }
}
