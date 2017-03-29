package thread;

public class MoveThread extends Thread{
	//움직임 로직을 담게 될 쓰레드
	AniMain aniMain;
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain;
	}
	
	@Override
	public void run() {
		//개발자는 독립실행할 코드를 run에 기재한다! 그러면 JVM이 이 run을 알아서 호출해준다!
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aniMain.move();
		}
	}
	
	

}
