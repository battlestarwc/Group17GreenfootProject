import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import java.awt.Color;
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Group 17 Greenfoot project 
 * @version a0e2d7e61ef98ffbd7ffa6ca67183ed4f2814ddc
 * Please keep the git commit version updated to the latest version of master.
 */
public class MyWorld extends World
{

    private Class playerType = Player.class;
    private int screenSizeX = 600;
    private int screenSizeY = 600;
    private int playerTargetX = screenSizeX / 2;
    private int playerTargetY = screenSizeY / 2;
    private int maxCannons = 75;
    private int maxKeys = 100;
    private int maxBombs = 25;
    public static boolean started;

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
            if(a instanceof Shade) {
            continue;
        }
            int newX = a.getX() + deltaX;
            int newY = a.getY() + deltaY;
            a.setLocation(newX, newY);
        }
    }

    public void act() {
        scroll();
        if(started == false) {
        Time.minutes = 2;
        Time.seconds = 30;
        started = true;
    }
//	if(Key.keyNumber % 25 == 0 && Key.keyNumber > 0) {
//		Greenfoot.playSound("win.wav");
//	}
    }

    /*
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1, false);
    try {
        for (Time t : this.getObjects(Time.class)) {
            t.killTimer();
        }
    } catch (Exception ignore) {

    }
    started = false;
        addObject(new Shade(),300,300);
        Maze a = new Maze(256);
        a.run();
        GreenfootImage background = getBackground();
        background.setColor(new Color(80,80,80)); 
        background.fill();
        //Test scrolling
        addObject(new Player(), 0,0);
        //addObject(new Key(), 300, 300);  
        //addObject(new Cannon(),200,500);
        //addObject(new Rock(),200,500);
        addObject(new ScoreBoard(200, 50), 0,0);
        addObject(new Time(), 0,0);
        Key.keyNumber = 0;
        addObject(new HealthBar(), 0, 0);
        addObject(new keyPic(),0,0);
        addObject(new healthpic(),0,0);
        setPaintOrder(healthpic.class,keyPic.class,HealthBar.class,Time.class, ScoreBoard.class,Shade.class,Player.class, Key.class);
        Iterator mazeItr = a.getMaze().iterator();
        MazeGeneratorInterface inf = new MazeGeneratorInterface(this, mazeItr);
        Random r = new Random();
        Iterator cannonItr = a.getMaze().iterator();
        PriorityQueue<Cell> arr = new PriorityQueue<>(); 
        while(cannonItr.hasNext()) {
            Cell c = (Cell) cannonItr.next();
            if(c.isWall() || ((c.getX() < 2 && c.getX() > -2)&&(c.getY() < 2 && c.getY() >-2))){
                continue;
            }
            arr.add(c);
        }
        //Collections.shuffle(arr);
        while(this.maxKeys > 0 && arr.size() > 5) {
            Cell c = arr.poll();
            if(r.nextInt() % 100 > 100 * (arr.size() / Math.pow((this.maxKeys + this.maxCannons), 2))) {
                continue;
            } 
            int x = (50*(c.getX()-127));
            int y = (50*(c.getX()-127));
            addObject(new Key(), x, y);
            this.maxKeys--;
        }
        while(this.maxCannons + this.maxBombs > 0 && arr.size() > 5) {
            Cell c = arr.poll();
            if(r.nextInt() % 100 > 100 * (arr.size() / Math.pow((this.maxKeys + this.maxCannons), 2))) {
                continue;
            }
            int x = (50*(c.getX()-127));
            int y = (50*(c.getX()-127));
            if(Math.abs(r.nextInt()) % 2 == 0) {
                addObject(new Cannon(), x, y);
                this.maxCannons--;
            } else {
                addObject(new Bomb(), x, y);
                this.maxBombs--;
            }
        }
        prepare();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    //public void addObject(Actor actor)
    //{
    //    
    //}
        

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        /*
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
         */
        Vector<Integer> xes = new Vector<>();
        Vector<Integer> yes = new Vector<>();
        xes.add(200);
        yes.add(500);
        xes.add(-100);
        yes.add(500);
        xes.add(-400);
        yes.add(500);
        xes.add(-700);
        yes.add(500);
        xes.add(-700);
        yes.add(300);
        xes.add(-700);
        yes.add(100);
        xes.add(-700);
        yes.add(200);
        xes.add(-700);
        yes.add(0);
        xes.add(-700);
        yes.add(-200);
        xes.add(-400);
        yes.add(-200);
        xes.add(-100);
        yes.add(-200);
        xes.add(200);
        yes.add(-200);
        xes.add(500);
        yes.add(-200);
        xes.add(800);
        yes.add(-200);
        xes.add(800);
        yes.add(0);
        xes.add(800);
        yes.add(200);
        xes.add(800);
        yes.add(400);
        Iterator<Integer> x = xes.iterator();
        Iterator<Integer> y = yes.iterator();
        while(x.hasNext() && y.hasNext()) {
            addObject(new Wall(), x.next(), y.next());
        }
        addObject(new Cannon(), 300, 300);
    }
}
