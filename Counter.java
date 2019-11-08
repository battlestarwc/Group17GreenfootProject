import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{   
    private static int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //setImage(new GreenfootImage("score :" + score,100, Color.GREEN,new Color(0,0,0)));
        getCounter();// Add your action code here.
    }  
    /**
     * addScore if ball get fire, score will increase.
     */
    public void getCounter()
    {
        score = key.keyNumber;
    }

	public static int getScore() {
		return score;
	}
    
}
