import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class keyPic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class keyPic extends Actor
{
    /**
     * Act - do whatever the keyPic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public keyPic() {
       this.setImage("Key.png");
       getImage().scale(20,20);
    }
    public void act() 
    {
        setLocation(442,588);
    }    
}
