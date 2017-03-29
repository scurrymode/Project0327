package file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame {
	ImageIcon icon_off = new ImageIcon("C:/java_workspace2/Project0327/res/folder_off.png");
	ImageIcon icon_on = new ImageIcon("C:/java_workspace2/Project0327/res/folder_on.png");
	File file = new File("c:/");
	File[] dir = file.listFiles();
	ArrayList<JButton> bts=new ArrayList<JButton>();
	String name;
	
	
	public FileExplorer() {
		
		setLayout(new FlowLayout());
				
		for (int i=0; i<dir.length;i++){
			if(dir[i].isDirectory()){
				name=dir[i].getName();
				panelD();
			}
			
		}
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}	
	
	public void panelD(){
		JPanel p=new JPanel();
		JLabel l=new JLabel(name);
		JButton b=new JButton(icon_off);
		
		
		p.setLayout(new BorderLayout());
		p.add(l, BorderLayout.NORTH);
		p.add(b);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setOpaque(false);
		b.setSelectedIcon(icon_on);
		
		bts.add(b);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				for (int i=0;i<bts.size();i++){
//					bts.get(i).setIcon(icon_off);
//					
//				}b.setIcon(icon_on);
//				
			
			}
		});
//		b.setIcon(icon_off);
//		b.setPressedIcon(icon_on);
		add(p);
		add(b);
	
	}	

	public static void main(String[] args) {
		new FileExplorer();

	}

}
