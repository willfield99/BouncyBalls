import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JPanel;

public class BouncyBallsPanel extends JPanel {

	private Set<BouncyBall> balls;
	private Random oracle;

	public void makeBalls() {//makes 10 dif balls with random speeds/ positions
		Thread thread;
		BouncyBall ball;
		int x;
		int y;
		int x_speed;
		int y_speed;

		for (int i = 0; i < 10; i++) {
			x = oracle.nextInt(getWidth() - 10);
			y = oracle.nextInt(getHeight() - 10);
			x_speed = oracle.nextInt(10) + 1;
			y_speed = oracle.nextInt(10) + 1;
			ball = new BouncyBall(x, y, x_speed, y_speed, this);
			balls.add(ball);
			thread = new Thread(ball);
			thread.start();
		}
	}

	public BouncyBallsPanel() {//constructor

		this.oracle = new Random();
		this.balls = new HashSet<BouncyBall>();

	}

	public void paintComponent(Graphics g) {//paintcompononent- draws the balls
		super.paintComponent(g);

		for (BouncyBall ball : balls) {
			ball.draw(g);
		}
	}
	
	
	}

