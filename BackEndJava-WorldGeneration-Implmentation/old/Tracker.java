import greenfoot.*;
import dijkstra.Graph;
import java.util.Vector;

public class Tracker() extends Runnable {

	private final World world;
	private final Actor from;
	private final Actor to;
	private Vector path;
	private Vector<Point> validPts;

	public void setup(Actor from, Actor to, World world) {
		this.world = world;
		this.from = from;
		this.to = to;

		List<Actor> actors = this.world.getObjects(Actor.class);
		Vector<Point> validPoints = new Vector<>();

		//x += FIXED INTERVAL
		for(int x = -2000; x < 2000; x+= 5) {
			for(int y = -2000; y < 2000; y += 5) {
				double closest = Double.MAX_VALUE;
				for(Actor a : actors) {
					if(dist(a.getX(), a.getY(), x, y) < closest) {
						closest = dist(a.getX(), a.getY(), x, y);
					}
				}
				//FIXED SIZE FOR VALID
				if(closest > 10) {
					validPoints.add(new Point(x,y));
				}
			}
		}
		this.validPts = validPoints;
	}

	private double dist(int x, int y, int xa, int ya) {
		return Math.sqrt( Math.pow((x - xa),2) + Math.pow((y - ya),2) );
	}

}
