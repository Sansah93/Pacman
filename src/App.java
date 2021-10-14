import java.awt.Color;

import java.awt.Dimension;


import javax.swing.*;
public class App{
	
	public static void main(String args[]) {
		myKeyAdapter key = new myKeyAdapter();
		Dimension d= new Dimension(1125,1125);
		Pacman pacman = new Pacman();
		key.setPacman(pacman);
		pacman.setXY(100,100);
		//PacmanView view = new PacmanView(pacman);
		//view.setBackground(Color.black);
		JFrame frame = new JFrame("Pacman");
		
		//System.out.println(view.getSize());
		frame.addKeyListener(key);
		//frame.add(view);
		frame.setLocation(400,100);
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pacman);
		frame.setSize(d);
		frame.setVisible(true);
	}

}
