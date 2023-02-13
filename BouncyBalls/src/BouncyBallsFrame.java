import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BouncyBallsFrame extends JFrame{


	public BouncyBallsFrame(int x, int y, int width, int height) {
		BouncyBallsPanel panel;
		
		setSize(width, height);
		setLocation(x, y);
		setTitle("Bouncy Balls");
		
		panel = new BouncyBallsPanel();
		add(panel, BorderLayout.CENTER);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)	;
		setVisible(true);
		panel.makeBalls();
}

}
