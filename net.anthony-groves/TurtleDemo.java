package cs152;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TurtleDemo extends JPanel {

	private ArrayList<LSystem> list;
	private Turtle turtle;


	public TurtleDemo(){
		turtle = new Turtle(getPreferredSize());
		setList(1);
	}
	
	public void run(int index){

		startTurtleThread(index);
		startRepaintThread();
	}

	public void clearTurtle(){
		turtle = new Turtle(getPreferredSize());
	}
	

	public void setList(int zoomLevel){

		list = new ArrayList<LSystem>();
		list.add(new SierpinskiLSystem("Sierpinski's Triangle",turtle,1*zoomLevel,8));
		list.add(new DragonCurveLSystem("Dragon Curve",turtle,5*zoomLevel,10));
		list.add(new HilbertCurveLSystem("Hilbert Curve",turtle,5*zoomLevel,6));
		list.add(new KochSnowflakeLSystem("Koch Snowflake",turtle,4*zoomLevel,4));
		list.add(new PeanoCurveLSystem("Peano Curve",turtle,4*zoomLevel,4));
		list.add(new PentaPlexityLSystem("Penta Plexity",turtle,10*zoomLevel,3));
		list.add(new LevyCurveLSystem("Levy Curve",turtle,5*zoomLevel,10));
		list.add(new IslandAndLakeLSystem("Island and Lakes",turtle,5*zoomLevel,2));

	}
	
	
	public void setList(int zoomLevel, int depth){

		list = new ArrayList<LSystem>();
		list.add(new SierpinskiLSystem("Sierpinski's Triangle",turtle,1*zoomLevel,depth));
		list.add(new DragonCurveLSystem("Dragon Curve",turtle,5*zoomLevel,depth));
		list.add(new HilbertCurveLSystem("Hilbert Curve",turtle,5*zoomLevel,depth));
		list.add(new KochSnowflakeLSystem("Koch Snowflake",turtle,4*zoomLevel,depth));
		list.add(new PeanoCurveLSystem("Peano Curve",turtle,4*zoomLevel,depth));
		list.add(new PentaPlexityLSystem("Penta Plexity",turtle,10*zoomLevel,depth));
		list.add(new LevyCurveLSystem("Levy Curve",turtle,5*zoomLevel,depth));
		list.add(new IslandAndLakeLSystem("Island and Lakes",turtle,5*zoomLevel,depth));

	}

	

	public void zoomInSpecifiedLSystem(int index){
		list.get(index).incrementSizeByTwo();
	}


	public ArrayList<LSystem> getList(){
		return list;
	}



	private void startRepaintThread() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				while(!Thread.interrupted()) {
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		t.start();
	}



	private void startTurtleThread( final int index) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				turtle.penUp();
				turtle.penDown();
				turtle.setPenColor(Color.black);
				list.get(index).run();
			}
		});
		t.start();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400,400);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (turtle != null) {
			turtle.drawOn(g);
		}
	}


	private void shortPause() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.exit(0);
		}
	}

}
