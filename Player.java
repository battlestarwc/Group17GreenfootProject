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

        speed = 10;
        this.health = 30;
        GreenfootImage playerBeautifulFace = new GreenfootImage("images/playerPic1.png");
        playerBeautifulFace.scale(40,50); //squash
        this.setImage(playerBeautifulFace);
    }
    
    public void act() 
    {
        wallCollision();
        if(this.health <= 0) {
        endScreen();
        Greenfoot.stop();
        
    }
        if(Greenfoot.isKeyDown("Up") ) {
                setRotation(270);
                keysPressed();
            }
             else if(Greenfoot.isKeyDown("Right") ) {
                    setRotation(0);
                    keysPressed();
            }
             else if(Greenfoot.isKeyDown("Down") ) {
                    setRotation(90);
                    keysPressed();
            }
             else if(Greenfoot.isKeyDown("Left")) {
                    setRotation(180);
                    keysPressed();
            }
        
        
    if(isTouching(Rock.class)) {
        this.health -= Rock.damage;
       Actor rock = getOneIntersectingObject(Rock.class);
        getWorld().removeObject(rock);
    }       

    if(isTouching(Bomb.class))
    {
        this.health -= Bomb.damage;
        Actor bomb = getOneIntersectingObject(Bomb.class); 
        getWorld().removeObject(bomb);
	Greenfoot.playSound("Explosion.wav");
    }
        
     
    } 
    
   public void endScreen() {
	try {
		this.getWorld().getObjects(Time.class).get(0).killTimer();
	}	
	catch (Exception e) {
		System.out.println(e);
	}	
        List<ScoreBoard> test = getWorld().getObjects(ScoreBoard.class);
        getWorld().removeObject(test.get(0));
        ScoreBoard screen = new ScoreBoard(400, 400);
        Color BACKGROUND_COLOR = new Color(255, 0, 0);
        Color MAIN_COLOR = new Color(0, 0, 0);
        screen.getImage().setColor(BACKGROUND_COLOR);
        screen.getImage().fillRect(0,0,400,400);
        screen.drawString("YOU", screen.getImage().getWidth()/2 - 70, 100, MAIN_COLOR, 80);
        screen.drawString("DIED", screen.getImage().getWidth()/2 - 75, 175, MAIN_COLOR,80);
        getWorld().addObject(screen, this.getX(),this.getY());
        
        screen.drawString("Health: 0", screen.getImage().getWidth() /4 , 275, MAIN_COLOR, 50);
        screen.drawString("Keys: ", screen.getImage().getWidth() / 4, 325, MAIN_COLOR, 50);
        screen.drawString(Integer.toString(getKeys()), screen.getImage().getWidth() / 2 + 20, 325, MAIN_COLOR,50);
        List<HealthBar> hb = getWorld().getObjects(HealthBar.class);
        getWorld().removeObject(hb.get(0));
        List<healthpic> hp = getWorld().getObjects(healthpic.class);
                getWorld().removeObject(hp.get(0));

        List<keyPic> kp = getWorld().getObjects(keyPic.class);
                getWorld().removeObject(kp.get(0));



             
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
        int targetX, targetY;
        targetX = this.getX();
        targetY = this.getY();
        switch(this.getRotation()) {
            //Right, + delta X
            case 0:
                targetX += this.speed;
                break;
            //Down, + delta Y
            case 90:
                targetY += this.speed;
                break;
            //Left, - delta x
            case 180:
                targetX -= this.speed;
                break;
            //Up, - delta y
            default:
                targetX -= this.speed;
        }
        if(this.getWorld().getObjectsAt(targetX,targetY,Wall.class).size() <= 0) {
            this.move(speed);
        }
    }
    
    
    
    
    

}
