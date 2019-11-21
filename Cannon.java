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
    
    private GreenfootImage cannon;
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
        cannon = new GreenfootImage("images/Cannon.png");
        setImage(cannon);
    }

    /**
     * Cannon will shoot rock or bullet to player 
     * 
     */
    public void act() 
    {
         turnAtEdge();
         	
     try { 
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(),player.getY());
	if ( Math.sqrt( Math.pow(this.getX() - player.getX(), 2) + Math.pow(this.getY() - player.getY(), 2) ) < 500) { 
		turnTowards(player.getX(),player.getY());
		if (r.nextInt() % 35 == 12) {
			this.fire();
		}
		} } catch	 (Exception e) {
			System.out.println(e);
		}    
		
	
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
                Greenfoot.playSound("Damage.wav");

        Rock rock= new Rock();
        getWorld().addObject(rock,getX(),getY());
        rock.setRotation(getRotation());
        }
    }

