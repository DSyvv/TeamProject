import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CPanel extends JPanel{
	public CPanel(){
		setPreferredSize(new Dimension(300,300));
		setLayout(new BoxLayout(this, 1));
	}
		public void ConsoleWriteLine(String text){
			
			add(new JLabel(text));
			validate();
			repaint();
		}
}
