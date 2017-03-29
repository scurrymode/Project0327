package count;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountMain extends JFrame{
	JLabel la_left, la_right;
	JPanel p;
	
	
	public CountMain() {
		
		p= new JPanel();
		la_left=new JLabel();
		la_right=new JLabel();
		
		p.setBackground(Color.YELLOW);
		
		CountThread thread_left=new CountThread(100, la_left);
		CountThread thread_right=new CountThread(500, la_right);
		
		
		p.add(la_left);
		p.add(la_right);
		
		add(p);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	

	public static void main(String[] args) {
		new CountMain();
		

	}

}
