import greenfoot.*;


<<<<<<< HEAD
public class InitWallBorder {

	private final int maxX;
	private final int maxY;
	private final Class targetClass;

=======
public class InitWallBorder 
{
	private final int maxX;
	private final int maxY;
	private final Class targetClass;
>>>>>>> actor_dev
	public InitWallBorder(int maxx, int maxy, Class target) {
		this.maxX = maxx;
		this.maxY = maxy;
		this.targetClass = target;
<<<<<<< HEAD
	}

	public void load(World w) {
		for (double i = 0; i < 360; i = i + 0.001) {
			w.addObject(this.targetClass.newInstance(), Math.round(this.maxX * Math.sin( Math.toRadians(i) ) ), Math.round(this.maxY * Math.cos( Math.toRadians(i) )) );
		}	
	}

}

=======
}
 	public void load(World w) {
		for (double i = 0; i < 360; i = i + 0.55) {
		    try{
			w.addObject( (Actor) this.targetClass.newInstance(), (int) Math.round(this.maxX * Math.sin( Math.toRadians(i) ) ), (int) Math.round(this.maxY * Math.cos( Math.toRadians(i) )) );
} catch (Exception e) {
    System.out.println(e); }
}
}
}
>>>>>>> actor_dev
