import java.util.ArrayList;

public class GreedyByCoordinates implements ISearch {
	
	Graph graph;
	String path = "";
	public GreedyByCoordinates(Graph g) {
		this.graph = g;
	}
	
	@Override
	public boolean search(String start, String end) {
		
		if(!graph.containsNode(start) || !graph.containsNode(end)){
			return false;
		}
		graph.graphReset();
		Node startNode = graph.getNode(start);
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(startNode);
		
		while(!queue.isEmpty()){
			Node temp = queue.get(0);
			AIDisplay.console.ConsoleWriteLine("Test node is: " + temp.name);
			path = path + temp.name+ "->";
			System.out.println("Test node is: " + temp.name);
			if(temp.name.equals(end)){
				AIDisplay.console.ConsoleWriteLine(path+"BRAVO!");
				return true;
			}
			temp.tested = true;
			queue.remove(0);
			for(Node node : temp.links){
				if(!node.tested && !queue.contains(node)){
					Util.sortByDistance(node, temp, queue);
				}
			}
		}// while
		return false;
	}// end search()
}
