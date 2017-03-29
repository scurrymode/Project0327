/*
 *원이던, 사각형이던, 어떤 도형을 표현하는 객체이던 모두 이 클래스의 자식으로 두자!!
 *왜? 공통적 특징이 있으므로!!
 *
 * */

package homework;


import java.awt.Graphics;

public abstract class ShapeThread extends Thread{
	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		start();
	}
	
	public abstract void render();
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			render();
		}
		
		
	}
	
	
}
