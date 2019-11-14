import greenfoot.*;
import java.util.*;

public class Tile extends Actor {
	private GreenfootImage imgWall;
	private GreenfootImage imgNull;
	private boolean wall;

	public Tile() {
		this.imgWall = new GreenfootImage("images/WallTile.png");
		this.imgNull = new GreenfootImage("images/FreeTile.png");
		this.setImage(this.imgWall);
		this.wall = true;
	}

	public void setWall(boolean b) {
		if (b) {
			this.setImage(this.imgWall);
			this.wall = true;
		} else {
			this.setImage(this.imgNull);
			this.wall = false;
		}
	}

	public boolean isWall() {
		return this.wall;
	}
	
	public List<Tile> nei() {
	    return this.getNeighbours(30, false, Tile.class);
	}
}
