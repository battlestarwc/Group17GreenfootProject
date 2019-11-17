public class Cell {

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

}
