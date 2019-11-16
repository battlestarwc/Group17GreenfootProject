import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Maze implements Runnable {

    private final int size;
    private Cell[][] maze;

    public Maze(int size) {
        //requires a square size
        this.size = size;
        this.maze = new Cell[size][size];
    }

    private void loadInitial() {
        for(int x = 0; x < this.size; x++) {
            for(int y = 0; y < this.size; y++) {
                this.maze[x][y] = new Cell(x, y, true);
            }
        }

        /*
        //for x and y values
        //if x or y is at bound or 0, make a wall
        //otherwise make a grid

        //the last boolean will act as an itr on/off
        //this way it goes one then skip, and continues after the wall limits
        boolean last = false;
        for (int x = 0; x < this.size; x++) {
            //offset on new line for even x/y values, its ok for odd values
            if(this.size % 2 == 0) {
                if (last) {
                    last = false;
                } else {
                    last = true;
                }
            }
            for (int y = 0; y < this.size; y++) {
                if(x == this.size -1 || x == 0 || y == this.size -1 || y == 0) {
                    this.maze[x][y] = new Cell(x, y, true);
                } else {
                    this.maze[x][y] = new Cell(x, y, last);
                    if (last) {
                        last = false;
                    } else {
                        last = true;
                    }
                }
            }
        }

         */
    }

    //attempt the algorithm on the wikipedia page
    private void randomizedPrimsAlgorithm() {
        Random r = new Random();
        //wall queue
        LinkedBlockingQueue<Cell> wallQueue = new LinkedBlockingQueue<>();

        int y = Math.abs(r.nextInt() % this.size);
        int x = Math.abs(r.nextInt() % this.size);

        if(x + 1 < this.size) {
            wallQueue.add(this.maze[x + 1][y]);
        }
        if(x - 1 >= 0) {
            wallQueue.add(this.maze[x - 1][y]);
        }
        if(y + 1 < this.size) {
            wallQueue.add(this.maze[x][y + 1]);
        }
        if(y - 1 >= 0) {
            wallQueue.add(this.maze[x][y - 1]);
        }

        //add starting point
        wallQueue.add(this.maze[this.size / 2][this.size / 2]);
        //add another few random points
        wallQueue.add(this.maze[Math.abs(r.nextInt() % this.size)][Math.abs(r.nextInt() % this.size)]);
        wallQueue.add(this.maze[Math.abs(r.nextInt() % this.size)][Math.abs(r.nextInt() % this.size)]);
        wallQueue.add(this.maze[Math.abs(r.nextInt() % this.size)][Math.abs(r.nextInt() % this.size)]);


        //check wall neighbors
        while(!wallQueue.isEmpty()) {

            List<Cell> shuffleQueue = new ArrayList<>(wallQueue);
            Collections.shuffle(shuffleQueue);

            int count = 0; //count the number of connected

            Cell c = wallQueue.poll();

            x = c.getX();
            y = c.getY();

            if(x + 1 < this.size) {
                if(!this.maze[x+1][y].isWall()) {
                    count++;
                }
            }
            if(x - 1 >= 0) {
                if(!this.maze[x-1][y].isWall()) {
                    count++;
                }
            }
            if(y + 1 < this.size) {
                if(!this.maze[x][y+1].isWall()) {
                    count++;
                }
            }
            if(y - 1 >= 0) {
                if(!this.maze[x][y-1].isWall()) {
                    count++;
                }
            }

            if (count > 1) {
                continue;
            } else {
                this.maze[x][y].changeWall();
                if(x + 1 < this.size) {
                    if(this.maze[x+1][y].isWall()) {
                        wallQueue.add(this.maze[x+1][y]);
                    }
                }
                if(x - 1 >= 0) {
                    if(this.maze[x-1][y].isWall()) {
                        wallQueue.add(this.maze[x-1][y]);
                    }
                }
                if(y + 1 < this.size) {
                    if(this.maze[x][y+1].isWall()) {
                        wallQueue.add(this.maze[x][y+1]);
                    }
                }
                if(y - 1 >= 0) {
                    if(this.maze[x][y-1].isWall()) {
                        wallQueue.add(this.maze[x][y-1]);
                    }
                }
            }

        }

    }


    private void bound() {
        for(int i = 0; i < this.size; i++) {
            if(!this.maze[i][0].isWall()) {
                this.maze[i][0].changeWall();
            }
            if(!this.maze[0][i].isWall()) {
                this.maze[0][i].changeWall();
            }
            if(!this.maze[i][this.size - 1].isWall()) {
                this.maze[i][this.size - 1].changeWall();
            }
            if(!this.maze[this.size - 1][i].isWall()) {
                this.maze[this.size - 1][i].changeWall();
            }
        }
    }


    public void prettyPrint() {
        for(int x = 0; x < this.size; x++) {
            System.out.println();
            for(int y = 0; y < this.size; y++) {
                if(x == this.size / 2 && y == this.size / 2) {
                    System.out.print("+");
                } else {
                    System.out.print((this.maze[x][y].isWall()) ? "X" : "O");
                }
            }
        }
        System.out.println();
    }


    @Override
    public void run() {
        this.loadInitial();
        this.randomizedPrimsAlgorithm();
        //if (this.maze[this.size/2][this.size/2].isWall()) {
        //    this.maze[this.size/2][this.size/2].changeWall();
        //}
        this.bound();
        this.prettyPrint();
    }
}
