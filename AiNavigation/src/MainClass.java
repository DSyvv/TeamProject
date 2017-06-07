
public class MainClass {
	
	static Graph graph = new Graph();
	
	public static void init(Graph g){
		g.addNode("A",0,0);
		g.addNode("C",0,3);
		g.addNode("B",2,0);		
		g.addNode("D",6,0);
		g.addNode("E",2,4);
		g.addNode("F",0,20);
		g.addTwoWayLink("C","F",26,1);
		g.addTwoWayLink("A","B",13,2);
		g.addTwoWayLink("A","C",16,2);
		g.addTwoWayLink("D","B",14,0);
		g.addTwoWayLink("E","B",18,1);
		g.addTwoWayLink("F","B",17,0);
		g.addTwoWayLink("E","D",13,3);
		g.addTwoWayLink("E","F",14,0);
	}
	
	public static void startSearch(String start,String end,ISearch alg){
		
		if(alg.search(start, end)){
			System.out.println("HAVE A PATH");
		}else{
			System.out.println("HAVE NOT A PATH");
		}
		
	}
	
	/*public static void main(String[] args) {
		init(graph);
		startSearch("A", "F", new GreedyByCoordinates(graph));
		//startSearch("C", "D", new ShortestPath(graph));
	}*/

}
