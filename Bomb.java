import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    
    private int damage = 3; 
    /**
     * 
     * 
     */
    public void act() 
    {
         if (getOneIntersectingObject(Player.class)!=null)
         {
             getWorld().removeObject(this);       
         }
         
        
        
}
}