
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.ScrollPane;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AIDisplay extends JFrame implements IAddNode{
	private static Graph graph = new Graph();
	private static GPanel display;
	public static CPanel console;
	
	public void startSearch(String start,String end,ISearch alg){
		if(alg.search(start, end)){
			//console.ConsoleWriteLine("HAVE A PATH");
		}else{
			console.ConsoleWriteLine("HAVE NOT A PATH");//replace with message box 
		}
	}
	
	private void init(){
		
        JPanel navBar = new JPanel();
        JPanel bot = new JPanel();
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension (300,400));
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
        
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 500));
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
        scroll.add(console);
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
        	      node.createWindow(graph);
        	   }
        	  });
        
        play.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				switch(algoritms.getSelectedIndex()){
				case 0 : startSearch(startField.getText(), endField.getText(), new CheapestPath(graph));
				case 1 : startSearch(startField.getText(), endField.getText(), new GreedyByCoordinates(graph));
				}
				
				System.out.println("b>c"+Math.sqrt(Math.pow(0-3, 2) +
				Math.pow(1-0, 2)));
				System.out.println("b>d"+Math.sqrt(Math.pow(0-1, 2) +
						Math.pow(1-4, 2)));
				double x = Math.sqrt(Math.pow(0-3, 2) +
						Math.pow(1-0, 2));
				double y =Math.sqrt(Math.pow(0-1, 2) +
						Math.pow(1-4, 2));
				
				if(x==y){
					System.out.println("b>c = b>d");
				}
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
	public void AddNode(Graph g) {
		// TODO Auto-generated method stub
		this.graph = g;
		display.Refresh(g);
	}

}
