import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{

    private Random r = new Random();
    private ArrayList<GreenfootImage> images  = new ArrayList<>();

	public Wall() {
	    this.setImage(new GreenfootImage("images/brick.jpg"));
		//this.r  = new Random();
		//this.setImage(this.images.get(this.r.nextInt() % this.images.size()));
	}    

/**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    private void loadImages() {
	images.add(new GreenfootImage("images/wall1.png"));
	images.add(new GreenfootImage("images/wall2.png"));
    }

    public void setImage() {
	int index = this.r.nextInt() % this.images.size();
        setImage(images.get(index));
    }

}
