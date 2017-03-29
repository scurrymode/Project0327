/*
 * Ŭ������ �ڵ��� ���붧���� ���� ����̴�!
 * */

package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;
	ArrayList<JButton> bts=new ArrayList<JButton>();
	

	public FileWindow() {
		setLayout(new FlowLayout());
		
		folder_on= new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
		
		ArrayList<String> list=getDirList();
		
		for (int i=0; i<list.size();i++){
			String dirName=list.get(i);
			MyPanel mp=new MyPanel(dirName, folder_off, folder_on, bts);
			add(mp);
		}
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//���ϴ� ����� ���� ���丮/���� ���ϱ�
	public ArrayList<String> getDirList(){
		File file = new File("c:/");
		
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
		
		//���丮�� �����!
		for (int i=0; i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//���丮�� �߰ߵɶ����� ����Ʈ�� �߰�
				dirList.add(fileList[i].getName());
			}
		}
		return dirList;
	}
	
	

	public static void main(String[] args) {
		new FileWindow();

	}

}
