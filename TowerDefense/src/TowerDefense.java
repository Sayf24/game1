import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;
public class TowerDefense extends JPanel implements ActionListener, KeyListener{
	Timer t = new Timer(1, this);
	ArrayList<Rectangle> blockList = new ArrayList<Rectangle>();
	int x = 0;
	int y = 0;
	//horizontal velocity
	double hv = 0;
	//vertical velocity
	double vv = 0;
	Rectangle g2;
	Rectangle g1;
	Rectangle g3;
	boolean start = true;
	boolean win =false;
	public TowerDefense(){
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	public void paintComponent(Graphics g){
		if(start){
			createBlocks();
		}
		start=false;
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if(win){
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
			g2d.drawString("You Win", x, y);
		}
		g2d.setColor(Color.red);
		g2= new Rectangle(x,y,60,60);
		g2d.fill(g2);
		g2d.setColor(Color.BLACK);
		for(int i = 0;i<50;i++){
			//System.out.println((int)blockList.get(i).getCordx());
			g1 = new Rectangle(blockList.get(i).getBounds());
			g2d.fill(g1);

		}
		g3 = new Rectangle(1700,600,60,60);
		g2d.setColor(Color.CYAN);
		g2d.fill(g3);
	}
	public void actionPerformed(ActionEvent e){
		repaint();
		x+=hv;
		y+=vv;
		for(int u = 0;u<blockList.size();u++){
			if(g2.intersects(blockList.get(u))&&hv>0){
				hv=0;
				vv=0;
				x=0;
				y=0;
			}else if(g2.intersects(blockList.get(u))&&hv<0){
				hv=0;
				vv=0;
				x=0;
				y=0;
			}
			if(g2.intersects(blockList.get(u))&&vv>0){
				hv=0;
				vv=0;
				x=0;
				y=0;
			}
			else if((g2.intersects(blockList.get(u))&&vv<0)){
				hv=0;
				vv=0;
				x=0;
				y=0;
			}
			if(g2.intersects(g3)){
				win=true;
			}

		}
		if(x>1820){
			x=1820;
		}
		if(x<50){
			x=50;
		}
		if(y<30){
			y=30;
		}
		if(y>950){
			y=950;
		}
	}
	public void up(){
		vv=-1;
		hv=0;
	}
	public void down(){
		vv=1;
		hv=0;
	}
	public void left(){
		hv=-1;
		vv=0;
	}
	public void right(){
		hv=1;
		vv=0;
	}
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){
			up();
		}else if(code == KeyEvent.VK_DOWN){
			down();
		}else if(code == KeyEvent.VK_LEFT){
			left();
		}else if(code == KeyEvent.VK_RIGHT){
			right();
		}
		
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public  void createBlocks(){
		for(int i = 0;i<50;i++){
			Random rand = new Random();
			int  o = rand.nextInt(1820) + 100;
			int  p = rand.nextInt(950) + 30;
			block cur  =new block(o,p,60,60);
			blockList.add(cur.getBounds());
			
		}
	}

}
