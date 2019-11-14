import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class key extends Counter
{   
    public static int keyNumber = 0;
    /**
     * Act - do whatever the key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public key() {
		GreenfootImage k = new GreenfootImage("Key.png");
		this.setImage(k);
	}

    public void act() 
    {
<<<<<<< HEAD
        setLocation(300,100);
        GreenfootImage key = new GreenfootImage("Key.png");
        getKey();// A// Add your action code here.
=======
	//no, this cant be here
        //setLocation(300,100);
	//this should be in constructor 
        //GreenfootImage key = new GreenfootImage("Key.png");
        getKey();// Why is this here and why is it done like this, but it works so I guess its ok
>>>>>>> master
    }    
    /**
     * get a key means you can open a box.
     * if you already opened a box , you will use off a key.
     */
    public void getKey() {
        if(isTouching(Player.class)) {
            Actor actor = getOneIntersectingObject(Player.class);
            getWorld().removeObject(this);
            keyNumber++;
        }
    
        
    }
}
