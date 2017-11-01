package oct30;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTextFieldEx extends JFrame {
	
	Container ct;
	JLabel name, major, adr;
	JTextField jtf1, jtf2, jtf3;
	
	public JTextFieldEx() {
		this.setTitle("���� 11-7");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		name = new JLabel("�̸� : ");
		major = new JLabel("�а� : ");
		adr = new JLabel("�ּ� : ");
		
		// �Է� â ũ�Ⱑ 10�� �ؽ�Ʈ�ʵ�
		jtf1 = new JTextField(10);
		// "������Ű��а�"�� �ʱ갪�� ������ �ؽ�Ʈ�ʵ�
		jtf2 = new JTextField("������Ű��а�");
		// �Է� â ũ�Ⱑ 20�̰� "���ֱ�����..."�� �ʱ�ȭ�� �ؽ�Ʈ�ʵ�
		jtf3 = new JTextField("���ֱ�����...", 20);
		
		ct.add(name);
		ct.add(jtf1);
		ct.add(major);
		ct.add(jtf2);
		ct.add(adr);
		ct.add(jtf3);
		
		this.setSize(340,200);		
		this.setVisible(true);
	}
	
	public static void main(String [] args) {
		new JTextFieldEx();
	}
} 



