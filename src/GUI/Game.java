package GUI;

import java.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.event.*;
import Ecosystem.*;


public class Game extends JFrame implements MouseListener, KeyListener, ActionListener, ChangeListener {

	int w, h;
	Landscape landscape;
	static Timer t;
	gameBtn settings;
	DrawArea board;
	boolean settingOn = false;
	
	Settings settingsMenu;
	
	public Game(int width) {
		landscape = new Landscape();
		t = new Timer(1999, this);
		
		t.start();
		t.addActionListener(this);
		
		// set size
		w = width;
		h = w * 5 / 6;
		setSize(w, h);
		
		Settings settingsMenu = new Settings(width*4/5);
		//settingsMenu.setVisible(true);
		
		// create things to add to pane  --------------------- PICK A DIFFERENT BUTTON
		settings = new gameBtn("Summative Graphics\\Menu\\settings.png",this.getSize().height/8, this.getSize().height/8);
		settings.setBounds(this.getSize().height, this.getSize().height/16, this.getSize().height/8, this.getSize().height/8);

		settings.addActionListener(this);
		
		// panels to add
		board = new DrawArea(w, h);
		
		add(settings);
		//add(settingsMenu);
		add(board);	
	}
	
	class DrawArea extends JPanel									// drawarea class for drawing landscape
	{
		public DrawArea (int width, int height)
		{
			// set size 
			this.setPreferredSize(new Dimension (width, height));
		}

		public void paintComponent (Graphics g)
		{
			landscape.show(g);
			//g.setColor(Color.BLACK);
			//g.fillRect(0, 0, board.getSize().width, board.getSize().height);
		}
	}
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(t))
        {
            landscape.advance();
        }
		
        else if (e.getSource().equals(settings))
        {
            //settingOn = !settingOn;
            if(settingOn)
            	t.setDelay(111);
            //settingsMenu.setVisible(false);
        }
        
        this.repaint();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_UP) {						// for movement
			
		} 
		else if(keyCode == KeyEvent.VK_LEFT) {
			
		}
		else if(keyCode == KeyEvent.VK_RIGHT) {
			
		}
		else if(keyCode == KeyEvent.VK_DOWN) {
			
		}
		
	}

	public void keyReleased(KeyEvent e) {	// maybe have a boolean thats set false when released for movement
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Game game = new Game(1200);
		Animal animal = new Mammal("Summative Graphics\\Animals\\animal2.png", 1, 1, 1, "Male");
		game.landscape.populate(animal);
<<<<<<< HEAD
		game.setVisible(true);
=======
<<<<<<< HEAD
		game.setVisible(true);
		
=======
		game.setVisible(false);
>>>>>>> c8f4fb667d1b63de8e51fcee6a315e812d1671f8
>>>>>>> 64778777faf14875e21c4d7020ee22930cd429ac
		/*
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(game);
		frame.setContentPane(game);

		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(1200, 1000);
		frame.setVisible(true);
		*/
	}
}