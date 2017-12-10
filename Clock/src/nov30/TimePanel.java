package nov30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JPanel;

public class TimePanel extends JPanel implements Runnable {

	String type, result;
	SimpleDateFormat sdf = new SimpleDateFormat("KK:mm:ss aa", Locale.US);

	public TimePanel(JPanel timePanel) {

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.drawString(result, 135, 60);
	}

	private void drawLayout(Graphics2D g2d) {

	}

	@Override
	public void run() {
		while (true) {
			try {
				Date dt = new Date();
				result = sdf.format(dt);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
