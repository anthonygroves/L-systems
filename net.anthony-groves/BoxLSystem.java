package cs152;

public class BoxLSystem extends LSystem{
	
	private Turtle t;
	private String name;
	private double size;
	private int depth;
	
	public BoxLSystem(String name, Turtle t, double size, int depth){
		super(name, t, size, depth);
		this.t = t;
		this.name = name;
		this.size = size;
		this.depth = depth;
	}
	
	@Override
	public void run(){
		for(int i=0; i < 4; i++) {
			t.move(100);
			t.turn(90);
		}
	}

}
