import javax.swing.*;
public class App{
	
	public static void main(String args[]) {
		Pacman pacman = new Pacman();
		PacmanView view = new PacmanView(pacman);
		JFrame frame = new JFrame("Pacman");
		frame.add(view);
		frame.setSize(view.getSize());
		frame.setLocation(400,100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}

}
