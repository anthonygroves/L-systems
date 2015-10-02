package cs152;

public class IslandAndLakeLSystem extends LSystem{
	
	
	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public IslandAndLakeLSystem(String name, Turtle t, double size, int depth){
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
		plus(t, depth);
		f(t, depth);
		plus(t, depth);
		f(t, depth);
		plus(t, depth);
		f(t, depth);
	}

	
	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.turn(90);
		t.move(100);
		t.turn(90);
		t.move(100);
		t.turn(-180);
		t.penDown();
	}

	public void f(Turtle t, int depth){
		if(depth == 0)
			t.move(getSize());
		else{
			//F =  F+f-FF   +F+FF+F   f+FF-f  +FF-F  -FF-F   f-FFF

			f(t, depth-1);
			plus(t, depth-1);
			fLowercase(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			
			plus(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			
			fLowercase(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			fLowercase(t, depth-1);
			
			
			plus(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			
			
			minus(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			
			
			fLowercase(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			f(t, depth-1);
			
		}
	}
	
	
	public void fLowercase(Turtle t, int depth){
		if(depth == 0){
			t.penUp();
			t.move(5);
			t.penDown();
		}
		else{
			fLowercase(t, depth-1);
			fLowercase(t, depth-1);
			fLowercase(t, depth-1);
			fLowercase(t, depth-1);
			fLowercase(t, depth-1);
			fLowercase(t, depth-1);
		}
	}

	public void plus(Turtle t, int depth) {
		t.turn(-90);
	}

	public void minus(Turtle t, int depth) {
		t.turn(90);
	}


}
