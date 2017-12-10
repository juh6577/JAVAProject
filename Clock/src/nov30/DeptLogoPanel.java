package nov30;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DeptLogoPanel extends JPanel implements Runnable {

	int logoWidth, logoHeight, second;
	ImageIcon imageicon = new ImageIcon(this.getClass().getResource("whitelogo.png"));
	Image image = imageicon.getImage();

	public DeptLogoPanel(JPanel deptLogoPanel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, logoWidth, logoHeight, this);
	}

	@Override
	public void run() {
		while (true) {
			try {
				second = Calendar.getInstance().get(Calendar.SECOND);
				iconSize(second);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void iconSize(int s) {
		logoWidth = (s * 10);
		logoHeight = (s * 10) / 2;
		return;
	}

	private void drawLogo(Graphics2D g2d) {

	}

	private void drawLayout(Graphics2D g2d) {

	}
}
