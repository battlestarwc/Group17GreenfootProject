import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class key extends Counter
{   
    private int keyNumber = 0;
    /**
     * Act - do whatever the key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(300,100);
        GreenfootImage key = new GreenfootImage("key.png");
        getKey();// A// Add your action code here.
    }    
    /**
     * get a key means you can open a box.
     * if you already opened a box , you will use off a key.
     */
    public void getKey() {
        if(isTouching(key.class)) {
            Actor actor = getOneIntersectingObject(key.class);
            getWorld().removeObject(actor);
            keyNumber++;
        }
    
        
    }
}
