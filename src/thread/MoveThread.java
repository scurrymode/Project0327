package thread;

public class MoveThread extends Thread{
	//������ ������ ��� �� ������
	AniMain aniMain;
	
	public MoveThread(AniMain aniMain) {
		this.aniMain=aniMain;
	}
	
	@Override
	public void run() {
		//�����ڴ� ���������� �ڵ带 run�� �����Ѵ�! �׷��� JVM�� �� run�� �˾Ƽ� ȣ�����ش�!
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
