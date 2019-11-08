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
    public static final damage=3;
    private GreenfootImage rock = new GreenfootImage("Rock.png");
    /**
     * The rock will hurt the player if the player gets hit 
     * 
     */

	public Rock() {
	Actor target = (Actor) (getWorld().getObjects(Player.class).get(0));
        turnTowards(target.getX(), target.getY());	
	}
    public void act() 
    {
       //Actor target = (Actor) (getWorld().getObjects(Player.class).get(0)); 
        //turnTowards(target.getX(), target.getY());
	move(5);
        checkBoundaries();
    }    
    /**
     * 
     */
    public void checkBoundaries()
    {
	//HARD CODED BOUNDRIES FOR BETA ONLY
        if (Math.abs(this.getX()) > 2000 || Math.abs(this.getY()) > 2000) {
		this.getWorld().removeObject(this);
	}
        
    }
}
