/*
 * �г��� �󺧰� ��ư�� ������ �ִ�.
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
	
	
	//�г��� �¾��, �� ��ǰ�� ���� �¾�� �ϹǷ�, �����ڿ��� �ʱ�ȭ ����!
	public MyPanel(String title, Icon icon, Icon icon2, ArrayList<JButton> bts) {
		la = new JLabel(title);
		bt = new JButton(icon);
		
		//��輱 ���ֱ�
		bt.setBorderPainted(false);
		//����Ʈ ������ ��ä���
		bt.setContentAreaFilled(false);
		//��Ŀ���� ���� ��� ���ֱ�
		bt.setFocusPainted(false);
		//��������ֱ�
		
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
