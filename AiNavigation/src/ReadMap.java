import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadMap {

	public Graph ReadMap(String file){
		try {
			Graph g = new Graph();
	        String line;
	        File filE= new File(file);
	        FileReader fr = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fr);
	        
	        while((line = bufferedReader.readLine()) != null) {
	
	            String lineWords[] = line.split("\n");
	            for(String singleWord:lineWords) {
	            	if(singleWord.contains("#")){
	            	singleWord =singleWord.replaceAll("#", "");
	            	g.addNode(singleWord);
	            	}
	            	if(singleWord.contains("$")){
	            		String single = singleWord.replace("$", "");
	            		String data[] = single.split(",");
	            		
	            		switch(data.length){
	            		case 3: g.addTwoWayLink(data[0], data[1], Integer.parseInt(data[2]));
	            		case 4: g.addTwoWayLink(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])) ;
	            		}
	            	}
	            	//System.out.println(singleWord);             
	            }
	        }
	        bufferedReader.close();
	        return g;
	    } catch(Exception exception) {
	        System.out.println("IOException occured");
	        exception.printStackTrace();
	    }
		return null;
	}
	
	
}
