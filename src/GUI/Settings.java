package GUI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.event.*;

/**
 * Creates a settings screen that displays interactive options for the ecosystem in the Game class.
 * <p>
 * The Settings class defines a JLayeredPane that contains sliders for the simulation speed, temperature, and resource rate of the simulation.
 * There are also button selections that can change weather conditions to alter the state of the ecosystem.
 */
@SuppressWarnings("serial")
public class Settings extends JLayeredPane implements MouseListener, ActionListener {
	//fields
	/**	
	 * list of game buttons on the menu that allow users to click different options
	 */
	public gameBtn sun, cloud, rain, reset, onA, onB, offA, offB, exit;
	
	/**
	 * list of sliders on the settings menu that allows user to modify the environment
	 */
	public Slider RR, simSpeed, temp;
	private boolean ndOn;
	private Image image = null;

	/**
	 * Constructs a settings screen using defined gameBtn and Slider objects, which allow for the user to select conditions using mouse clicks.
	 * The width defines the size of the screen.
	 * 
	 * @param w Width of the screen
	 */
	public Settings(int w)
	{
		setSize(w, w*5 / 6);		//sets size of Settings
		
		//load in background image
		try
		{
			image = ImageIO.read(new File("Summative Graphics\\Menu\\png\\settings bg.png"));
		}
		catch (IOException e)
		{
		}

		// Create new buttons
		sun = new gameBtn("Summative Graphics\\Menu\\png\\sunButton.png",this.getSize().height/5, this.getSize().height/5);
		cloud = new gameBtn("Summative Graphics\\Menu\\png\\cloudButton.png",this.getSize().height/5, this.getSize().height/5);
		rain = new gameBtn("Summative Graphics\\Menu\\png\\rainButton.png",this.getSize().height/5, this.getSize().height/5);
		reset = new gameBtn("Summative Graphics\\Menu\\png\\resetButton.png",this.getSize().height/5, this.getSize().height/5);
		onA = new gameBtn("Summative Graphics\\Menu\\png\\onButtonA.png",this.getSize().height/4, this.getSize().height/8);
		onB = new gameBtn("Summative Graphics\\Menu\\png\\onButtonB.png",this.getSize().height/4, this.getSize().height/8);
		offA = new gameBtn("Summative Graphics\\Menu\\png\\offButtonA.png",this.getSize().height/4, this.getSize().height/8);
		offB = new gameBtn("Summative Graphics\\Menu\\png\\offButtonB.png",this.getSize().height/4, this.getSize().height/8);
		
		//create new sliders for different environmental factors
		simSpeed = new Slider(this.getSize().height/2);
		RR = new Slider(this.getSize().height/2);
		temp = new Slider(this.getSize().height/2);

		//set sizes for weather buttons
		sun.setBounds(this.getSize().height/5, this.getSize().height/3 + this.getSize().height/25, this.getSize().height/5, this.getSize().height/5);
		cloud.setBounds(2*this.getSize().height/5, this.getSize().height/3 + this.getSize().height/25, this.getSize().height/5, this.getSize().height/5);
		rain.setBounds(3*this.getSize().height/5, this.getSize().height/3 + this.getSize().height/25, this.getSize().height/5, this.getSize().height/5);
		reset.setBounds(4*this.getSize().height/5, this.getSize().height/3 + this.getSize().height/25, this.getSize().height/5, this.getSize().height/5);

		//set sizes for natural disaster buttons
		onA.setBounds(5*this.getSize().height/6 + this.getSize().height/16, 2*this.getSize().height/3, this.getSize().height/4, this.getSize().height/8);
		onB.setBounds(5*this.getSize().height/6 + this.getSize().height/16, 2*this.getSize().height/3, this.getSize().height/4, this.getSize().height/8);
		offA.setBounds(4*this.getSize().height/6 - this.getSize().height/12, 2*this.getSize().height/3, this.getSize().height/4, this.getSize().height/8);
		offB.setBounds(4*this.getSize().height/6 - this.getSize().height/12, 2*this.getSize().height/3, this.getSize().height/4, this.getSize().height/8);

		//set sizes for sliders
		simSpeed.setBounds(this.getSize().height/2 + this.getSize().height/12, this.getSize().height/6 + this.getSize().height/88, this.getSize().height/2, this.getSize().height/12);
		temp.setBounds(this.getSize().height/2 + this.getSize().height/12, this.getSize().height/2 + 17*this.getSize().height/256, this.getSize().height/2, this.getSize().height/12);
		RR.setBounds(this.getSize().height/2 + this.getSize().height/12, 2*this.getSize().height/3+4*this.getSize().height/30, this.getSize().height/2, this.getSize().height/12);

		//create layout of background and background image
		Image newImage = image.getScaledInstance(this.getSize().width-20, this.getSize().height-50, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(newImage);
		JLabel pic = new JLabel(icon);	 
		JPanel bg = new JPanel();
		bg.setOpaque(false);
		bg.add(pic);
		bg.setVisible(true);
		bg.setBounds(10, 10, getSize().width-20, getSize().height-20);

		// Place the background on base layer
		add(bg, new Integer(0));
		
		//place buttons on different layers
		add(sun, new Integer(2));
		add(cloud, new Integer(2));
		add(rain, new Integer(2));
		add(reset, new Integer(2));
		add(onB, new Integer(3));
		add(onA, new Integer(3));
		add(offA, new Integer(3));
		add(offB, new Integer(3));
		
		//add sliders to layer 3
		add(simSpeed, new Integer(3));
		add(RR, new Integer(3));
		add(temp, new Integer(3));

		//set background colour to fully transparent
		this.setBackground(new Color (0,0,0,0));

	}

	//display method
	protected void paintComponent(Graphics g) {

		//if onA is clicked, redraw the natural disaster buttons accordingly
		if (onA.clicked())
		{
			onA.setVisible(false);
			onB.setVisible(true);
			offB.setVisible(false);
			offA.setVisible(true);
			onA.unclick();
		}

		//if onB is clicked, redraw the natural disaster buttons accordingly
		if (onB.clicked())
		{
			onB.setVisible(false);
			onA.setVisible(true);
			offA.setVisible(false);
			offB.setVisible(true);
			onB.unclick();
		}

		//if offA is clicked, redraw the natural disaster buttons accordingly
		if (offA.clicked())
		{
			offA.setVisible(false);
			offB.setVisible(true);
			onB.setVisible(false);
			onA.setVisible(true);
			offA.unclick();
		}

		//if offB is clicked, redraw the natural disaster buttons accordingly
		if (offB.clicked())
		{
			offB.setVisible(false);
			offA.setVisible(true);
			onA.setVisible(false);
			onB.setVisible(true);
			offB.unclick();
		}

		//sets background to transparent
		this.setOpaque(false);
		// This call will paint the label and the focus rectangle.
		super.paintComponent(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Set the settings screen to invisible.
	 */
	public void makeInvisible() {
		this.setVisible(false);
	}

//	public static void main (String[] args) {
//		Settings window = new Settings(625);
//		// Create a frame in which to show the button.
//		JFrame frame = new JFrame();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(window);
//
//		//frame.getContentPane().setLayout(new FlowLayout());
//		frame.setSize(1200, 1200);
//		frame.setVisible(true);
//
//	}


}

