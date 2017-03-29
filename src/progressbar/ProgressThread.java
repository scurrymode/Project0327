package progressbar;

import javax.swing.JProgressBar;

public class ProgressThread extends Thread{
	JProgressBar bar;
	int interval;
	int count;
	
	public ProgressThread(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval= interval;
		start();
	}
	
	public void run() {
		while(count<100){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
	}

}
