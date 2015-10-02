package cs152;

public class DragonCurveLSystem extends LSystem{

	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public DragonCurveLSystem(String name, Turtle t, double size, int depth){
		super(name, t, size, depth);
		this.name = name;
		this.t = t;
		this.size = size;
		this.depth = depth;
	}
	
	@Override
	public void run(){
		adjustBeforeGraphing(t);
		f(t, depth);
		x(t, depth);
	}
	
	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.move(75);
		t.turn(90);
		t.move(75);
		t.turn(180);
		t.penDown();
	}
	
	public void f(Turtle t, int depth){
			t.move(getSize());
	}
	
	public void plus(Turtle t, int depth) {
		t.turn(-90);
	}
	
	public void minus(Turtle t, int depth) {
		t.turn(90);
	}
	
	
	public void x(Turtle t, int depth){
		// x = x + yf
		
		if (depth > 0) {
			x(t, depth-1);
			plus(t, depth-1);
			y(t, depth-1);
			f(t, depth-1);
		}
	}
	
	public void y(Turtle t, int depth){
		//y = fx - y
		
		if (depth > 0) {
			f(t, depth-1);
			x(t, depth-1);
			minus(t, depth-1);
			y(t, depth-1);
		}
	}
	
	
	
}
