import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{


	private Class playerType = TestPlayer.class;
	private int screenSizeX = 600;
	private int screenSizeY = 600;
	private int playerTargetX = screenSizeX / 2;
	private int playerTargetY = screenSizeY / 2;
    
	private void scroll() {
		Actor player = null;
		for (Actor a : super.getObjects(Actor.class)) {
			
			if (a.getClass() == this.playerType) {
				player = a;
				break;
			}

		}
		if (player == null) {
		    throw new RuntimeException("Code has reached an unreachable state, please go to counciling");
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
		for (Actor a : super.getObjects(Actor.class)) {
			int newX = a.getX() + deltaX;
			int newY = a.getY() + deltaY;
			a.setLocation(newX, newY);
		}
	}

	public void act() {
		scroll();
	}


	/*
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1, false);
	//Test scrolling
	addObject(new TestPlayer(), 300,300); 
	
	addObject(new Player(), 300,300);
	addObject(new TestObstacle(), 100, 100);
    }
}
