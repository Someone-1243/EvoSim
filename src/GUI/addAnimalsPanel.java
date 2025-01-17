package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Represents a component of the overall display class to be used as a user interaction component in the game.
 * <p>
 * The panel is incorporated in the game mode and allows for users to select to add a type of animal to the landscape.
 * Existing patterns and scenarios can also be accessed for examples of various possibilities within the game.
 */
@SuppressWarnings("serial")
public class addAnimalsPanel extends JLayeredPane implements MouseListener, ActionListener {
	
	/** Buttons for each of the individual types of animal that can be added to the landscape
	 */
	public gameBtn addAmphibian, addCanine, addCellular, addFeline, addFish, addHooved, addLizard, addPrimate, addRaptor, addRodent, addSmallBird, addSnake, addTurtle;
	
	/**3 game buttons for three loadable scenarios
	 */
	public gameBtn s1, s2, s3;
	
	/**Field representing a list of all the buttons that are used to populate the landscape 
	 */
	public ArrayList<gameBtn> list;
	private Image image = null;
	
	/**
	 * Constructs the panel with gameBtn objects that the user may select to add animals to the game.
	 * 
	 * @param w Desired width of the screen
	 */
	public addAnimalsPanel(int w) {
		setSize(w, w*5 / 6);		//set size
		
		//load image for background
		try
		{
			image = ImageIO.read(new File("Summative Graphics\\addAnimal\\background.png"));
		}
		catch (IOException e)
		{
		}
		
		// Create new buttons
		addAmphibian = new gameBtn("Summative Graphics\\addAnimal\\addAmphibian.png",this.getSize().width/4, this.getSize().height/8);
		addCanine = new gameBtn("Summative Graphics\\addAnimal\\addCanine.png",this.getSize().width/4, this.getSize().height/8);
		addCellular = new gameBtn("Summative Graphics\\addAnimal\\addCellular.png",this.getSize().width/4, this.getSize().height/8);
		addFeline = new gameBtn("Summative Graphics\\addAnimal\\addFeline.png",this.getSize().width/4, this.getSize().height/8);
		addFish = new gameBtn("Summative Graphics\\addAnimal\\addFish.png",this.getSize().width/4, this.getSize().height/8);
		addHooved = new gameBtn("Summative Graphics\\addAnimal\\addHooved.png",this.getSize().width/4, this.getSize().height/8);
		addLizard = new gameBtn("Summative Graphics\\addAnimal\\addLizard.png",this.getSize().width/4, this.getSize().height/8);
		addPrimate = new gameBtn("Summative Graphics\\addAnimal\\addPrimate.png",this.getSize().width/4, this.getSize().height/8);
		addRaptor = new gameBtn("Summative Graphics\\addAnimal\\addRaptor.png",this.getSize().width/4, this.getSize().height/8);
		addRodent = new gameBtn("Summative Graphics\\addAnimal\\addRodent.png",this.getSize().width/4, this.getSize().height/8);
		addSmallBird = new gameBtn("Summative Graphics\\addAnimal\\addSmallBird.png",this.getSize().width/4, this.getSize().height/8);
		addSnake = new gameBtn("Summative Graphics\\addAnimal\\addSnake.png",this.getSize().width/4, this.getSize().height/8);
		addTurtle = new gameBtn("Summative Graphics\\addAnimal\\addTurtle.png",this.getSize().width/4, this.getSize().height/8);
		s1 = new gameBtn("Summative Graphics\\addAnimal\\scenario1.png",this.getSize().width/4, this.getSize().height/8);
		s2 = new gameBtn("Summative Graphics\\addAnimal\\scenario2.png",this.getSize().width/4, this.getSize().height/8);
		s3 = new gameBtn("Summative Graphics\\addAnimal\\scenario3.png",this.getSize().width/4, this.getSize().height/8);
	
		//add buttons for adding animals into the arraylist
		list = new ArrayList<gameBtn>(13);
		list.add(addAmphibian);
		list.add(addCanine);
		list.add(addCellular);
		list.add(addFeline);
		list.add(addFish);
		list.add(addHooved);
		list.add(addLizard);
		list.add(addPrimate);
		list.add(addRaptor);
		list.add(addRodent);
		list.add(addSmallBird);
		list.add(addSnake);
		list.add(addTurtle);
		
		//set sizes and locations of animal buttons
		for (int x = 0; x < list.size(); x++)
		{
			list.get(x).setBounds(this.getSize().height/16 *( (x % 3) + 1) + this.getSize().width/4 *(x % 3), this.getSize().height/12 + this.getSize().height/21*((x / 3) + 1) + this.getSize().height/15 *(x / 3), this.getSize().width/4, this.getSize().height/8);
			
		}
		
		//set sizes and locations for settings buttons
		s1.setBounds(this.getSize().height/16, 6*this.getSize().height/8 + this.getSize().height/16 , this.getSize().width/4, this.getSize().height/8);
		s2.setBounds(this.getSize().height/16*2 + this.getSize().width/4  , 6*this.getSize().height/8 + this.getSize().height/16, this.getSize().width/4, this.getSize().height/8);
		s3.setBounds(this.getSize().height/16*3 + 2*this.getSize().width/4, 6*this.getSize().height/8 + this.getSize().height/16, this.getSize().width/4, this.getSize().height/8);
				
		//make JPanel for the background and make it visible
		Image newImage = image.getScaledInstance(this.getSize().width-20, this.getSize().height-50, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(newImage);

		JLabel pic = new JLabel(icon);	 
		JPanel bg = new JPanel();
		bg.setOpaque(false);
		bg.add(pic);
		bg.setVisible(true);
		bg.setBounds(10, 10, getSize().width-20, getSize().height-20);
		
		add(bg, new Integer(0));		//add the background to the panel
		
		//add buttons
		for (int x = 0; x < list.size(); x++)
		{
			this.add(list.get(x), new Integer(1));
		}

		//add buttons
		add(s1, new Integer(1));
		add(s2, new Integer(1));
		add(s3, new Integer(1));

		//make background transparent
		this.setBackground(new Color (0,0,0,0));
	}
	
//	public static void main (String[] args) {
//		addAnimalsPanel window = new addAnimalsPanel(625);
//		// Create a frame in which to show the button.
//		JFrame frame = new JFrame();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(window);
//
//		//frame.getContentPane().setLayout(new FlowLayout());
//		frame.setSize(1200, 1200);
//		frame.setVisible(true);
//	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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

}
