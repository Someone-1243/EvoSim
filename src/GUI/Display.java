package GUI;

import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import javax.swing.*;
import java.io.*;
import javax.swing.event.*;

import Ecosystem.*;

public class Display extends JFrame implements MouseListener, ActionListener{
	Game game;
	MainMenu menu;
	int w,h;
	boolean selected = false;
	
	public Display(int width)
	{
		// set size
		w = width;
		h = w * 5 / 6;
		setSize(w, h);
				
		game = new Game(this.getSize().width);
		game.pauseTimer();
		menu = new MainMenu(this.getSize().width);
		
		menu.simMode.addActionListener(this);
		menu.gameMode.addActionListener(this);
		
		Animal cell = new Amphibian("amphibian", 1, 1, 10000, "Female");
		game.landscape.populate(cell);
		
		//setContentPane(game);
		setContentPane(menu);
		
	}
    

	class drawArea extends JPanel {

    	public drawArea (int width, int height)
		{
			// set size 
			this.setPreferredSize(new Dimension (width, height));
		}

		public void paintComponent (Graphics g)
		{			
			Color green = new Color (0, 255, 0);
			g.setColor(green);
			g.fillRect(0, 0, 700, 700);
			
		}
    }

	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource().equals(menu.simMode))
         {
           	  selected = true;
           	  menu.setVisible(false);
           	  game.setVisible(true);
           	  setContentPane(game);
           	  game.resumeTimer();
         }   
		 
		 if (e.getSource().equals(menu.gameMode))
         {
           	  selected = true;
           	  menu.setVisible(false);
           	  game.setVisible(true);
           	  game.changeMode();
           	  setContentPane(game);
           	  game.resumeTimer();
         }   
		 
		 this.repaint();
	 }
	 
//    class Advance implements ActionListener {
//    	
//        Landscape landscape;
//        
//        public Advance(Landscape l) {
//        	this.landscape = l;
//        }
//        
//        public void actionPerformed(ActionEvent e) {     	
//        	landscape.advance();
//        	repaint();
//        }
//    }

    public static void main (String[] args) {
    	Display window = new Display(1200);
		window.setVisible(true);
		window.setResizable(false);
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