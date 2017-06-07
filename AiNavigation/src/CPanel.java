import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CPanel extends JPanel{
	protected JLabel message = new JLabel();
	
	
		public void ConsoleWriteLine(String text,int type){
			message.setFont(new Font("Serif", Font.PLAIN, 16));
			switch(type){
				case 0:{
					message.setForeground(Color.RED);
					message.setText(text);
					add(message);
				}
				case 1:{
					message.setForeground(Color.BLACK);
					message.setText(text);
					add(message);
				}
			}
		}
		public void ConsoleWriteLine(String text,int type,int size){
			message.setFont(new Font("Serif", Font.PLAIN, size));
			switch(type){
				case 0:{
					message.setForeground(Color.RED);
					message.setText(text);
					add(message);
				}
				case 1:{
					message.setForeground(Color.BLACK);
					message.setText(text);
					add(message);
				}
			}
		}
}
