package filehomework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileThread extends Thread{
	FileProgressBar fpb;
	int count, progress;
	
	public FileThread(FileProgressBar fileProgressBar) {
		this.fpb=fileProgressBar;
	}
	
	public void run() {
		try {
			fpb.fis=new FileInputStream(fpb.oriPath);
			fpb.fos=new FileOutputStream(fpb.destPath);
			int data=0;
			
			Thread.sleep(10);
			while(true){
				data=fpb.fis.read();
				if(data==-1)break;
				fpb.fos.write(data);
				
				count++;
				setBar();
				
				
				
				System.out.println("카운트"+count);
				
			}
			JOptionPane.showMessageDialog(fpb, "복사완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fpb.fis!=null) fpb.fis.close();
				if(fpb.fos!=null) fpb.fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setBar(){
		
		long total=fpb.oriPath.length();
		progress=((count/(int)total)*100);
		fpb.bar.setValue(progress);
		System.out.println("토탈"+total);
		System.out.println("프로그레스"+progress);
	}

}
