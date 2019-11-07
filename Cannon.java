import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
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
        
        
        
    }

    /**
     * Cannon will shoot rock or bullet to player 
     * 
     */
    public void act() 
    {
         
         
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(),player.getY());
        
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
