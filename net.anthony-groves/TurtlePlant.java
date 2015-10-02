package cs152;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TurtlePlant extends JPanel {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Turtle Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new BorderLayout());
		TurtlePlant td = new TurtlePlant();
		f.getContentPane().add(td, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		td.startTurtleThread();
		td.startRepaintThread();
	}
	
	public void f(Turtle t, int depth) {
		if (depth == 0) {
			t.move(5);
		} else {
			f(t, depth-1);
			f(t, depth-1);
		}
	}
	
	// x doesn't cause any drawing operations so depth == 0 case doesn't 
	// need to do anything.
	public void x(Turtle t, int depth) {
		if (depth > 0) {
			// F-[[X]+X]+F[+FX]-X)
			f(t, depth-1);
			minus(t, depth-1);
		}
	}
	
	
	// constants don't actually need to make the recursive calls!
	public void plus(Turtle t, int depth) {
		t.turn(60);
	}
	
	public void minus(Turtle t, int depth) {
		t.turn(60);
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

	private Turtle turtle;
	
	private void startTurtleThread() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				turtle = new Turtle(getPreferredSize());
				turtle.penUp();
				turtle.turn(180);
				turtle.move(300);
				turtle.turn(-180);
				turtle.penDown();
				turtle.setPenColor(Color.black);
				f(turtle, 5);			
			}
		});
		t.start();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (turtle != null) {
			turtle.drawOn(g);
		}
	}
	
	private void box(Turtle t, double size_length) {
		for(int i=0; i < 4; i++) {
			t.move(size_length);
			t.turn(90);
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
