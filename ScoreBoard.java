import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * An actor class that can display a scoreboard, using Greenfoot's
 * UserInfo class.  
 * 
 * You typically use this by including some code into the world for when your game ends:
 * 
 * <pre>
 *   addObject(new ScoreBoard(800, 600), getWidth() / 2, getHeight() / 2); 
 * </pre>
 * 
 * Where 800 by 600 should be replaced by the desired size of the score board. 
 * 
 * @author Neil Brown 
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    // The vertical gap between user images in the scoreboard:
    private static final int GAP = 10;
    // The height of the "All Players"/"Near Me" text at the top:
    private static final int HEADER_TEXT_HEIGHT = 25;
    // The main text color:
    private static final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); // dark grey
    // The score color:
    private static final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40); // orange-y
    // The background colors:
    private static final Color BACKGROUND_COLOR = new Color(0xFF, 0xFF, 0xFF, 0xB0);
    private static final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(180, 230, 255, 0xB0);
    private int tempHealth = 30;
    private int tempKeys = 0;
    /**
     * Constructor for objects of class ScoreBoard.
     * <p>
     * You can specify the width and height that the score board should be, but
     * a minimum width of 600 will be enforced.
     */
    public ScoreBoard(int width, int height)
    {    
        setImage(new GreenfootImage(width, height)); 
        getImage().setColor(BACKGROUND_COLOR);
        getImage().fill();
        getImage().fillRect(72,3,25, 23);
        getImage().fillRect(72,28,25, 23);
        drawString("Health: ", 5,5 , MAIN_COLOR, HEADER_TEXT_HEIGHT);
        drawString("30", 75, 5, MAIN_COLOR,HEADER_TEXT_HEIGHT);
        drawString("Keys: ", 5,25, MAIN_COLOR, HEADER_TEXT_HEIGHT);
                drawString("0", 75, 25, MAIN_COLOR,HEADER_TEXT_HEIGHT);


    }
    
    
    
    public void drawString(String text, int x, int y, Color color, int height)
    {
        getImage().drawImage(new GreenfootImage(text, height, color, new Color (0,0,0,0)), x, y);
        
        
        
        
    }
    
    
    public void act() {
        this.setLocation(550,570);
        List<Player> test = getWorld().getObjects(Player.class);
        getImage().setColor(BACKGROUND_COLOR);
        if (test.get(0).getHealth() != tempHealth || test.get(0).getKeys()!= tempKeys) {
            
            getImage().fillRect(72,3,25, 23);
            drawString(Integer.toString(test.get(0).getHealth()), 75, 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);
            getImage().fillRect(72,28,25, 23);
            drawString(Integer.toString(test.get(0).getKeys()), 75, 25, MAIN_COLOR,HEADER_TEXT_HEIGHT);
            
        }
       
        
    }
   
}
