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
    private int damage = 3; 
    
    public void act()
    
    
    {
        
        
        
        move(-5);
    }    
}
