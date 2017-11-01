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
		this.setTitle("예제 11-7");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		name = new JLabel("이름 : ");
		major = new JLabel("학과 : ");
		adr = new JLabel("주소 : ");
		
		// 입력 창 크기가 10인 텍스트필드
		jtf1 = new JTextField(10);
		// "정보통신공학과"로 초깃값을 가지는 텍스트필드
		jtf2 = new JTextField("정보통신공학과");
		// 입력 창 크기가 20이고 "광주광역시..."로 초기화된 텍스트필드
		jtf3 = new JTextField("광주광역시...", 20);
		
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



