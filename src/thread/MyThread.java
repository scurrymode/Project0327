package thread;

public class MyThread extends Thread{
	//개발자는 독립적으로 수행하고 싶은 코드를 쓰레드의 run 메서드 안에 작성하면 된다.
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//1초 쉬다와!!
			System.out.println("★");
		}
	}

}
