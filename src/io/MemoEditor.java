package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JButton b_open, b_save;
	ImageIcon icon;
	JPanel p_north;
	JScrollPane scroll;
	JTextArea area;
	
	String ori="C:/java_workspace2/Project0327/res/memo.txt"; //원본
	String dest="C:/java_workspace2/Project0327/res/memo_copy.txt"; //다른 파일의 저장경로
	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader; //문자기반 입력스트림
	BufferedReader buffr; //버퍼처리된 문자기반 입력스트림
	
	//OutputStreamWriter writer;//문자기반 출력스트림 이건 저장하니깐 문자가 깨지더라!
	PrintWriter writer2; //이것도 문자기반 출력 스트림
	
	public MemoEditor() {
		icon= new ImageIcon("C:/java_workspace2/Project0327/res/folder_off.png");
		b_open=new JButton(icon);
		b_open.setBorderPainted(false);
		b_open.setContentAreaFilled(false);
		b_open.setFocusPainted(false);
		b_open.setOpaque(false);
		
		
		b_save=new JButton("저장");
		p_north=new JPanel();
		area =new JTextArea(20,20);
		scroll=new JScrollPane(area);
		
		p_north.add(b_open);
		p_north.add(b_save);
		add(p_north, BorderLayout.NORTH);
		
		add(scroll);
		
		b_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
				
			}
		});
		
		b_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void open(){
		
		try {
			fis=new FileInputStream(ori);
			reader= new InputStreamReader(fis, "utf-8");
			buffr= new BufferedReader(reader);
			
			//int data;
			String data;
			int count =0;
			while(true){
				//data=fis.read();//1byte 읽어들인다!
				//data=reader.read(); //2byte씩 읽어들인다!
				data=buffr.readLine(); //한줄씩 읽어들인다!
				count++;				
				//if(data==-1)break;
				if(data==null)break;
				//area.append(Character.toString((char)data));
				area.append(data+"\n");
			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");
			e.printStackTrace(); //개발자를 위한 로그 정보
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void save(){
		try {
			fos=new FileOutputStream(dest);
			//fos는 그냥 바로 경로에 빈 파일을 생성시킨다.
			//writer=new OutputStreamWriter(fos, "utf-8");
			writer2= new PrintWriter(fos);
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "경로를 찾을 수 없습니다.");
			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			JOptionPane.showMessageDialog(this, "존재하지 않는 형식입니다.");
//			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "저장 할 수 없습니다.");
			e.printStackTrace();
		} finally{
			if(writer2 !=null){
				writer2.close();
//				try {
//					writer.close();//둘중에 하나만 닫으면 된다. 안정적으로 개발하려면 명시적으로 하나씩 닫아줘라!
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			if(fos !=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new MemoEditor();
		

	}

}
