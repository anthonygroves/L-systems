package cs152;

public class LevyCurveLSystem extends LSystem{
	
	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public LevyCurveLSystem(String name, Turtle t, double size, int depth){
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
		
	}
	
	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.turn(180);
		t.move(75);
		t.turn(-180);
		t.penDown();
	}


	public void f(Turtle t, int depth){
		if(depth == 0)
			t.move(getSize());
		else{
			//F =  F++F++F L F-F++F
			//L replaces the | for ease

			plus(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			
		}
	}

	public void plus(Turtle t, int depth) {
		t.turn(45);
	}

	public void minus(Turtle t, int depth) {
		t.turn(-45);
	}
	


}
