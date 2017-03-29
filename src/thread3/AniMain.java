package thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//개발자가 쓰레드를 상속하여 개발할 수 있으나, 이미 다른 클래스의 자식일 경우, 상속은 불가하다. 이럴때 사용할 수 있는 객체가 바로 Runnable 인터페이스이다.
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread; 
	
	public AniMain() {
		thread = new Thread(this);
		
		bt= new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		
		can= new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		can.setBackground(Color.YELLOW);
		
		
		bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
				
		add(can);
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}

	public void move(){
		x+=5;
		can.repaint();
	}
	
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			move(); //멤버를 접근할 수 있으니 그냥 move하면 됨
		}
		
	}
	
	
	public static void main(String[] args) {
		new AniMain();

	}

	

}
