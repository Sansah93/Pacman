import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class PacmanView extends JComponent {
	

	

		public final static int WIDTH = 700;
		public final static int HEIGHT = 700;

		private final Pacman game;
		
		private static final long serialVersionUID = 1L;

		public PacmanView(Pacman game) {
			super();
			this.game = game;
			// addMouseListener(new TicTacToeMouseListener(this));
			setOpaque(true);
			setSize(WIDTH, HEIGHT);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			setBackground(Color.WHITE);
			int width = getSize().width;
			int height = getSize().height;
			g.setColor(Color.BLACK);
			drawLines(g, width, height);
			drawMoves(g);
		}

		private void drawLines(Graphics g, int width, int height) {
			g.drawLine(width-5, 5, width-5, height-5);
			g.drawLine(5, 5, 5, height-5);
			g.drawLine(5,5,width-5,5);
			g.drawLine(5,height-5,width-5,height-5);
		}

		private void drawMove(Graphics g, int posX, int posY) {
			int x = getSize().width * posX / 3;
			int xWidth = getSize().width / 3;
			int y = getSize().height * posY / 3;
			int yWidth = getSize().height / 3;
			g.fillRect(x, y, xWidth, yWidth);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, xWidth, yWidth);
		}

		private void drawMoves(Graphics g) {
			// TODO
		}

	}

