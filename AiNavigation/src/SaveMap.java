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
		    ArrayList<String> map = new ArrayList<String>();
		    String input;
		    for(Node node : g.getMap().values()){
		    	for(Node relayed : node.links){
		    		for(Link link: relayed.linkLength){
		    			if(link.relatedNode == node){
		    				input = ("$"+node.name +"," +relayed.name+","+(int) link.length+"," +link.type+"$");
			    			if(!map.contains(input)){
			    				map.add(input);
			    			}//end repeat if
		    			}//end connection if
		    		}//end link for
		    	}//end node link list
		    }//end map values
		    
		    for(String n : map){
		    	writer.println(n);
		    }
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
