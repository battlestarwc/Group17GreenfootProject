import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int coins; 
    
    
    public Player() {
        coins = 0;
    }
    public void act() 
    {
        wallCollision();
        keysPressed();
        
    }    
    
    //can change to whatever the goal is
    public int getCoins() {
        return coins;
    }
    
    
    
    //returns 1 if there is no wall in front, -1 if there is 
    public int wallCollision() {
        // uses offset function,but there is no wall class yet
        return 1;
    }
    
    //works only if the player is viewed eagle eyed, like the mockup, will change if we dont use that
    //Currently, if the player hits an object of TestObstacle, like a hole, then it will stop.
    public void keysPressed() {
        if (wallCollision() == 1) {
            Actor test = 
            getOneObjectAtOffset(changeX(this.getRotation()),changeY(this.getRotation()),TestObstacle.class);
            if (test == null) {
            if (Greenfoot.isKeyDown("Up")) {
                this.setRotation(270);
                move(5);
            }
            if (Greenfoot.isKeyDown("Down")) {
                this.setRotation(90);
                move(5);
            }
            if (Greenfoot.isKeyDown("Left")) {
                this.setRotation(180);
                move(5);
            }
            if (Greenfoot.isKeyDown("RIght")) {
                this.setRotation(0);
                move(5);
            }
        }
    }
        
        
        
        
        
    }
    
    
    
    public int changeX(int direction) {
        if (direction == 0) {
            return -5;
        }
        if (direction == 180) {
            return 5;
        }
        return 0;
        
    }
    
    public int changeY(int direction) {
        if (direction == 90) {
            return 11;
        }
        if (direction == 270) {
            return 5;
        }
        return 0;
    }
}
