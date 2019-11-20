import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Counter
{   
    public static int keyNumber = 0;
    /**
     * Act - do whatever the key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Key() {
		GreenfootImage k = new GreenfootImage("Key.png");
		this.setImage(k);
	}

    public void act() 
    {
        getKey();// A// Add your action code here.
    }    
    /**
     * get a key means you can open a box.
     * if you already opened a box , you will use off a key.
     */
    public void getKey() {
        if(isTouching(Player.class)) {
            getWorld().removeObject(this);
            keyNumber++;
	    Time.addTime();
        }


    }
}
