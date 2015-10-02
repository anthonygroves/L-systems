package cs152;

public class HilbertCurveLSystem extends LSystem{

	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public HilbertCurveLSystem(String name, Turtle t, double size, int depth){
		super(name, t, size, depth);
		this.name = name;
		this.t = t;
		this.size = size;
		this.depth = depth;
	}
	
	
	@Override
	public void run(){
		adjustBeforeGraphing(t);
		l(t, depth);
	}
	
	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.turn(90);
		t.move(160);
		t.turn(90);
		t.move(160);
		t.turn(-180);
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
	
	
	public void l(Turtle t, int depth){
		// L = +RF-LFL-FR+
		
		if (depth > 0) {
			plus(t, depth-1);
			r(t, depth-1);
			f(t, depth-1);
			minus(t, depth-1);
			l(t, depth-1);
			f(t, depth-1);
			l(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
			r(t, depth-1);
			plus(t, depth-1);
		}
	}
	
	public void r(Turtle t, int depth){
		//R = -LF+RFR+FL-
		
		if (depth > 0) {
			minus(t, depth-1);
			l(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			r(t, depth-1);
			f(t, depth-1);
			r(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			l(t, depth-1);
			minus(t, depth-1);
		}
	}
	
}
