package cs152;

public class SierpinskiLSystem extends LSystem{
	
	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public SierpinskiLSystem(String name, Turtle t, double size, int depth){
		super(name, t, size, depth);
		this.name = name;
		this.t = t;
		this.size = size;
		this.depth = depth;
	}
	
	@Override
	public void incrementSizeByTwo(){
		setSize(this.getSize()+2);
	}
	
	
	@Override
	public void run(){
		//F-G-G
		adjustBeforeGraphing(t);
		
		f(t, depth);
		minus(t, depth);
		g(t, depth);
		minus(t, depth);
	}
	
	public void adjustBeforeGraphing(Turtle t){
		t.penUp();
		t.turn(90);
		t.move(100);
		t.turn(90);
		t.move(125);
		t.turn(-180);
		t.penDown();
	}
	
	
	public void f(Turtle t, int depth){
		if(depth == 0)
			t.move(getSize());
		else{
			//F =  F-G+F+G-F

			f(t, depth-1);
			minus(t, depth-1);
			g(t, depth-1);
			plus(t, depth-1);
			f(t, depth-1);
			plus(t, depth-1);
			g(t, depth-1);
			minus(t, depth-1);
			f(t, depth-1);
		}
	}



	public void g(Turtle t, int depth){
		if(depth == 0)
			t.move(getSize());
		else{
			//G  =  GG

			g(t, depth-1);
			g(t, depth-1);
		}
	}


	public void plus(Turtle t, int depth) {
			t.turn(120);
	}

	public void minus(Turtle t, int depth) {
			t.turn(-120);
	}

}
