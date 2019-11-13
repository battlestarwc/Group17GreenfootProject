import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage bullet= new GreenfootImage("Bullet.png");
    private int life = 15; 
    private int damage = 1; 
    
    public Bullet()
    {
        
       
    }
    
    public void act() 
    
    {
       
       move(2);
     
    }    
    /**
     * 
     */
    public void lookForWall()
     {
        if (isTouching(Wall.class))
        {
            getWorld().removeObject(this);
        }
    }
}
