/*
 * OS의 멀티태스킹처럼 자바도 세부실행단위를 설정해서 하나의 프로그램 안에서 할 수 있다!
 * 세부실행단위: 쓰레드
 * 자바는 개발자가 정의하지 않아도 메인 쓰레드를 제공한다.
 * 
 * */


package thread;

public class ThreadTest {
	//메인쓰레드 말고, 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서 원하는
	//동시 작업을 시켜보자!
	MyThread thread;
	
	public ThreadTest() {
		//메인쓰레드와는 독립적으로 실행될 수 있는 세부실행단위를 생성
		thread = new MyThread();
		thread.start();
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("☆");
		}
	}
	
	public static void main(String[] args) {
			
		new ThreadTest(); 
	}

}
