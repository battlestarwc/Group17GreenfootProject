import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage bullet= new GreenfootImage("Bullet.png");
    private int life = 15; 
    private int damage = 1; 
    
    public void act()
    
    
    {
        
        
        lookForWall();
        move(-5);
    }    
    public void lookForWall()
    {
        if (isTouching(Wall.class))
        {
            removeTouching(Wall.class);
        }
        
    }
   
}