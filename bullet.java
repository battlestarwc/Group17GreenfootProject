import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int life = 15; 
    private int damage=3; 
    
    public Bullet()
    {
        
         
        
    }
    /**
     * The bullet will hurt the palyer if the play get hit 
     * 
     */
    public void act() 
    {
        
        
        move(-5);
       
    }    
    
    

    

    
        

}
