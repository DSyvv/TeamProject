import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveMap {
	public void Save(Graph g,String fname){
		try{
			PrintWriter writer;
			if(fname.contains(".txt")){
				writer = new PrintWriter(fname, "UTF-8");
			}else
				writer = new PrintWriter(fname+".txt", "UTF-8");
			
		    for(String name :g.getMap().keySet()){
		    	writer.println("#" + name + "#");
		    }
		    int x=2;
		    for(Node node : g.getMap().values()){
		    		node.tested=true;
		    		for(Link link: node.linkLength){
		    			if(link.relatedNode.tested){x++;continue;}
		    			writer.println("$"+node.name +"," +link.relatedNode.name+","+(int) link.length+"," +link.type+"$");
		    			writer.println("$"+link.relatedNode.name +"," +node.name+","+(int) link.length+"," +link.type+"$");
			    		x++;	
		    		}//end link for
		    }//end map values
		    writer.close();
		} catch (IOException e) {
			// catch something
		}
	}
	/*public static void main(String[] args) {
		Graph g = new Graph();
		ReadMap r =new ReadMap();
		;
		Save(r.Read());
	}*/
}
