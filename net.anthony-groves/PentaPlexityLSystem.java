package cs152;

public class PentaPlexityLSystem extends LSystem{

	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public PentaPlexityLSystem(String name, Turtle t, double size, int depth){
		super(name, t, size, depth);
		this.name = name;
		this.t = t;
		this.size = size;
		this.depth = depth;
	}


	@Override
	public void run(){
		adjustBeforeGraphing(t);
		
		//F++F++F++F++F
		f(t, depth);
		plus(t, depth);
		plus(t, depth);
		f(t, depth);
		plus(t, depth);
		plus(t, depth);
		f(t, depth);
		plus(t, depth);
		plus(t, depth);
		f(t, depth);
		plus(t, depth);
		plus(t, depth);
		f(t, depth);
		
	}
	
	
	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.turn(90);
		t.move(150);
		t.turn(90);
		t.move(90);
		t.turn(-180);
		t.penDown();
	}


	public void f(Turtle t, int depth){
		if(depth == 0)
			t.move(getSize());
		else{
			//F =  F++F++F L F-F++F
			//L replaces the | for ease

			f(t, depth-1);
			plus(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			l(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			
		}
	}

	public void plus(Turtle t, int depth) {
		t.turn(-36);
	}

	public void minus(Turtle t, int depth) {
		t.turn(36);
	}
	
	public void l(Turtle t, int depth) {
		t.turn(180);
	}

	
	
}
