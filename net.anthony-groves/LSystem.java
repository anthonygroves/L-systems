package cs152;

public class LSystem {
	
	private String name;
	private double size;
	private int depth;
	
	public LSystem(String name, Turtle t, double size, int depth){
		this.name = name;
		this.size = size;
		this.depth = depth;
	}
	
	public void incrementSizeByTwo(){
		setSize(getSize()+2);
	}
	
	public void run(){
		
	}
	
	
	@Override
	public String toString(){
		return name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	

}
