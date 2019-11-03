import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestPlayer extends Actor
{
    /**
     * Act - do whatever the TestPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("w")) {
            move(10);
        }
        if(Greenfoot.isKeyDown("W")) {
            move(10);
        }
        if(Greenfoot.isKeyDown("s")) {
            move(-10);
        }
        if(Greenfoot.isKeyDown("S")) {
            move(-10);
        }
        //move(10);
    }    
}
