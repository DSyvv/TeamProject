import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.Messaging.SyncScopeHelper;

public class NewNode extends JFrame{
	
	JPanel navBar = new JPanel();
	
	JLabel nodeNameLabel = new JLabel("Node name:");
	JLabel coordinateXLabel = new JLabel("X coordinate:");
	JLabel coordinateYLabel = new JLabel("Y coordinate:");
	JLabel weightLabel = new JLabel("Weight:");
	
	JTextField nodeNameField = new JTextField();
    JTextField coordinateXField = new JTextField();
    JTextField coordinateYField = new JTextField();
    JTextField weightField = new JTextField();
    
    JButton addButton = new JButton("Add");
	
	public void createWindow() {
		
		 navBar.setLayout(new GridLayout(0, 10));
		 
		 JFrame frame = new JFrame("Simple GUI"); 
		 navBar.add(nodeNameLabel);
		 navBar.add(nodeNameField);
		 navBar.add(coordinateXLabel);
		 navBar.add(coordinateXField);
		 navBar.add(coordinateYLabel);
		 navBar.add(coordinateYField);
		 navBar.add(weightLabel);
		 navBar.add(weightField);
		 navBar.add(addButton);
		 this.add(navBar, BorderLayout.PAGE_START);
		 this.setVisible(true);
	     this.setSize(600, 600);
	     pack();
	 } 
}
