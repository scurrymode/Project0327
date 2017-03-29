package homework;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{

	public RectThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);

	}

	
	public void render() {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
		
		g.setColor(Color.RED);
		x+=20;
		g.drawRect(0, 200, 50, 50);
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
