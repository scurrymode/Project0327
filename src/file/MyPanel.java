/*
 * 패널이 라벨과 버튼을 가지고 있다.
 * JPanel has a JLabel& JButton
 * */
package file;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	
	
	//패널이 태어날때, 그 부품도 같이 태어나야 하므로, 생성자에서 초기화 하자!
	public MyPanel(String title, Icon icon, Icon icon2, ArrayList<JButton> bts) {
		la = new JLabel(title);
		bt = new JButton(icon);
		
		//경계선 없애기
		bt.setBorderPainted(false);
		//컨텐트 영역에 색채우기
		bt.setContentAreaFilled(false);
		//포커스에 의한 경계 없애기
		bt.setFocusPainted(false);
		//불투명없애기
		
		bt.setOpaque(false);
		bts.add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<bts.size();i++){
					if(bts.get(i)==bt){
						bts.get(i).setIcon(icon2);
					}else{
						bts.get(i).setIcon(icon);
					}
				}
			}
		});
		
		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);
		
		
		
		
	}
	
	

}
