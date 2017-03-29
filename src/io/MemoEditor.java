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
	
	String ori="C:/java_workspace2/Project0327/res/memo.txt"; //����
	String dest="C:/java_workspace2/Project0327/res/memo_copy.txt"; //�ٸ� ������ ������
	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader; //���ڱ�� �Է½�Ʈ��
	BufferedReader buffr; //����ó���� ���ڱ�� �Է½�Ʈ��
	
	//OutputStreamWriter writer;//���ڱ�� ��½�Ʈ�� �̰� �����ϴϱ� ���ڰ� ��������!
	PrintWriter writer2; //�̰͵� ���ڱ�� ��� ��Ʈ��
	
	public MemoEditor() {
		icon= new ImageIcon("C:/java_workspace2/Project0327/res/folder_off.png");
		b_open=new JButton(icon);
		b_open.setBorderPainted(false);
		b_open.setContentAreaFilled(false);
		b_open.setFocusPainted(false);
		b_open.setOpaque(false);
		
		
		b_save=new JButton("����");
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
				//data=fis.read();//1byte �о���δ�!
				//data=reader.read(); //2byte�� �о���δ�!
				data=buffr.readLine(); //���پ� �о���δ�!
				count++;				
				//if(data==-1)break;
				if(data==null)break;
				//area.append(Character.toString((char)data));
				area.append(data+"\n");
			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�.");
			e.printStackTrace(); //�����ڸ� ���� �α� ����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void save(){
		try {
			fos=new FileOutputStream(dest);
			//fos�� �׳� �ٷ� ��ο� �� ������ ������Ų��.
			//writer=new OutputStreamWriter(fos, "utf-8");
			writer2= new PrintWriter(fos);
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "��θ� ã�� �� �����ϴ�.");
			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			JOptionPane.showMessageDialog(this, "�������� �ʴ� �����Դϴ�.");
//			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "���� �� �� �����ϴ�.");
			e.printStackTrace();
		} finally{
			if(writer2 !=null){
				writer2.close();
//				try {
//					writer.close();//���߿� �ϳ��� ������ �ȴ�. ���������� �����Ϸ��� ��������� �ϳ��� �ݾ����!
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
