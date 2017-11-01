package oct30;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class JTextAreaEx extends JFrame {

	Container ct;
	JPanel panel;
	JLabel label;
	JTextArea ta;
	JScrollPane scroll;
	JSlider slider;
	int x;

	public JTextAreaEx() {
		
		this.setTitle("실습문제08");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		ct = this.getContentPane();

		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		label = new JLabel();

		ta = new JTextArea(15, 15);

		scroll = new JScrollPane();
		// 0~100 사이의 값을 선택할 수 있는 슬라이더 생성. 초기값은 0
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		// 수치가 보이도록 설정
		slider.setPaintLabels(true);
		// 눈금이 보이도록 설정
		slider.setPaintTicks(true);
		// 트랙이 이 보이도록 설정
		slider.setPaintTrack(true);
		// 큰 눈금 간격을 20픽셀로 설정
		slider.setMajorTickSpacing(20);
		// 작은 눈금 간격을 1픽셀로 설정
		slider.setMinorTickSpacing(1);
		// 반응없도록 설정
		slider.setEnabled(false);

		ta.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {

				String s = ta.getText();
				x = s.length() + 1;
				slider.setValue(x);

				if (x > 100) {
					ta.setEnabled(false);
					System.out.println("글자 수가 100을 초과");
				}
			}
		});

		panel.add(scroll);
		panel.add(new JScrollPane(ta));
		panel.add(slider, BorderLayout.SOUTH);
		ct.add(panel);

		this.setSize(500, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JTextAreaEx();
	}
}
