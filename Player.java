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
            Actor test = getOneObjectAtOffset(xDirection(this.getRotation()), yDirection(this.getRotation()), TestObstacle.class);
            if (test == null) {
            
            if (Greenfoot.isKeyDown("Up")) {
            setRotation(270);
            move(10);  
        }
            if (Greenfoot.isKeyDown("Left")) {
            setRotation(180);
            move (10);   
        }
            if (Greenfoot.isKeyDown("Down")) {
            setRotation(90);
            move(10);
        }
            if (Greenfoot.isKeyDown("Right")) {
            setRotation(0);
            move(10);
        }
    }
    }
    }
    
    public int xDirection(int direction) {
        if (direction == 0) {
            return 1;
        }
        if (direction == 180) {
            return -1;
        }
        return 0;
    
    
}

    public int yDirection(int direction) {
        if (direction == 90) {
            return 1;
        }
        if (direction == 270) {
            return -1;
        }
        return 0;
    }
    
}