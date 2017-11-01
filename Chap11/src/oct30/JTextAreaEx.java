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
		
		this.setTitle("�ǽ�����08");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		ct = this.getContentPane();

		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		label = new JLabel();

		ta = new JTextArea(15, 15);

		scroll = new JScrollPane();
		// 0~100 ������ ���� ������ �� �ִ� �����̴� ����. �ʱⰪ�� 0
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		// ��ġ�� ���̵��� ����
		slider.setPaintLabels(true);
		// ������ ���̵��� ����
		slider.setPaintTicks(true);
		// Ʈ���� �� ���̵��� ����
		slider.setPaintTrack(true);
		// ū ���� ������ 20�ȼ��� ����
		slider.setMajorTickSpacing(20);
		// ���� ���� ������ 1�ȼ��� ����
		slider.setMinorTickSpacing(1);
		// ���������� ����
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
					System.out.println("���� ���� 100�� �ʰ�");
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
