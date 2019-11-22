import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private GreenfootImage bomb;
    public static final int damage = 3; 
    public Bomb()
    {
        bomb = new GreenfootImage("images/Bomb.png");
        setImage(bomb);
        
    }
    /**
     * 
     * 
     */
    public void act() 
    {

                
    
 if (getOneIntersectingObject(Player.class)!=null)
         {
            Greenfoot.playSound("Explosion.wav");
             getWorld().removeObject(this);   
             
         }
       
        

}
}