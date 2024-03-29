import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.TimerTask;
import java.util.Timer;
import java.util.List;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time extends Actor
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color MAIN_COLOR = new Color(255,0,0);
    private static final Color BACKGROUND_COLOR = new Color(0, 0, 0);
    public static int minutes;
    public static int seconds;
    private Timer timer;
    public Time() {
        Time.minutes = 2;
        Time.seconds = 30;
        setImage(new GreenfootImage(200, 75)); 
        getImage().setColor(BACKGROUND_COLOR);
        getImage().fill();
        setLocation(550,550);
        drawString(":",getImage().getWidth()/3 + 7, 4, MAIN_COLOR, 50);
        TimerTask tasknew = new testTask();
        this.timer = new Timer();
        timer.scheduleAtFixedRate(tasknew, 1000, 1000);
    }
    
    public static void addTime() {
        seconds += 10;
        if(seconds >= 60) {
            seconds -= 60;
            minutes += 1;
        }
    }
    
    public void act() 
    {   
        setLocation(300, 50);
        if (minutes == 0 && seconds <=0) {
            getImage().clear();
            endTime();
        MyWorld.started = false;
            Greenfoot.stop();
        }
        
       
    }    
    
    public void endTime() {
        this.killTimer();
        //this.timer.cancel();
        //this.timer.purge();
	Lose.GameOver();    
        List<ScoreBoard> scoreboard = getWorld().getObjects(ScoreBoard.class);
        getWorld().removeObject(scoreboard.get(0));
        //List<Time> timeboard = getWorld().getObjects(Time.class);
        //getWorld().removeObject(timeboard.get(0));
        ScoreBoard screen = new ScoreBoard(400, 400);
        List<Player> getPlayerPosition = getWorld().getObjects(Player.class);
        
        setLocation(getPlayerPosition.get(0).getX(),getPlayerPosition.get(0).getY());
        Color BACKGROUND_COLOR = new Color(255, 0, 0);
        Color MAIN_COLOR = new Color(0, 0, 0);
        screen.getImage().setColor(BACKGROUND_COLOR);
        screen.getImage().fillRect(0,0,400,400);
        screen.drawString("OUT OF", screen.getImage().getWidth()/2 - 85, 100, MAIN_COLOR, 60);
        screen.drawString("TIME!", screen.getImage().getWidth()/2 - 69, 175, MAIN_COLOR,60);
        getWorld().addObject(screen, this.getX(),this.getY());
        
        screen.drawString("Health: ", screen.getImage().getWidth() /4 +15, 275, MAIN_COLOR, 50);
        screen.drawString(Integer.toString(getPlayerPosition.get(0).getHealth()),screen.getImage().getWidth() /2 +55, 275, MAIN_COLOR, 50);
        screen.drawString("Keys: ", screen.getImage().getWidth() / 4 +15, 325, MAIN_COLOR, 50);
                screen.drawString(Integer.toString(getPlayerPosition.get(0).getKeys()), screen.getImage().getWidth() / 2 + 35, 325, MAIN_COLOR, 50);
List<HealthBar> hb = getWorld().getObjects(HealthBar.class);
        getWorld().removeObject(hb.get(0));
        List<healthpic> hp = getWorld().getObjects(healthpic.class);
                getWorld().removeObject(hp.get(0));

        List<keyPic> kp = getWorld().getObjects(keyPic.class);
                getWorld().removeObject(kp.get(0));
        Time.minutes = 0;
    Time.seconds = 0;
    }
    
    public void killTimer() {
        this.timer.purge();
        this.timer.cancel();
    }

     public void drawString(String text, int x, int y, Color color, int height)
    {
        getImage().drawImage(new GreenfootImage(text, height, color, new Color (0,0,0,0)), x, y);
        
        
        
        
    }
 
        class testTask extends TimerTask {
            
            public void run() {
                   getImage().fillRect(0,0,199, 74);
                   drawString(":",getImage().getWidth()/3 + 7, 4, MAIN_COLOR, 50);
                   if ( seconds <= 0) {
                       seconds = 59;
                       minutes --;
                       
                    } else {
                seconds--;
            }
                    drawString(Integer.toString(minutes),getImage().getWidth()/5, 5, MAIN_COLOR, 50);
                    if (seconds < 10) {
                        drawString("0" + Integer.toString(seconds), getImage().getWidth()/2, 5, MAIN_COLOR, 50);
                    } else if (seconds < 0) {
                        drawString("00", getImage().getWidth()/2, 5, MAIN_COLOR, 50);
                    }
                    else {
                        drawString(Integer.toString(seconds), getImage().getWidth()/2, 5, MAIN_COLOR, 50);
                    }
                        //seconds--;
            drawString("Find Keys and avoid death!", getImage().getWidth()/6 -8, 50, MAIN_COLOR, 15);
                }
            }
        }
