package count;

import javax.swing.JLabel;

public class CountThread extends Thread{
	int interval;
	JLabel label;
	int x;
	
	public CountThread(int interval, JLabel label) {
		this.interval=interval;
		this.label=label;
		start();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x++;
			String t=Integer.toString(x);
			label.setText(t);
		}
	}

}
