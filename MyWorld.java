import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{


	private Class<T> playerType = Cannon.class;
	private int screenSizeX = 600;
	private int screenSizeY = 600;
	private int playerTargetX = screenSizeX / 2;
	private int playerTargetY = screenSizeY / 2;
    
	private void scroll() {
		Actor player;
		for (Actor a : getWorld().getObjects(Actor)) {
			if (a.class == this.playerType) {
				player = a;
				break;
			}
		}
		int x = player.getX();
		int y = player.getY();

		int deltaX = x - this.playerTargetX;
		int deltaY = y - this.playerTargetY;

		//TODO: ADD BOUNDS CHECKING

		//invert direction
		deltaX *= -1;
		deltaY *= -1;

		//move
		for (Actor a : getWorld().getObjects(Actor)) {
			int newX = a.getX() + deltaX;
			int newY = a.getY() + deltaY;
			a.setLocation(newX, newY);
		}
	}


	/*
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(screenSizeX, screenSizeY, 1, false);
	//Test scrolling
	addObject(new Cannon, 300,300); 
    }
}
