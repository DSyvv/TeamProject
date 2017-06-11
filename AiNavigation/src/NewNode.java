import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.Messaging.SyncScopeHelper;

public class NewNode extends JFrame{
	
	JPanel navBar = new JPanel();
	JPanel links = new JPanel();
	JPanel butons = new JPanel();
	
	JLabel nodeNameLabel = new JLabel("Node name*: ");
	JLabel coordinateXLabel = new JLabel("X coordinate: ");
	JLabel coordinateYLabel = new JLabel("Y coordinate: ");
	JLabel weightLabel = new JLabel("Weight: ");
	JLabel linkNodeLabel = new JLabel("Link to Node*: ");
	JLabel linkLengthLabel = new JLabel("Link Length*: ");
	JLabel linkTypeLabel = new JLabel("Link Type: ");
	
	JTextField nodeNameField = new JTextField();
    JTextField coordinateXField = new JTextField();
    JTextField coordinateYField = new JTextField();
    JTextField weightField = new JTextField();
    
    JTextField linkNodeField = new JTextField();
    JTextField linkLengthField = new JTextField();
    JTextField linkTypeField = new JTextField();
    
    JButton addButton = new JButton("Add Node");
    JButton addLink = new JButton("add Link");
	
    int count =2;
    Graph g;
    Set<String> exc;
    ArrayList<JTextField> components = new ArrayList<JTextField>();
	public void createWindow(Graph h) {
		 
		 this.g = h;
		 exc = g.getMap().keySet();
		 
		 setLayout(new GridLayout(0, 3));
		 
		 navBar.setPreferredSize( new Dimension (200,400));
		 nodeNameField.setPreferredSize(new Dimension(100,25));
		 coordinateXField.setPreferredSize(new Dimension(100,25));
		 coordinateYField.setPreferredSize(new Dimension(100,25));
		 weightField.setPreferredSize(new Dimension(100,25));
		 navBar.add(nodeNameLabel);
		 navBar.add(nodeNameField);
		 navBar.add(coordinateXLabel);
		 navBar.add(coordinateXField);
		 navBar.add(coordinateYLabel);
		 navBar.add(coordinateYField);
		 navBar.add(weightLabel);
		 navBar.add(weightField);
		 
		 links.setPreferredSize( new Dimension(200,700));
		 linkNodeField.setPreferredSize(new Dimension(100,25));
		 linkLengthField.setPreferredSize(new Dimension(100,25));
		 linkTypeField.setPreferredSize(new Dimension(100,25));
		 
		components.add(linkNodeField);
		components.add(linkLengthField);
		components.add(linkTypeField);
		 
		 links.add(linkNodeLabel);
		 links.add(linkNodeField);
		 links.add(linkLengthLabel);
		 links.add(linkLengthField);
		 links.add(linkTypeLabel);
		 links.add(linkTypeField);
		 
		 butons.setLayout(new BoxLayout(butons,1));
		 butons.add(addButton);
		 butons.add(addLink);
		 
		 addLink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				linkNodeField= new JTextField();
				linkLengthField= new JTextField();
				linkTypeField= new JTextField();
				linkNodeField.setPreferredSize(new Dimension(100,25));
				linkLengthField.setPreferredSize(new Dimension(100,25));
				linkTypeField.setPreferredSize(new Dimension(100,25));
				
				links.add(new JLabel("Link to Node*: "));
				links.add(linkNodeField);
				links.add(new JLabel("Link Length*: "));
				links.add(linkLengthField);
				links.add(new JLabel("Link Type: "));
				links.add(linkTypeField);
				links.validate();
				links.repaint();
				count++;
				
				components.add(linkNodeField);
				components.add(linkLengthField);
				components.add(linkTypeField);
				/*
				}*/
				
			}
		});
		 addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					Node node = null;
					String nameNode= nodeNameField.getText();
					int x,y;
					double weight;
					if(exc.contains(nameNode) || nameNode.equals("")){
						nodeNameField.setForeground(Color.RED);
						JOptionPane.showMessageDialog(navBar, "Node with name '"+nameNode+"' exist or its banned!!!\nPlease add it first!");
						return;
					}else{
						node = new Node(nameNode);
					}
					
					if(weightField.getText().equals("")){
						weightField.setForeground(Color.RED);
					}
					if(!coordinateXField.getText().equals("") && !coordinateYField.getText().equals("")){
						x = Integer.parseInt(coordinateXField.getText());
						y = Integer.parseInt(coordinateYField.getText());
						node = new Node(nameNode,x,y);
					}
					if(!coordinateXField.getText().equals("") && !coordinateYField.getText().equals("") && !weightField.getText().equals("")){
						x = Integer.parseInt(coordinateXField.getText());
						y = Integer.parseInt(coordinateYField.getText());
						weight = Double.parseDouble(weightField.getText());
						node = new Node(nameNode,x,y,weight);
					}
					g.addNode(node);

					JOptionPane.showMessageDialog(navBar, "added?");
					for(int i = 0; i < components.size();i+=3){
						String name = components.get(i).getText();
						int len = Integer.parseInt(components.get(i+1).getText());
						int type;
						if(!exc.contains(name)){
							JOptionPane.showMessageDialog(navBar, "Node with name '"+name+"' don't exist !!!\nPlease add it first!");
							components.get(i).setForeground(Color.RED);
						}
						g.addTwoWayLink(nameNode, name, len);
						if(!components.get(i+2).getText().equals("")){
							type = Integer.parseInt(linkTypeField.getText());
							g.addTwoWayLink(nameNode, name, len, type);
						}
					}
					
					addNode(g, new AIDisplay());
					JOptionPane.showMessageDialog(navBar, "added?");
				}catch(NumberFormatException ex){
					for(JTextField fields : components){
						fields.setText("");
					}
				}
			}
		});
		 this.add(navBar);
		 this.add(links);
		 this.add(butons);
		 this.setVisible(true);
	     this.setSize(600, 600);
	     pack();
	 }
	private void addNode(Graph g , IAddNode Iadd){
		Iadd.AddNode(g);
	}
}
