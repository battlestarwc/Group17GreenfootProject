import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int tempHealth = 30;
        private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);
private int index = 140;
    public HealthBar() {
        this.setImage(new GreenfootImage("images/healthbargreen.png"));
        getImage().scale(150,90);      
               }
    public void act() 
    {
        setLocation(510,545);
        updateBar();
    }    
    
    public void updateBar() {
        List<Player> test = getWorld().getObjects(Player.class);
                getImage().setColor(BACKGROUND_COLOR);

        
        if (test.get(0).getHealth() != tempHealth) {
            getImage().fillRect(index, 22, 50, 30); 
            index -= 11;
            tempHealth = test.get(0).getHealth();
        }
    }
}
