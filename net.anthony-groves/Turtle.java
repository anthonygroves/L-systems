package cs152;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Turtle {
	
	private Graphics graphics;
	private Dimension playfieldSize;
	private BufferedImage image;
	
	private double x, y;
	private double heading;
	private boolean penIsDown;
	private Color penColor;

	public Turtle(Dimension playfieldSize) {
		this.playfieldSize = playfieldSize;
		image = new BufferedImage(
				(int)playfieldSize.getWidth(), 
				(int)playfieldSize.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		graphics = image.getGraphics();
		
		
		x = 0;
		y = 0;
		heading = 0;
		penIsDown = true;
		penColor = Color.black;
	}
	
	public Turtle(Turtle other) {
		this.graphics = other.graphics;
		this.playfieldSize = other.playfieldSize;
		this.image = other.image;
		
		this.x = other.x;
		this.y = other.y;
		this.heading = other.heading;
		this.penIsDown = other.penIsDown;
		this.penColor = new Color(
				other.penColor.getRed(), 
				other.penColor.getGreen(), 
				other.penColor.getBlue());
	}
	
	public Turtle copy() {
		return new Turtle(this);
	}
	
	public synchronized void move(double distance)  {
		double destination_x = x + distance*Math.cos(Math.toRadians(heading));
		double destination_y = y + distance*Math.sin(Math.toRadians(heading));
		
		if (penIsDown) drawLine(x,y,destination_x,destination_y);
		
		x = destination_x;
		y = destination_y;
	}

	private synchronized void drawLine(double start_x, double start_y, double destination_x,
			double destination_y) {
		Color oldColor = graphics.getColor();
		graphics.setColor(penColor);
		graphics.drawLine(
				xform_x(start_x), 
				xform_y(start_y), 
				xform_x(destination_x), 
				xform_y(destination_y));
		graphics.setColor(oldColor);
	}

	private synchronized int xform_y(double y) {
		return (int)(playfieldSize.getHeight()/2 - y + 0.5);
	}

	private synchronized int xform_x(double x) {
		return (int)(x+playfieldSize.getWidth()/2+0.5);
	}

	public synchronized void turn(double angle) {
		heading += angle;
	}

	public synchronized void penUp() {
		penIsDown = false;
	}

	public synchronized void penDown() {
		penIsDown = true;
	}

	public synchronized void setPenColor(Color color) {
		penColor = color;
	}

	public synchronized void drawOn(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	
	

}
