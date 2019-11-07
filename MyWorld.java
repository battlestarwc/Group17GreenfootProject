import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private Class playerType = Player.class;
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
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK); 
        background.fill();
        //Test scrolling
        addObject(new Player(), 300,300); 
        addObject(new Cannon(),200,500);
        addObject(new Rock(),200,500);
        //prepare();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addObject(Actor actor)
    {
        
    }
        

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
	int x;
	int y;
	x = -500;
	y = -500;
	while(y < 501) {
		addObject(new Wall(), x, y);
		y++;
	}
	while(x < 501) {
		addObject(new Wall(), x, y);
		x++;
	}
	while(y > -501) {
		addObject(new Wall(), x, y);
		y--;
	}
	while(x > -501) {
		addObject(new Wall(), x, y);
		x--;
	}
	
    }
}
