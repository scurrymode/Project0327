/*
 * OS�� ��Ƽ�½�ŷó�� �ڹٵ� ���ν�������� �����ؼ� �ϳ��� ���α׷� �ȿ��� �� �� �ִ�!
 * ���ν������: ������
 * �ڹٴ� �����ڰ� �������� �ʾƵ� ���� �����带 �����Ѵ�.
 * 
 * */


package thread;

public class ThreadTest {
	//���ξ����� ����, �����ڰ� ���ϴ� ����� ���� ������ �ϳ� ���� ���ϴ�
	//���� �۾��� ���Ѻ���!
	MyThread thread;
	
	public ThreadTest() {
		//���ξ�����ʹ� ���������� ����� �� �ִ� ���ν�������� ����
		thread = new MyThread();
		thread.start();
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("��");
		}
	}
	
	public static void main(String[] args) {
			
		new ThreadTest(); 
	}

}
