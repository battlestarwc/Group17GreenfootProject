import greenfoot.*;
import java.util.*;

public class Maze implements Runnable {


	protected final int maxX;
	protected final int maxY;
	protected final boolean[][] maze;
	private final World world;

	public Maze(int x, int y, World w) {
		this.maxX = x;
		this.maxY = y;
		this.maze = new boolean[this.maxX * 2][this.maxY * 2];
		this.world = w;
	}

	private void generateMaze() {
		//Draw the external edges
		for(int x = 0; x < this.maxX * 2; x++) {
			this.maze[x][0] = true;
			this.maze[x][(this.maxY * 2) -1] = true;
		}
		for(int y = 0; y < this.maxY * 2; y++) {
			this.maze[0][y] = true;
			this.maze[(this.maxX * 2) -1][y] = true;
		}
		
		//generate the maze
		//start at graph 0
		int x = this.maxX;
		int y = this.maxY;

		//randomly order the directions to go in
		Direction[] directions = Direction.getDirectionSet();
		Collections.shuffle(Arrays.asList(directions));

		//for every direction
		for (Direction dir : directions) {
			int nextX = x + dir.getX();
			int nextY = y + dir.getY();
			//bounds check
			boolean xBound = nextX < (this.maxX * 2) && nextX > 0;
			boolean yBound = nextY < (this.maxY * 2) && nextY > 0;
			boolean wallBound = !this.maze[nextX][nextY];
			if(wallBound && xBound && yBound) {
				
				//set wall before and after
				this.maze[nextX][nextY] = true;
				this.maze[x - dir.getX()][y - dir.getY()] = true;
				this.generateMaze(nextX, nextY);

			}
		} 



	}


	private void generateMaze(int x, int y) {
		//randomly order the directions to go in                                              
                Direction[] directions = Direction.getDirectionSet();                                 
                Collections.shuffle(Arrays.asList(directions));                                       
                        
                //for every direction
                for (Direction dir : directions) {
                        int nextX = x + dir.getX();                                                   
                        int nextY = y + dir.getY();                                                   
                        //bounds check                                                                
                        boolean xBound = nextX < (this.maxX * 2) && nextX > 0;                        
                        boolean yBound = nextY < (this.maxY * 2) && nextY > 0;                        
                        boolean wallBound = !this.maze[nextX][nextY];                                 
                        if(wallBound && xBound && yBound) {                                           
                                
                                //set wall before and after                                           
                                this.maze[nextX][nextY] = true;                                       
                                this.maze[x - dir.getX()][y - dir.getY()] = true;                     
                                this.generateMaze(nextX, nextY);                                      
                                
                        }
                }         
	}

	private void prettyPrint() {
		for(int y = 0; y < this.maxY * 2; y++) {
			System.out.println();
			for(int x = 0; x < this.maxX * 2; x++) {
				System.out.print( (this.maze[x][y] ) ? "X" : "O");
			}
		}
		System.out.println();
	}


}
