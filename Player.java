import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    //private int visionRange;
    public Player() {
            coins = 0;
            //visionRange = 100;
    }
    
    public void act() 
    {
        wallCollision();
        keysPressed();
        
     
    } 
    
    
    public int wallCollision() {
        //returns 1 if no wall is in front of the player, -1 if there is
        // if (this.isTouching(class wall)) {
        //      return -1;
            
        //   }
        //will use offset instead of isTouching
    
        
        return 1;
        
        
    }
    
    public int getCoins() //can change to whatever the objective is
    {
        return coins;
        
    }
    
    public void keysPressed() {
        int currentX = getX();
        int currentY = getY();
        if (wallCollision() == 1) {
            Actor test = getOneObjectAtOffset(1, 1, TestObstacle.class);
            if (test == null) {
                    
            if (Greenfoot.isKeyDown("w")) {
            setRotation(270);
            move(10);  
        }
            if (Greenfoot.isKeyDown("a")) {
            setRotation(180);
            move (10);   
        }
            if (Greenfoot.isKeyDown("s")) {
            setRotation(90);
            move(10);
        }
            if (Greenfoot.isKeyDown("d")) {
            setRotation(0);
            move(10);
        }
    }
    }
    }
    
    
    
}
