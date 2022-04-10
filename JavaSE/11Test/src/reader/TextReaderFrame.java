package reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
/*JOptionPane.showMessageDialog(this," Message");
JOptionPane.showMessageDialog(Component parentComponent, Object message, String title, int messageType)
���磺JOptionPane.showMessageDialog(menu, "³Ѹ", "����", JOptionPane.INFORMATION_MESSAGE);

JFileChooser chooser = new JFileChooser(); 
FileNameExtensionFilter filter = new FileNameExtensionFilter( ��TXT & DOC Files", ��txt", ��doc"); 
chooser.setFileFilter(filter); 
int returnVal = chooser.showOpenDialog(parent); 
if(returnVal == JFileChooser.APPROVE_OPTION) { System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName()); }

*/
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextReaderFrame extends JFrame{
	public TextReaderFrame(){
		this.setVisible(true);
		this.setBounds(100, 100, 200, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JMenuBar menu = new JMenuBar();
		JMenu files = new JMenu("�˵�");
		JMenu about = new JMenu("����");
		JMenuItem opens = new JMenuItem("��");
		JMenuItem edit = new JMenuItem("�༭");
		JMenuItem close = new JMenuItem("�ر�");
		JMenuItem write = new JMenuItem("����");
		this.setJMenuBar(menu);
		menu.add(files);
		menu.add(about);
		files.add(opens);
		files.add(edit);
		files.add(close);
		about.add(write);
		//
		JOptionPane j = new JOptionPane();
		write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j.showMessageDialog(write, "³Ѹ", "����", TEXT_CURSOR);
			}
		});
		opens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter( "TXT & DOC Files", "txt", "doc"); 
				chooser.setFileFilter(filter); 
				int returnVal = chooser.showOpenDialog(j); 
				if(returnVal == JFileChooser.APPROVE_OPTION) { System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName()); }
			}
		});
	}
	
	public static void main(String[] args) {
		new TextReaderFrame();	
	}
}
