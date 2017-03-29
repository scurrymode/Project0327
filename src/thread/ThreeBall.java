package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeBall extends JFrame{
	JButton bt;
	Canvas can;
	int x;
	
	
	
	public ThreeBall() {
		bt=new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, 0, 50, 50);
				g.drawOval(x, 150, 80, 80);
				g.drawOval(x, 300, 100, 100);
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BallTread thread1 = new BallTread(ThreeBall.this, 100, 50);
				BallTread thread2 = new BallTread(ThreeBall.this, 500, 20);
				BallTread thread3 = new BallTread(ThreeBall.this, 1000, 10);
				
				thread1.start();
				thread2.start();
				thread3.start();
			}
		});
		
		setBounds(100, 100, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void move(int speed){
		x+=speed;
		can.repaint();
		
	}

	public static void main(String[] args) {
		new ThreeBall();

	}

}
