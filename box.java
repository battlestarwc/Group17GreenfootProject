import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class box extends Counter
{   
    int score = 0;
    int keyNumber = 0;
    
    /**
     * Act - do whatever the box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(100,100);
        GreenfootImage key = new GreenfootImage("box.png");
        open();
        // Add your action code here.
    } 
    public void keyNumber() {
        return keyNumber;
    }
    /**
     *use a key to open a box.
     *if you already opened a box, you will lost a key.
     */
    public void open() {
        if (keyNumber >= 1) {
            Actor actor = getOneIntersectingObject(box.class);
            getWorld().removeObject(actor);
            score++;
        }
        
    }
}
