
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AIDisplay extends JFrame implements IAddNode{
	private static Graph graph = new Graph();
	private static GPanel display;
	public static CPanel console;
	
	public void startSearch(String start,String end,ISearch alg){
		if(alg.search(start, end)){
			System.out.println("HAVE A PATH");
		}else{
			System.out.println("HAVE NOT A PATH");//replace with message box 
		}
	}
	
	private void init(){
		
        JPanel navBar = new JPanel();
        JPanel bot = new JPanel();
        display = new GPanel(graph);
        console = new CPanel();
        
        JLabel startLabel = new JLabel("Start Node:");
        JLabel endLabel = new JLabel("End Node:");
        JLabel stopsLabel = new JLabel("Visit Node/s:");
        
        JComboBox<String> algoritms = new JComboBox<String>();
        
        JTextField startField = new JTextField();
        JTextField endField = new JTextField();
        JTextField stopsField = new JTextField();
        
        JButton addNodeButton = new JButton("Add Node");
        JButton load = new JButton("Load Map");
        JButton save = new JButton("Save Map");
        JButton play = new JButton("Play");
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(600, 700));
        bot.setPreferredSize(new Dimension(600,100));
        setLayout(new BorderLayout());
        
        navBar.setLayout(new GridLayout(0, 10));
        
        startLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        endLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        stopsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        algoritms.addItem("Cheapest");
        algoritms.addItem("GreedyNaibor");
        algoritms.addItem("PassTrouth");
        
        bot.setLayout(new BoxLayout(bot, BoxLayout.LINE_AXIS));
        bot.add(Box.createHorizontalGlue());
        bot.add(addNodeButton);
        addNodeButton.setHorizontalAlignment(SwingConstants.RIGHT);
        
        add(bot, BorderLayout.PAGE_END);
        add(navBar, BorderLayout.PAGE_START);
        add(display , BorderLayout.CENTER);
        add(console, BorderLayout.LINE_END);
        //stupidPanel();
        navBar.add(load);
        navBar.add(save);
        
        
        navBar.add(startLabel);
        navBar.add(startField);
        navBar.add(endLabel);
        navBar.add(endField);
        navBar.add(stopsLabel);
        navBar.add(stopsField);
        navBar.add(algoritms);
        navBar.add(play);
        
        
        
        addNodeButton.addActionListener(new ActionListener() {
        	   
        	   @Override
        	   public void actionPerformed(ActionEvent e) {
        	      NewNode node = new NewNode();
        	      node.createWindow();
        	      
        	   }
        	  });
        
        play.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        load.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	FileDialog fd = null;
                fd = new FileDialog( fd, "Load Map", FileDialog.LOAD);
                fd.setVisible(true);
                //System.out.println(fd.getFile());
                ReadMap read = new ReadMap();
                String path = fd.getDirectory() + "" +fd.getFile();
                graph = read.ReadMap(path);
                display.Refresh(graph);
            }
        });
       save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	FileDialog fd = null;
                fd = new FileDialog(fd, "Save Map", FileDialog.SAVE);
                fd.setVisible(true);
                //System.out.println(fd.getFile());
                String path = fd.getDirectory() + "" +fd.getFile();
                SaveMap smap = new SaveMap();
                smap.Save(graph,path);
            }
        });
        pack();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AIDisplay n = new AIDisplay();
				n.init();
	}

	@Override
	public void AddNode(Node node) {
		// TODO Auto-generated method stub
		graph.addNode(node);
		JOptionPane.showMessageDialog(this, "Node "+node.name+" added.");
		display.Refresh(graph);
	}

}
