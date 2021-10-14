import java.awt.event.*;

public class myKeyAdapter extends KeyAdapter {
		private Pacman game;
		public void setPacman(Pacman game) {
			this.game=game;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyChar()) {
			case 'z': game.move('z');
			break;	
			case 's':game.move('s');
			break;
			case 'q':game.move('q');
			break;
			case 'd':game.move('d');
				
				break ;
				
			default:
				game.move('p');
				System.out.println("mauvaise touche");
			}
		}
}
