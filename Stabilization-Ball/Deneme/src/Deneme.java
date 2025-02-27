import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Deneme extends JPanel implements KeyListener{
	
	private int x,y;
	private int xa=1,ya=1;
	private int x1,y1,xa2=1,ya2=1;
	private int rectx,recty,rectWidth=30,rectHeight=20;
	
	public Deneme(){
		super();
		setSize(new Dimension(600,400));
		setPreferredSize(new Dimension(600,400));
		setFocusable(true);
		addKeyListener(this);
		
		
		
	}
	
	public void moveBall() throws InterruptedException{
		
		//x=(int)(Math.random()*500+1);
		//y=(int)(Math.random()*500+1);
		
		if(x + xa < 0 )
			xa =1;
		
		if(x + xa > getWidth() - 35 )
			xa=-1;
		
		if(y + ya < 0 )
			ya = 1;
		if(y + ya > getHeight() - 35 )
			ya =-1;
		
		x = x + xa;
		y = y + ya+1;
		
	}
	
	public void moveBall2(){
		
		if(x1 + xa2 < 0 )
			xa2 =1;
		
		if(x1 + xa2 > getWidth() - 35 )
			xa2=-1;
		
		if(y1 + ya2 < 0 )
			ya2 = 1;
		if(y1 + ya2 > getHeight() - 35 )
			ya2 =-1;
		
		x1 = x1 + xa2;
		y1 = y1 + ya2;
		
		
	}
	

	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, 30, 30);
		
		g.setColor(Color.ORANGE);
		g.fillOval(x1, y1, 30, 30);
		
		//g.setColor(Color.RED);
		//g.fillRect(rectx, recty, rectWidth, rectHeight);
		
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException{

		JFrame frame = new JFrame();
		Deneme deneme = new Deneme();
		frame.setTitle("VeysBULUT");
		frame.setSize(new Dimension(600,400));
		frame.add(deneme);
		frame.setResizable(false);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program� biz kapatsak bile arka planda �al��maya devam edicek.
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		while(true){
			Thread.sleep(5);
			deneme.moveBall();
			deneme.moveBall2();
			
			deneme.repaint();
			
			
		}
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_A ){
			
			rectx=rectx-30;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			
			rectx=rectx+30;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W){
			
			recty=recty-30;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			
			recty=recty+30;
		}
		
		repaint();
		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
