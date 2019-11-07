import greenfoot.*;
import dijkstra.Graph;
import java.util.Vector;

public class Tracker() extends Runnable {

	private final World world;
	private final Actor from;
	private final Actor to;
	private Vector path;

	public void setup(Actor from, Actor to, World world) {
		this.world = world;
		this.from = from;
		this.to = to;
	}

}
