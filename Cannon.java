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
    private int reloadDelayCount;
    
    private GreenfootImage cannon = new GreenfootImage("Cannon.png");
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Cannon ()
    {
        cannonReloadTime=1; 
        reloadDelayCount = 5; 
        r = new Random();
        
    }

    /**
     * Cannon will shoot rock or bullet to player 
     * 
     */
    public void act() 
    {
         turnAtEdge();
         
      
		
         
		
	
    }
    /**
     * 
     */
    public void turnAtEdge()
    {
        if (isAtEdge())
        {
            turn(Greenfoot.getRandomNumber(120)-35);
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

