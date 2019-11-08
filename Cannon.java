import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
    private Random r;
    private int cannonReloadTime; 
    private int shotsFired; 
    private int  speed;
    
    private GreenfootImage cannon = new GreenfootImage("Cannon.png");
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Cannon ()
    {
        
        r = new Random();
        
    }

    /**
     * Cannon will shoot rock or bullet to player 
     * 
     */
    public void act() 
    {
         
         
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(),player.getY());
	if (r.nextInt() % 60 == 42) {
		this.fire();
	}
        
    }    
    /**
     * Cannon fires
     */
    public void fire ()
    {
        
        Rock rock= new Rock();
        getWorld().addObject(rock,getX(),getY());
    }
}
