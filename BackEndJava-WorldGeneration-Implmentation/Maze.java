import greenfoot.*;
import java.util.*;

public class Maze implments Runnable {

	private final World world;
	private final int xSize;
	private final int ySize;
	private final Random r;

	public Maze(World w, int x, int y) {
		this.world = w;
		this.xSize = x;
		this.ySize = y;
		this.r = new Random();
	}

	private void setup() {
		//30 is arbitrary tile size
		for(int x = -this.xSize; x <= this.xSize; x += 30) {
			for(int y = -this.ySize; y <= this.ySize; y += 30) {
				//This is the arbitrary player start box
				//3 tiles by 3 tiles at center, adjust as needed
				if(x > 0 - (30 * 3) && x x < 0 + (30 * 3) {
					continue;
				}
				this.world.addObject(new Tile(), x, y);
			}
		}
	}

	//recurse
	//check for 1 (10%) 2 (70%) or 3 (20%) null neighbors
	//if not the right number of neighbors, create new nulls
	//NEVER touch the lastTile
	private void algo(Actor lastTile, Actor targetTile) {
		//get neigbors
		List<Actor> neighbors = targetTile.getNeighbors(30, false, Tile.class);
		if(neighbors.isEmpty()) {
			return;
		}
		//select how many neighbors to have
		int howMany = r.nextInt() % 10;
		switch(howMany) {
			case 0:
				howMany = 1;
				break;
			//Hacky way of waterfalling switches
			case 1:
			case 2:
			case 3:
				howMany = 3;
				break;
			default:
				howMany = 2;
		}
		

		//TODO: Edit neighbors

		//return case
		if(howMany > 1) {
			for(Actor a : neighbors) {
				if (a != lastTile) {
					this.algo(targetTile, a);
				}
			}
		}
		
	}


}
