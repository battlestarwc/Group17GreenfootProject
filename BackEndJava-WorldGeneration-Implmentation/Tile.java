import greenfoot.*;

public class Tile extends Actor {
	private GreenfootImage imgWall;
	private GreenfootImage imgNull;
	private boolean wall;

	public Tile() {
		this.imgWall = new GreenfootImage("images/WallTile.png");
		this.imgNull = new GreenfootImage("images/NullTile.png");
		this.setImage(this.imgWall);
		this.wall = True;
	}

	public void setWall(boolean b) {
		if (b) {
			this.setImage(this.imgWall);
			this.wall = True;
		} else {
			this.setImage(this.imgNull);
			this.wall = False;
		}
	}

	public boolean isWall() {
		return this.wall;
	}
}
