import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends Cannon
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        touch();// Add your action code here.
    } 
    //
    public void touch() {
        Actor monster = getOneIntersectingObject(monster.class);
        if(monstor != null)
        {
           getWorld().removeObject(monster);
           Counter counter = new Counter();
           counter.getCounter();
           
           
        }
    }
}
