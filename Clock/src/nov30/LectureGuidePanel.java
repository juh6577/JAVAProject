package nov30;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.DayOfWeek;
import java.util.Calendar;

import javax.security.auth.Subject;
import javax.swing.JPanel;

public class LectureGuidePanel extends JPanel implements Runnable {

	int currentHour, currentMin, lectSx, lectSy, gap, timeSlotNumber;
	DayOfWeek currentDay;
	Font titleFont, sbFont;
	String result;

	public LectureGuidePanel(JPanel lecturePanel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		g.setColor(Color.WHITE);

		currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		currentMin = Calendar.getInstance().get(Calendar.MINUTE);
		int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		timeSlotNumber = (((currentHour - 9) * 60) + currentMin) / 30;

		if (day >= 2 && day <= 6 && timeSlotNumber >= 0 && timeSlotNumber <= 20) {
			for (int i = 0; i < 4; i++) {
				int j = ((day - 2) * 21) + timeSlotNumber;
				String[] sb = TimeTable.sb[i][j];
				result = ((i + 1) + "학년 : " + sb[0] + "    " + sb[1] + "  " + sb[2]);
				if (i == 0) {
					g.drawString(result, 10, 145);
				} else {
					g.drawString(result, 10, ((i + 1) * 55) + 90);
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int j = ((day - 2) * 21) + timeSlotNumber;
				result = ((i + 1) + "학년 : 집으로 귀가");
				if (i == 0) {
					g.drawString(result, 10, 145);
				} else {
					g.drawString(result, 10, ((i + 1) * 55) + 90);
				}
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int decideTimeSlot(int a, int b) {
		return b;
	}

	public Subject findMatchingLecture(int i, int j, String k) {
		return null;
	}

	private void drawLayout(Graphics2D g2d) {
		
	}
}
