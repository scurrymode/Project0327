package file;

import java.io.File;

public class FileTest {
	

	public static void main(String[] args) {
		// C����̺��� ������ �����ϴ� ��� ���丮 �� ������ ����غ���!
		
		File file=new File("c:/");
		
		//���� ���丮 �� ������ ��� ����
		File[] dir=file.listFiles();
				
		for(int i=0; i<dir.length;i++){
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());
				
			}
		}
		
		

	}

}
