import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class door extends Counter
{   
    private int score = 0;
    /**
     * Act - do whatever the door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(200,100);
        GreenfootImage key = new GreenfootImage("door.png");
        calculateScore();
        getWin();// A// Add your action code here.
    } 
    /**
     * connect Counter method getCounter().
     */
    public void calculateScore() {
        score.getCounter();
        return score;
    }
    
    /**
     * winnner's condition is open all box and pass the door.
     */
    public void getWin() {
        if (score == 5 && isTouching(door.class)) { //open a box means get a score
          setImage(new GreenfootImage("You are winner",48,Color.WHITE, Color.BLUE));
          setLocation(300,300);
          
        }
    }
}
