	
	import javax.swing.*;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.*; 
	
	
	
	public class Pacman	extends JPanel{
		
		private int x ,y,velY,velX,score,cpt = 0,cpt2 = 0,rndm,rndm2,rndm3,rndm4;
		private final int vel=50;
		private  int map[][];
		private char moves,movesG1 = 'a',movesG2,movesG3,movesG4;
		private Color couleur = Color.YELLOW;
		private  int life;
		private boolean jauneP,orange;
		
		Ghost ghost1= new Ghost(true);
		Ghost ghost2= new Ghost(true);
		Ghost ghost3= new Ghost(true);
		Ghost ghost4= new Ghost(true);
		public void setXY(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
		public Pacman() {
		
		  //map=new int[12][12];            //cot� gauche
	       this.map= new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,2,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,4,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,2,0,0,1,1,1,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,1,0,0,0,0,0,0,1}, //en bas 
	    	   		/*en haut*/	 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,2,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,3,0,0,2,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,2,0,0,0,0,5,0,0,1},	
	    	   					 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
				};							//cot� droit
				
		ghost1.setPosX(200);
		ghost1.setPosY(200);
		rndmGhost(ghost1);

		ghost2.setPosX(300);
		ghost2.setPosY(300);
		rndmGhost2(ghost2);

		ghost3.setPosX(400);
		ghost3.setPosY(400);
		rndmGhost3(ghost3);

		ghost4.setPosX(500);
		ghost4.setPosY(500);
		rndmGhost4(ghost4);
		}
		
		
	
		@Override
		public void paint(Graphics g) {
			int width = 700;
			
			int height = 700;
			super.paint(g);
			System.out.println(movesG1);
			/*g.drawLine(width-5, 5, width-5, height-5);
			g.drawLine(5, 5, 5, height-5);
			g.drawLine(5,5,width-5,5);
			g.drawLine(5,height-5,width-5,height-5);*/
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					
					if(map[i][j] == 1) {
						g.drawRect((i+1)*vel, (j+1)*vel, vel, vel);
					}else if(map[i][j] == 2) {
						//System.out.println(i+" "+" "+j);
						//g.drawOval((i+1)*vel, (j+1)*vel, 15, 15);
						g.setColor(Color.BLUE);
						g.fillOval((i+1)*vel+20, (j+1)*vel+20, 15, 15);
						g.setColor(Color.BLACK);
						
					}else if(map[i][j] == 3){
						g.setColor(new Color(102,0,153));
						g.fillOval((i+1)*vel+20, (j+1)*vel+20, 15, 15);
						g.setColor(Color.BLACK);
						
					}else if(map[i][j] == 4){
						g.setColor(Color.ORANGE);
						g.fillOval((i+1)*vel+20, (j+1)*vel+20, 15, 15);
						g.setColor(Color.BLACK);
						
					}else if(map[i][j] == 5){
						g.setColor(Color.GREEN);
						g.fillOval((i+1)*vel+20, (j+1)*vel+20, 15, 15);
						g.setColor(Color.BLACK);
						
					}
				}
			}
			if(ghost1.isAlive()) {
				g.setColor(Color.cyan);
				g.fillRect(ghost1.getPosX(), ghost1.getPosY(), vel, vel);
			}
			if(ghost2.isAlive()) {
				g.setColor(Color.RED);
				g.fillRect(ghost2.getPosX(), ghost2.getPosY(), vel, vel);
			}
			if(ghost3.isAlive()) {
				g.setColor(Color.GRAY);
				g.fillRect(ghost3.getPosX(), ghost3.getPosY(), vel, vel);
			}
			if(ghost4.isAlive()) {
				g.setColor(Color.GREEN);
				g.fillRect(ghost4.getPosX(), ghost4.getPosY(), vel, vel);
			}
		  	g.setColor(couleur);
		  	
		  	//g.drawRect(x,y,50,50);
		  	System.out.println(x + " " + y+ " score : " + score);
		  	g.fillRect(x, y, 50, 50);
		  	
		  	
		}
		
		
		//methode pour le pacman.
		
		public void movePacman() {
			
			
				t.start();
				
		}
		
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			 /*y=y-50;
				repaint();		
				if(y<=50) {
					t.stop();
				}*/
				checkPacGommes();
				checkPacViolet();checkPacOrange();
				checkPacVert();
				if(!checkCollisions(x,y,moves)) {
				x=x+ velX;
				y= y+velY;
				repaint(); 
				}else {
					t.stop();
				}
			}
		};
		private Timer t = new Timer(250,action);	
	    
		
		public void move(char move) {
			switch(move) {
			case 'z' :velX=0;
					  velY=-vel;
					  moves='z';
					  movePacman();
			break;
			case 's' : velX=0;
					   velY=vel;
					   moves='s';
			movePacman();
			break;
			case 'q' : velX=-vel;
			           velY =0;
			           moves='q';
			movePacman();
			break;
			case 'd' :velX=vel;
					  velY=0;
					  moves='d';
					  movePacman();		  
			
			break;

			case 'p':velX=0;
					 velY=0;
					 t.stop();
					 
			
			}
		}
		public boolean checkCollisions(int x,int y, char moves) {
			//System.out.println(((x/vel)-1) + " " + ((y/vel)-1)+ " : " + map[(x/vel)-1][(y/vel)-1]);
			switch(moves) {
			case 'z':
				if(map[(x/vel)-1][(y/vel)-2] == 1){
					
					return true;
				}
				
				break;
			case 'q':
				if(map[(x/vel)-2][(y/vel)-1] == 1){
					
					return true;
				}
				
				break;
			case 's':
				if(map[(x/vel-1)][(y/vel-1+1)] == 1){
					
					return true;
				}
				
				break;
			case 'd':
				if(map[(x/vel)][(y/vel)-1] == 1){
					
					return true;
				}
				
				break;
			
			
			}
			return false;
		}
		
		
		public boolean checkPacGommes() {
			//System.out.println(((x/vel)-1) + " " + ((y/vel)-1)+ " : " + map[(x/vel)-1][(y/vel)-1]);
				if(map[(x/vel)-1][(y/vel)-1] == 2){
					map[(x/vel)-1][(y/vel)-1] = 0;
					score += 100;
					
					return true;
				}
			return false;
		}
		
		public boolean checkPacViolet() {
			
			//System.out.println(map[(x/vel)-1][(y/vel)-1] == 3);
				if(map[(x/vel)-1][(y/vel)-1] == 3){
					jauneP = true;
					map[(x/vel)-1][(y/vel)-1] = 0;
					score += 300;
					couleur = new Color(255,255,204);
					return true;
				}else if(jauneP) {
					cpt++;
				}if(cpt >= 15){
					couleur = Color.YELLOW;
					cpt = 0;
					jauneP = false;
				}
			return false;
		}
public boolean checkPacOrange() {
			
			//System.out.println(map[(x/vel)-1][(y/vel)-1] == 3);
				if(map[(x/vel)-1][(y/vel)-1] == 4){
					orange = true;
					map[(x/vel)-1][(y/vel)-1] = 0;
					score += 300;
					couleur = Color.ORANGE;
					return true;
				}else if(orange) {
					cpt2++;
				}if(cpt2 >= 15){
					couleur = Color.YELLOW;
					cpt2 = 0;
					orange = false;
				}
			return false;
		}
		
public boolean checkPacVert() {
	
	//System.out.println(map[(x/vel)-1][(y/vel)-1] == 3);
		if(map[(x/vel)-1][(y/vel)-1] == 5){
			score += 300;
this.map= new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					 {1,0,0,0,0,0,0,0,0,0,0,0,0,2,1},
					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					 {1,0,0,0,0,0,4,0,0,0,0,0,0,0,1},
					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					 {1,0,0,2,0,0,1,0,1,0,0,0,0,0,1},
					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1}, //en bas 
		/*en haut*/	 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					 {1,0,0,2,0,0,0,0,0,0,0,0,0,0,1},
					 {1,0,0,3,0,0,2,0,0,0,0,0,0,0,1},
					 {1,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
					 {1,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
					 {1,0,0,0,0,0,2,0,0,0,0,0,0,0,1},	
					 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			return true;
		}return false;
}

		
		
		
		
		//methodes pour les fantomes
		

		//il faut mettre le vel du ghost (ghost.getVel())
		public boolean checkCollG(int x,int y,char movesG) {
			switch(movesG) {
			case 'z':
				if(map[(x/vel)-1][(y/vel)-2] == 1){
					
					return true;
				}
				
				break;
			case 'q':
				if(map[(x/vel)-2][(y/vel)-1] == 1){
					
					return true;
				}
				
				break;
			case 's':
				if(map[(x/vel-1)][(y/vel-1+1)] == 1){
					
					return true;
				}
				
				break;
			case 'd':
				if(map[(x/vel)][(y/vel)-1] == 1){
					
					return true;
				}
				
				break;
			
			
			}
			return false;
		}
		
		
		ActionListener actionG = new ActionListener() {
			public void actionPerformed(ActionEvent event) {	
				if(!checkCollisions(ghost1.getPosX(),ghost1.getPosY(),movesG1)) {
				ghost1.setPosX(ghost1.getPosX()+ ghost1.getVelX());
				ghost1.setPosY(ghost1.getPosY()+ghost1.getVelY()); 
				
				if(rndm == 10) {
					rndmGhost(ghost1);
					rndm = 0;
				}
				rndm++;
				repaint(); 
				}else {
					rndmGhost(ghost1);
				}
				if(!checkCollisions(ghost2.getPosX(),ghost2.getPosY(),movesG2)) {
					ghost2.setPosX(ghost2.getPosX()+ ghost2.getVelX());
					ghost2.setPosY(ghost2.getPosY()+ghost2.getVelY()); 
					
					if(rndm2 == 10) {
						rndmGhost2(ghost2);
						rndm2 = 0;
					}
					rndm2++;
					repaint(); 
					}else {
						rndmGhost2(ghost2);
					}
				if(!checkCollisions(ghost3.getPosX(),ghost3.getPosY(),movesG3)) {
					ghost3.setPosX(ghost3.getPosX()+ ghost3.getVelX());
					ghost3.setPosY(ghost3.getPosY()+ghost3.getVelY()); 
					
					if(rndm3 == 10) {
						rndmGhost3(ghost3);
						rndm3 = 0;
					}
					rndm3++;
					repaint(); 
					}else {
						rndmGhost3(ghost3);
					}
				if(!checkCollisions(ghost4.getPosX(),ghost4.getPosY(),movesG4)) {
					ghost4.setPosX(ghost4.getPosX()+ ghost4.getVelX());
					ghost4.setPosY(ghost4.getPosY()+ghost4.getVelY()); 
					
					if(rndm4 == 10) {
						rndmGhost4(ghost4);
						rndm4 = 0;
					}
					rndm4++;
					repaint(); 
					}else {
						rndmGhost4(ghost4);
					}
			}
		};
		
		
		
		
		Timer tG = new Timer(ghost1.getVel()*5,actionG);
		
		public void moveG(char move,Ghost ghost) {
			switch(move) {
			case 'z' :ghost.setVelX(0);;
					  ghost.setVelY(-ghost.getVel());
					  
					  tG.start();
			break;
			case 's' : ghost.setVelX(0);
					   ghost.setVelY(ghost.getVel());
					  
			tG.start();
			break;
			case 'q' : ghost.setVelX(-ghost.getVel());
			           ghost.setVelY(0);
			           
			           tG.start();
			break;
			case 'd' :ghost.setVelX(ghost.getVel());
					  ghost.setVelY(0);
					  tG.start();		  
			
			break;				 
			
			}
		}
		
		public void rndmGhost(Ghost ghost) {
			int r = (int) (Math.random()*4);
			switch(r) {
			case  0 :moveG('z',ghost);movesG1 = 'z';break;

			case  1 :moveG('s',ghost);movesG1 = 's';break;
			case  2 :moveG('q',ghost);movesG1 = 'q';break;
			case  3 :moveG('d',ghost);movesG1 = 'd';break;
			
			}
			
		}
		public void rndmGhost2(Ghost ghost) {
			int r = (int) (Math.random()*4);
			switch(r) {
			case  0 :moveG('z',ghost);movesG2 = 'z';break;

			case  1 :moveG('s',ghost);movesG2 = 's';break;
			case  2 :moveG('q',ghost);movesG2 = 'q';break;
			case  3 :moveG('d',ghost);movesG2 = 'd';break;
			
			}
			
		}
		public void rndmGhost3(Ghost ghost) {
			int r = (int) (Math.random()*4);
			switch(r) {
			case  0 :moveG('z',ghost);movesG3 = 'z';break;

			case  1 :moveG('s',ghost);movesG3 = 's';break;
			case  2 :moveG('q',ghost);movesG3 = 'q';break;
			case  3 :moveG('d',ghost);movesG3 = 'd';break;
			
			}
			
		}
		public void rndmGhost4(Ghost ghost) {
			int r = (int) (Math.random()*4);
			switch(r) {
			case  0 :moveG('z',ghost);movesG4 = 'z';break;

			case  1 :moveG('s',ghost);movesG4 = 's';break;
			case  2 :moveG('q',ghost);movesG4 = 'q';break;
			case  3 :moveG('d',ghost);movesG4 = 'd';break;
			
			}
			
		}
		}
	
	
	
