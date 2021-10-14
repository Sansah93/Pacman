	
	import javax.swing.*;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.*; 
	
	
	public class Pacman	extends JPanel{
		
		private int x ,y,velY,velX,score = 0;
		private final int vel=50;
		private  int map[][];
		private char moves;
		
		public void setXY(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
		public Pacman() {
		
		  //map=new int[12][12];
	       this.map= new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,2,0,0,0,1,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,2,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	    	   					 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},	
	    	   					 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
				};}
		
		
	
		@Override
		public void paint(Graphics g) {
			int width = 700;
			int height = 700;
			super.paint(g);
			/*g.drawLine(width-5, 5, width-5, height-5);
			g.drawLine(5, 5, 5, height-5);
			g.drawLine(5,5,width-5,5);
			g.drawLine(5,height-5,width-5,height-5);*/
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					
					if(map[i][j] == 1) {
						g.drawRect((i+1)*vel, (j+1)*vel, vel, vel);
					}else if(map[i][j] == 2) {
						//g.drawOval((i+1)*vel, (j+1)*vel, 15, 15);
						g.setColor(Color.BLUE);
						g.fillOval((i+1)*vel+20, (j+1)*vel+20, 15, 15);
						g.setColor(Color.BLACK);
					}
				}
			}
			
		
		  	g.setColor(Color.YELLOW);
		  	
		  	//g.drawRect(x,y,50,50);
		  	System.out.println(x + " " + y+ " score : " + score);
		  	g.fillRect(x, y, 50, 50);
		  	
		}
		
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
				if(!checkCollisions()) {
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
		public boolean checkCollisions() {
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
	
		
	}
	
	
