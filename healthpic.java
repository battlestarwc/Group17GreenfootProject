import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthpic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthpic extends Actor
{
    /**
     * Act - do whatever the healthpic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public healthpic() {
       this.setImage("healthpic1.png");
       getImage().scale(150,90);
    }
    public void act() 
    {
        setLocation(487,570);
    }    
}
