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
         
         
        TestPlayer testplayer = (TestPlayer)getWorld().getObjects(TestPlayer.class).get(0);
        turnTowards(testplayer.getX(),testplayer.getY());
        
    }    
    /**
     * Cannon fires
     */
    public void fire ()
    {
        
        
        
    }
}
