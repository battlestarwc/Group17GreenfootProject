

import java.util.*;

public class Cell implements Comparable<Cell>  {

    private final int X; //The x cord in the grid
    private final int Y; //The y cord in the grid
    private boolean wall; //True if this is a wall

    public Cell(int xCord, int yCord, boolean w) {
        this.X = xCord;
        this.Y = yCord;
        this.wall = w;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public void changeWall() {
        if (this.wall) {
            this.wall = false;
        } else {
            this.wall = true;
        }
    }

    public boolean isWall() {
        return this.wall;
    }

	private double path(int x, int y) {
		return Math.abs(Math.sqrt(Math.pow(x-127,2) + Math.pow(y-127,2)));
	}

    public int compareTo(Cell c) {
		double thisDist = this.path(this.getX(), this.getY());
		double thatDist = this.path(c.getX(), c.getY());
		if(thisDist <= thatDist) {
			if (thisDist < 100) {
				return 2;
			} else  {
				return -1;
			}
		} else {
			return 1;
		}
	

}
}