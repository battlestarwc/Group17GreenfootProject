import greenfoot.*;

public class Tile extends Actor {
	private GreenfootImage imgWall;
	private GreenfootImage imgNull;

	public Tile() {
		this.imgWall = new GreenfootImage("images/WallTile.png");
		this.imgNull = new GreenfootImage("images/NullTile.png");
		this.setImage(this.imgWall);
	}

	public void setWall(boolean b) {
		if (b) {
			this.setImage(this.imgWall);
		} else {
			this.setImage(this.imgNull);
		}
	}
}
