package nov30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SnowPanel extends JPanel implements Runnable {

	ImageIcon ic = new ImageIcon(this.getClass().getResource("snow.png"));
	Image image = ic.getImage();
	ArrayList<SnowObject> snowList;

	public SnowPanel(ArrayList<SnowObject> al) {
		// TODO Auto-generated constructor stub
		this.snowList = al;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(10);
				changeSnowPosition();
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}

	private void changeSnowPosition() {
		// TODO Auto-generated method stub
		for (Iterator iterator = snowList.iterator(); iterator.hasNext();) {
			SnowObject snowObject = (SnowObject) iterator.next();

			Point p = snowObject.getPoint();
			int xDir = Math.random() > 0.5 ? 1 : -1;
			int offsetX = (int) (Math.random() * 3) * xDir;
			int offsetY = (int) (Math.random() * 3);
			p.x += offsetX;
			if (p.x < 0)
				p.x = 0;
			p.y += offsetY;
			if (p.y > getHeight()) {
				p.x = (int) (Math.random() * getWidth());
				p.y = 5;
			}
			snowObject.setPoint(p);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		// g.drawImage(imageback, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.WHITE);

		for (Iterator iterator = snowList.iterator(); iterator.hasNext();) {
			SnowObject snowObject = (SnowObject) iterator.next();
			// g.fillOval(snowObject.getPoint().x, snowObject.getPoint().y,
			// snowObject.snow_size, snowObject.snow_size);
			g.drawImage(image, snowObject.getPoint().x, snowObject.getPoint().y, snowObject.snow_size,
					snowObject.snow_size, this);
		}
	}
}
