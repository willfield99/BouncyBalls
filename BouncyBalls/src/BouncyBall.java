import java.awt.Color;
import java.awt.Graphics;

public class BouncyBall implements Runnable{
	private int x;
	private int y;
	private int x_speed;
	private int y_speed;
	private BouncyBallsPanel panel;
	
	public BouncyBall(int x, int y, int x_speed, int y_speed, BouncyBallsPanel panel) {//bouncyball constructor
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.x_speed = x_speed;
		this.y_speed = y_speed;
	}
	
	public void Collision() {//makes it so that the ball bounces off of the edge of the window
		if (x < 0 || x > (panel.getWidth() - 10)) {
			x_speed = -x_speed;
		}
		
		if (y < 0 || y > (panel.getHeight() - 10)) {
			y_speed = -y_speed;
		}
		
	}
	
	public void run() {// runs the thread
	try {
		while(true) {
			Collision();
			x = x + x_speed;
			y = y + y_speed;
			panel.repaint();
			Thread.sleep(10);//speeds are updated every 10 milliseconds
		
		}
	} catch(InterruptedException caught) {
		System.out.println("Interrupted");
	}
	
}

	public void draw(Graphics g) {//draws the bouncy ball
		g.setColor(Color.black);
		g.fillOval(x, y, 10, 10);
	}
}