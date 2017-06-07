import java.util.ArrayList;

public class Util {
	
	
	public static int[] initMyConstraints(Graph g){
		int size = g.getMap().size();
		int[] myInts = new int[size*2];
		for(int i = 0;i<size;i++ ){
			myInts[i] = (i+2)*size;
			System.out.println(myInts[i]);
		}
		return myInts;
	}
	public static void setPattern(Graph g,int zoom, int hotizontalPosition){
		int i=0;
		int[] coordinats = {50,5,40,20,60,20,30,35,50,35,70,35};
		for(Node node: g.getMap().values()){
			if(node.x == 0 && node.y == 0){
				node.x = coordinats[i]*zoom+hotizontalPosition;
				i++;
				node.y = coordinats[i]*zoom;
			}
			i++;
		}
	}
	public static void pathPrint(String end,Graph graph){
		Node stopNode = graph.getNode(end);
    	if(stopNode.parent != null){
    		System.out.print(stopNode.name+ "<-");
    		pathPrint(stopNode.parent.name,graph);
    	}
    	else {
    		System.out.print(stopNode.name+"| " + "\n");
    		return;
    	}
    }
	
	public static double calcDistance(Node n1,Node n2){
		
		double distance = Math.sqrt(Math.pow(n1.x-n2.x, 2) +
				Math.pow(n1.y-n2.y, 2));
		/*System.out.println(n1.name + " " + n2.name +
				" " + distance);*/
		return distance;
	}
	
	public static void sortByDistance(Node start,Node end,ArrayList<Node> list){
		double distance = calcDistance(start, end);
		//System.out.println("sort"+start.name +","+end.name);
		for(int i=0;i<list.size();i++){
			//System.out.println("out eq ("+start.name+","+list.get(i).name+") "+distance+"<"+calcDistance(end, list.get(i)));
			
			if(distance<calcDistance(end, list.get(i))){
				//System.out.println("eq ("+start.name+","+list.get(i).name+") "+distance+"<"+calcDistance(end, list.get(i)));
				list.add(i, start);
				break;
			}//end if clause
		}// end for
		
		if(!list.contains(start)){
			list.add(start);
			//System.out.println("added " + start.name);
		}
	}
	
	public static void sortByCost(Node node,ArrayList<Node> list){
		for(int i=0;i<list.size();i++){
			if(node.cost<list.get(i).cost){
				list.add(i,node);
				break;
			}
		}
		
		if(!list.contains(node)){
			list.add(node);
		}
	}
	
	public static void printArr(ArrayList<Node> list){
		for(Node node: list){
			System.out.print(" | " + node.name);
		}
		System.out.println();
	}
}
