import java.awt.*;
import javax.swing.JPanel;

public class Ghost {
	private boolean alive;
	private int vel=50;
	private int couleur,posX,posY,velX=50,velY=50;
	 private char moves;
	
	public char getMoves() {
		return moves;
	}

	public void setMoves(char moves) {
		this.moves = moves;
	}

	public Ghost(boolean alive) {
		
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	

}
