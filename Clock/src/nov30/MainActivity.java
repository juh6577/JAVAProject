package nov30;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainActivity extends JFrame {

	Container ct;

	JPanel analogClockPanel, deptLogoPanel, lecturePanel, datePanel, timePanel, dayPanel;
	int analogClockWidth = 900, analogClockHeight = 900;
	int dateClockWidth = 620, dateClockHeight = 50;
	int timeClockWidth = 620, timeClockHeight = 74;
	int dayClockWidth = 620, dayClockHeight = 50;
	int lectureWidth = 620, lectureHeight = 350;
	int deptLogoWidth = 620, deptLogoHeight = 336;
	int width = 1920, height = 1080;
	Thread analogClockThread, deptLogoThread, lectureThread, dateThread, timeThread, dayThread;

	Font Datefont = new Font("±¼¸²", Font.BOLD, 30);
	Font Timefont = new Font("±¼¸²", Font.BOLD, 50);
	Font Dayfont = new Font("±¼¸²", Font.BOLD, 30);
	Font LectureLabelfont = new Font("±¼¸²", Font.BOLD, 50);
	Font LecturePanelfont = new Font("±¼¸²", Font.BOLD, 30);
	Font Buttonfont = new Font("±¼¸²", Font.BOLD,40);

	final int SNOWS = 100;
	final int SNOW_SIZE = 50;
	ArrayList<SnowObject> snowList = new ArrayList<SnowObject>();
	SnowPanel sp;

	public MainActivity() {
		this.setTitle("ÆÀº° ÇÁ·ÎÁ§Æ®");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ct = this.getContentPane();
		ct.setLayout(null);
		ct.setBackground(Color.BLACK);

		generateSnow();

		analogClockPanel = new JPanel();
		AnalogClockPanel acp = new AnalogClockPanel(analogClockPanel);
		acp.setBounds(150, 90, analogClockWidth, analogClockHeight);
		acp.setOpaque(false);
		analogClockThread = new Thread(acp);
		analogClockThread.start();

		datePanel = new JPanel();
		DatePanel dtp = new DatePanel(datePanel);
		dtp.setBounds(1150, 90, dateClockWidth, dateClockHeight);
		dtp.setFont(Datefont);
		dtp.setOpaque(false);
		dateThread = new Thread(dtp);
		dateThread.start();

		timePanel = new JPanel();
		TimePanel tp = new TimePanel(timePanel);
		tp.setBounds(1150, 140, timeClockWidth, timeClockHeight);
		tp.setFont(Timefont);
		tp.setOpaque(false);
		timeThread = new Thread(tp);
		timeThread.start();

		dayPanel = new JPanel();
		DayPanel dp = new DayPanel(dayPanel);
		dp.setBounds(1150, 214, dayClockWidth, dayClockHeight);
		dp.setFont(Dayfont);
		dp.setOpaque(false);
		dayThread = new Thread(dp);
		dayThread.start();

		lecturePanel = new JPanel();
		LectureGuidePanel lgp = new LectureGuidePanel(lecturePanel);
		lgp.setBounds(1150, 300, lectureWidth, lectureHeight);
		lgp.setFont(LecturePanelfont);
		lgp.setOpaque(false);
		lectureThread = new Thread(lgp);
		lectureThread.start();

		JLabel lectureLabel = new JLabel("°­ÀÇ ¾È³»");
		lectureLabel.setBounds(0, 0, 620, 70);
		lectureLabel.setForeground(Color.WHITE);
		lectureLabel.setFont(LectureLabelfont);
		lgp.add(lectureLabel);

		deptLogoPanel = new JPanel();
		DeptLogoPanel dlp = new DeptLogoPanel(deptLogoPanel);
		dlp.setBounds(1150, 654, deptLogoWidth, deptLogoHeight);
		dlp.setOpaque(false);
		deptLogoThread = new Thread(dlp);
		deptLogoThread.start();

		sp = new SnowPanel(snowList);
		sp.setOpaque(false);
		Thread spTh = new Thread(sp);

		JLabel snowLabel = new JLabel("´« ³»¸®±â");
		snowLabel.setForeground(Color.LIGHT_GRAY);
		snowLabel.setFont(Buttonfont);
		snowLabel.setBounds(900, 990, 200, 50);
		snowLabel.addMouseListener(new MouseListener() {

			int cnt = 0;

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

				if (cnt == 0) {
					snowLabel.setText("´« ¸ØÃß±â");
					sp.setBounds(0, 0, 1920, 1080);
					spTh.start();
					cnt++;
				} else {
					snowLabel.setText("´« ³»¸®±â");
					spTh.interrupt();
					cnt = 0;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		ct.add(snowLabel);
		ct.add(sp);
		ct.add(acp);
		ct.add(dtp);
		ct.add(tp);
		ct.add(dp);
		ct.add(lgp);
		ct.add(dlp);

		this.setVisible(true);
		Insets inset = this.getInsets();
		this.setSize(width + inset.left + inset.right, height + inset.top + inset.bottom);
	}

	private void generateSnow() {
		// TODO Auto-generated method stub
		for (int i = 0; i < SNOWS; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);

			Point point = new Point(x, y);
			SnowObject so = new SnowObject(point, SNOW_SIZE);
			snowList.add(so);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainActivity();
	}

}
