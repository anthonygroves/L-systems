package cs152;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LSystemApplication extends JFrame{


	private static final long serialVersionUID = 1L;
	private Turtle turtle;
	private int selectedIndex;
	private TurtleDemo td;
	private int depth;
	private JTextField depthField;
	private int zoomLevel;

	public static void main(String[] args) {

		LSystemApplication app = new LSystemApplication();
		app.setVisible(true);


	}


	public LSystemApplication(){
		super("L System Application");
		setSize(this.getPreferredSize());
		populate(this);
	}


	public void populate(Container c){
		c.setLayout(new BorderLayout());
		turtle = new Turtle(getPreferredSize());
		selectedIndex = 0;
		td = new TurtleDemo();
		depth = 1;
		zoomLevel = 1;

		JPanel northPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(td);
		northPanel.add(scrollPane);
		c.add(northPanel, BorderLayout.NORTH);


		JPanel centerPanel = new JPanel();
		LSystem[] lSystemsArray = {new SierpinskiLSystem("Sierpinski's Triangle", turtle, 1, 8), 
				new DragonCurveLSystem("Dragon Curve",turtle,5, 10), 
				new HilbertCurveLSystem("Hilbert Curve",turtle, 5, 6),
				new KochSnowflakeLSystem("Koch Snowflake", turtle,4, 4),
				new PeanoCurveLSystem("PeanoCurve", turtle,4,4),
				new PentaPlexityLSystem("Penta Plexity", turtle,10,3),
				new LevyCurveLSystem("Levy Curve", turtle,5,10),
				new IslandAndLakeLSystem("Islands and Lakes", turtle, 5,2), };

		JComboBox<LSystem> lSystemBox = new JComboBox<LSystem>(lSystemsArray);
		lSystemBox.addActionListener(new LSystemComboBoxActionListener());
		centerPanel.add(lSystemBox);
		c.add(centerPanel, BorderLayout.CENTER);


		JPanel southPanel = new JPanel();
		c.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout());

		JPanel southSubPanel = new JPanel();
		southPanel.add(southSubPanel, BorderLayout.NORTH);

		JPanel southSubPanel2 = new JPanel();
		southPanel.add(southSubPanel2, BorderLayout.SOUTH);

		JButton draw = new JButton("Draw!");
		draw.addActionListener(new DrawActionListener());
		southSubPanel.add(draw);

		JButton zoomIn = new JButton("Zoom In");
		zoomIn.addActionListener(new ZoomInActionListener());
		southSubPanel.add(zoomIn);

		JButton zoomOut = new JButton("Zoom Out");
		zoomOut.addActionListener(new ZoomOutActionListener());
		southSubPanel.add(zoomOut);

		JButton autoFit = new JButton("Auto Fit");
		autoFit.addActionListener(new AutoFitActionListener());
		southSubPanel.add(autoFit);


		JLabel depthLabel = new JLabel("Depth size:");
		southSubPanel2.add(depthLabel, BorderLayout.WEST);

		depthField = new JTextField(10);
		southSubPanel2.add(depthField, BorderLayout.EAST);
		depthField.addActionListener(new DepthActionListener());


	}

	public int getDepth(){
		String depthString = depthField.getText();
		if(!depthString.isEmpty()){
			try{
				return Integer.parseInt(depthString);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "You have to enter an integer number in the depth text field!", 
						"User Entered Wrong Depth Value", JOptionPane.ERROR_MESSAGE);
				return 0;
			}
		}
		else
			return 0;
	}


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}



	public class LSystemComboBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			JComboBox<LSystem> comboBox = (JComboBox<LSystem>) e.getSource();
			selectedIndex = comboBox.getSelectedIndex();
		}
	}


	public class DrawActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			zoomLevel = 1;
			td.clearTurtle();
			if(getDepth() > 0){
				depth = getDepth();
				td.setList(1,depth);
			}
			else
				td.setList(1);
			td.run(selectedIndex);

		}
	}

	public class ZoomInActionListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {

			zoomLevel++;

			td.clearTurtle();
			if(getDepth() > 0){
				depth = getDepth();
				td.setList(zoomLevel,depth);
			}
			else
				td.setList(zoomLevel);
			td.zoomInSpecifiedLSystem(selectedIndex);
			td.run(selectedIndex);
		}
	}


	public class ZoomOutActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(zoomLevel>1)
				zoomLevel--;

			td.clearTurtle();
			if(getDepth() > 0){
				depth = getDepth();
				td.setList(zoomLevel,depth);
			}
			else
				td.setList(zoomLevel);
			td.run(selectedIndex);
		}
	}

	public class AutoFitActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			zoomLevel = 1;

			td.clearTurtle();
			td.setList(1);
			td.run(selectedIndex);
		}
	}


	public class DepthActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}


}