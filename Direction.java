import greenfoot.*;
import java.util.*;

//I could use a enum, but fuck it, this is just easier to read
public class Direction {

	protected final Integer xOffset;
	protected final Integer yOffset;
	protected final Character dirc;

	public Direction(int dir) {
		
		Random r = new Random();		

		//STATIC LOOKUPS, HARDCODED
		//THIS IS HORRIBLE, PLEASE DONT LOOK AT IT
		
		switch(dir) {
			case 0:
				this.xOffset = 1;
				this.yOffset = 0;
				this.dirc = 'D';
				break;
			case 1:
				this.xOffset = 0;
				this.yOffset = 1;
				this.dirc = 'R';
				break;
			case 2:
				this.xOffset = -1;
				this.yOffset = 0;
				this.dirc = 'U';
				break;
			case 3:
				this.xOffset = 0;
				this.yOffset = -1;
				this.dirc = 'L';
				break;
			default:
				this.xOffset = r.nextInt() % 5;
				this.yOffset = r.nextInt() % 5;
				this.dirc = 'A';
		}
	
	}

	public String getDirection() {
		switch(this.dirc) {
			case 'D':
				return "Down";
			case 'R':
				return "Right";
			case 'U':
				return "Up";
			case 'L':
				return "Left";
			default:
				return "Any";
		}
	}

	public int getX() {
		return this.xOffset;
	}

	public int getY() {
		return this.yOffset;
	}

	public static Direction[] getDirectionSet() {
		Direction[] output = new Direction[4];
		for(int i = 0; i < 4; i++) {
			output[i] = new Direction(i);
		}
		return output;
	}

}
