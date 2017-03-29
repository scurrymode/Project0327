//���� ǥ���� ��ü �� �� ������
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{
	
	
	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);
		
	}
	
	public void render(){
		//�����
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
				
		//�׸���
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);

	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			render();
		}
		
		
	}
	
}
