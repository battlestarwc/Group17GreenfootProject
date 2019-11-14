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
    private static final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40);
    private int speed;
    private int health;
    private int damage; 
    
    public Player() {

        speed = 5;
        this.health = 30;
    }
    
    public void act() 
    {
        wallCollision();
        if(this.health <= 0) {
	    endScreen();
		Greenfoot.stop();
		
	}
        if(Greenfoot.isKeyDown("Up") && this.getY() > -1500 && this.getY() < 1500) {
                setRotation(270);
                keysPressed();
            }
             else if(Greenfoot.isKeyDown("Right") && this.getX() > -1500 && this.getX() < 1500) {
                    setRotation(0);
                    keysPressed();
            }
             else if(Greenfoot.isKeyDown("Down") && this.getY() > -1500 && this.getY() < 1500) {
                    setRotation(90);
                    keysPressed();
            }
             else if(Greenfoot.isKeyDown("Left") && this.getX() > -1500 && this.getX() < 1500) {
                    setRotation(180);
                    keysPressed();
            }
        
        
    if(isTouching(Rock.class)) {
        this.health -= Rock.damage;
        Actor rock = getOneIntersectingObject(Rock.class);
        getWorld().removeObject(rock);
    }       

	
        
     
    } 
    
   public void endScreen() {
        List<ScoreBoard> test = getWorld().getObjects(ScoreBoard.class);
        getWorld().removeObject(test.get(0));
        ScoreBoard screen = new ScoreBoard(400, 400);
        Color BACKGROUND_COLOR = new Color(0xB0, 0x40, 0x40);
        Color MAIN_COLOR = new Color(0x60, 0x60, 0x60);
        screen.getImage().setColor(BACKGROUND_COLOR);
        screen.getImage().fillRect(0,0,400,400);
        screen.drawString("YOU", screen.getImage().getWidth()/2 - 70, 100, MAIN_COLOR, 80);
        screen.drawString("DIED", screen.getImage().getWidth()/2 - 75, 175, MAIN_COLOR,80);
        getWorld().addObject(screen, this.getX(),this.getY());
        
        screen.drawString("Health: 0", screen.getImage().getWidth() /4 , 275, MAIN_COLOR, 50);
        screen.drawString("Keys: ", screen.getImage().getWidth() / 4, 325, MAIN_COLOR, 50);
        screen.drawString(Integer.toString(getKeys()), screen.getImage().getWidth() / 2 + 20, 325, MAIN_COLOR,50);
        
        
    }
    public int wallCollision() {
        //returns 1 if no wall is in front of the player, -1 if there is
         if (this.isTouching(Wall.class)) {
              return -1;
            
           }
        //will use offset instead of isTouching
    
        
        return 1;
        
        
    }
    
    public int getKeys() //can change to whatever the objective is
    {
        return Key.keyNumber;
        
    }
    
    public int getHealth() {
        return health;
    }
    public void keysPressed() {
        
        if (wallCollision() == 1) {
         Actor test = getOneObjectAtOffset(offsetX(this.getRotation()), offsetY(this.getRotation()), TestObstacle.class);
            if (test == null) {
            move(speed);
           
    }
    }
    if(wallCollision() != 1) {
        move(-speed);
    } 
    }
    
    
    
    public int offsetX(int direction) {
        if (getRotation() == 0) {
            return speed + getImage().getWidth()/2;
        }
        if (getRotation() == 180) {
            return -speed - getImage().getWidth()/2;
        }
        return 0;
    }
    
    public int offsetY(int direction) {
        if (getRotation() == 90) {
            return speed + getImage().getHeight()/2;
        }
        if (getRotation() == 270) {
            return -speed - getImage().getHeight()/2;
        }
        return 0;
    }
    
    

}
