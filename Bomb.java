import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    /**
     * 
     * 
     */
    public void act() 
    {
        setLocation(getX(), getY());
        List <Player> players=getObjectsInRange(100,player.class); 
            for (Player b : player){
                getWorld().removeObject(b); 
        
            }
        getWorld.removeObject(this);
        
}
}