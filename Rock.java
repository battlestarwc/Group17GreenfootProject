import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private int life=15; 
    public static final int damage=3;
    private boolean targetSet = false;
    private GreenfootImage rock;
    private int speed=5; 
    /**
     * The rock will hurt the player if the player gets hit 
     * 
     */
	
	public Rock() {
	//Actor target = (Actor) (getWorld().getObjects(Player.class).get(0));
        //turnTowards(target.getX(), target.getY());	
        rock =  new GreenfootImage("images/Rock.png");
        setImage( rock);
	}
    public void act() 
    {
       //Actor target = (Actor) (getWorld().getObjects(Player.class).get(0)); 
        //turnTowards(target.getX(), target.getY());
	if(targetSet == false) {
		try {
			Actor target = (Actor) (getWorld().getObjects(Player.class).get(0));
        		turnTowards(target.getX(), target.getY());
			targetSet = true;
		} catch (Exception e) {
			targetSet = false;
		}
	}
	if(targetSet == true) {
		move(5);
	}
         Player player = (Player) getOneIntersectingObject(Player.class);
     if(player != null){
         
         //this is causing greenfoot to stop whenever the rock hits the player when 
         //player is standing still or moving up and down, dont know how to fix
       //  Greenfoot.stop();
         lookForWall();
    } 
    }
    /**
     * 
     */
      public void lookForWall()
      {
	if (isTouching(Wall.class))
        {
            this.getWorld().removeObject(this);
        }
        

    }
    public void remove() {
        getWorld().removeObject(this);
    }

}
