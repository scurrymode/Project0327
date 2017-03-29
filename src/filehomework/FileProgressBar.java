package filehomework;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class FileProgressBar extends JFrame implements ActionListener{
	JProgressBar bar;
	JButton b_open, b_path, b_copy;
	JLabel l_open, l_path;
	FileInputStream fis;
	FileOutputStream fos;
	File file;
	File oriPath;
	File destPath;
	JFileChooser chooser;
	int count;
	
	public FileProgressBar() {
		
		setLayout(new FlowLayout());
		bar = new JProgressBar();
		b_open = new JButton("열기");
		b_path = new JButton("경로");
		b_copy = new JButton("실행");
		l_open = new JLabel("경로가 들어갈꺼얌");
		l_path = new JLabel("경로가 들어갈꺼라고");
		
		file= new File("C:/Users/user/Downloads/");
		chooser=new JFileChooser(file);
		
		bar.setPreferredSize(new Dimension(450, 50));
		l_open.setPreferredSize(new Dimension(380, 50));
		l_path.setPreferredSize(new Dimension(380, 50));
					
		add(bar);
		add(b_open);
		add(l_open);
		add(b_path);
		add(l_path);
		add(b_copy);
		
		b_open.addActionListener(this);
		b_path.addActionListener(this);
		b_copy.addActionListener(this);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		JButton bt=(JButton)obj;
		
		if(bt==b_open){
			open();
		}
		else if(bt==b_path){
			path();
			
		}
		else if(bt==b_copy){
			FileThread thread= new FileThread(this);
			thread.start();
		}
		
	}
	
	public void open(){
		chooser.showOpenDialog(this);
		oriPath= chooser.getSelectedFile();
		l_open.setText(oriPath.getAbsolutePath());
	}
	
	public void path(){
		chooser.showSaveDialog(this);
		destPath= chooser.getSelectedFile();
		l_path.setText(destPath.getAbsolutePath());
	}
	
	public void copy(){
		
	}
	 
	public static void main(String[] args) {
		new FileProgressBar();
	}

}
