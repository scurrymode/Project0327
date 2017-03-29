package thread2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//쓰레드를 내부 익명 스타일로 가자!
public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x, y;
	Thread thread; 
	
	public AniMain() {
		thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					move(); //멤버를 접근할 수 있으니 그냥 move하면 됨
				}
			}
		};
		
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
	
	
	
	public static void main(String[] args) {
		new AniMain();

	}

}
