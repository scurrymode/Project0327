package thread;

public class BallTread extends Thread{
	ThreeBall threeBall;
	int second;
	int speed;

	
	
	
	public BallTread(ThreeBall threeBall, int second, int speed) {
		this.threeBall=threeBall;
		this.second=second;
		this.speed=speed;

	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(second);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threeBall.move(speed);
		}
	}
	

}
