package cs152;

public class KochSnowflakeLSystem extends LSystem{

	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public KochSnowflakeLSystem(String name, Turtle t, double size, int depth){
		super(name, t, size, depth);
		this.name = name;
		this.t = t;
		this.size = size;
		this.depth = depth;
	}


	@Override
	public void run(){
		
		adjustBeforeGraphing(t);
		// F--F--F
		f(t, depth);
		minus(t, depth);
		minus(t, depth);
		f(t, depth);
		minus(t, depth);
		minus(t, depth);
		f(t, depth);
	}

	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.turn(-90);
		t.move(100);
		t.turn(270);
		t.move(160);
		t.turn(-180);
		t.penDown();
	}

	public void f(Turtle t, int depth){
		if(depth == 0)
			t.move(getSize());
		else{
			//F =  F+F--F+F

			f(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
		}
	}

	public void plus(Turtle t, int depth) {
		t.turn(-60);
	}

	public void minus(Turtle t, int depth) {
		t.turn(60);
	}

}
