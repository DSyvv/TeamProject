
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GPanel extends JPanel{
	
	private Graph graph;
	
	public GPanel(Graph g){
		super.setPreferredSize(new Dimension(500,500));
		this.graph = g;
		
	}
	public void Refresh(Graph g){
		this.graph =g;
		this.revalidate();
		this.repaint();
	}
	 int size;
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //set locations
        boolean flag = false;
        for(Node node : graph.getMap().values()){
        	if(node.x!=0 && node.y!=0){
        		flag = true;
        		size=55;
        	}
        }
        for(Node node : graph.getMap().values()){
        	if(!flag){
        		Util.setPattern(graph,2,-50);
        		size=5;
        	}
        	node.location = new Point(43+size* node.x,52+size*node.y);
        }
        //drawLinks
        //AIDisplay.console.ConsoleWriteLine("In GPanel                                           21321312321", 1);
        int x1,x2,y1,y2;
        ArrayList<Integer> coordinats = new ArrayList<Integer>();
        for(Node node : graph.getMap().values()){
        	node.tested = true;
    	   for(Link link : node.linkLength){
    		   if(link.relatedNode.tested){continue;}
    		   x1=node.location.x;
    		   x2=link.relatedNode.location.x;
    		   y1=node.location.y;
    		   y2=link.relatedNode.location.y;
    		   int m1,m2;
    		   m1=(x1+x2)/2+5;
    		   m2=(y1+y2)/2+5;
    		   if(coordinats.contains(x1) && coordinats.contains(y1)){
    			   m2+=10;
    			   g.drawString(link.length+"-"+node.name+","+link.relatedNode.name,m1,m2);
    		   }
    		   coordinats.add(y1);
    		   coordinats.add(x1);
    		   g.drawLine(node.location.x, node.location.y, link.relatedNode.location.x, link.relatedNode.location.y);
    		   g.drawString(link.length+"",m1,m2);
    	   }
        }
        //DrawNodes
        for(Node node: graph.getMap().values()){
        	g.setColor(new Color(255, 0, 0));
        	g.fillOval(25 +size* node.x, 25 +size* node.y, 45, 45);
        	g.setColor(new Color(0,0,0));
        	g.drawString(node.name, 43+size*node.x, 52+size*node.y);
        }
	}
}
/*
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GPanel extends JPanel{
	
	private Graph graph;
	
	public GPanel(Graph g){
		super.setPreferredSize(new Dimension(500,500));
		this.graph = g;
	}
	public void paint(Graph gr) {
		Graphics g = super.getGraphics();
		removeAll();
		invalidate();
        revalidate();
        for(String manes: gr.getMap().keySet()){
        	add(new JLabel(manes));
        }
        g.fillRoundRect(50, 50, 100, 100, 80, 80);
        // draw

        g.fillRoundRect(150, 150, 100, 100, 80, 80);
	}
}
*/
