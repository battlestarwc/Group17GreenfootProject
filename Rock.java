import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private int life=15; 
    private int damage=3;
    private GreenfootImage rock = new GreenfootImage("Rock.png");
    /**
     * The rock will hurt the player if the player gets hit 
     * 
     */
    public void act() 
    {
        move(-5);
        
        
    }    
    /**
     * 
     */
    public void checkBoundaries()
    {
        
        
    }
}
