import java.util.ArrayList;

public class CheapestPath implements ISearch{
	
	Graph graph;
	
	public CheapestPath(Graph g) {
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
			//Util.printArr(queue);
			//printInfo(temp);
			if(temp.name.equals(end)){
				AIDisplay.console.ConsoleWriteLine("Path is found with price: " + temp.cost);
				//System.out.println("Path is found with price: " + temp.cost);
			}
			
			queue.remove(0);
			
			if(!temp.expanded){
				for(Link link : temp.linkLength){
					setParent(temp, link);
					System.out.println(link.price);
					Util.sortByCost(link.relatedNode, queue);
				}
				temp.expanded = true;
			}// end if
		}// while
		
		if(graph.getNode(end).parent != null){
			//AIDisplay.console.ConsoleWriteLine("Shortest path length: " + graph.getNode(end).cost);
			//System.out.println("Shortest path length: " + graph.getNode(end).cost);
			Util.pathPrint(end, graph);
			return true;
		}else{
			return false;
		}
		
	}// end search()
	
	public void printInfo(Node node){
		String parentName;
		if(node.parent != null){
			parentName = node.parent.name;
		}else{
			parentName = "No parent";
		}
		AIDisplay.console.ConsoleWriteLine("Test node is: " + node.name +
				" , Parent: " + parentName +
				" , Cost: " + node.cost);
		System.out.println("Test node is: " + node.name +
				" , Parent: " + parentName +
				" , Cost: " + node.cost);
	}
	
	public void setParent(Node parent,Link child){
		Node childNode = child.relatedNode;
		double length = child.price;
		double newCost = parent.cost + length;
		
		if(!childNode.expanded)
		if(childNode.parent == null || childNode.cost>newCost){
			childNode.parent = parent;
			childNode.cost = newCost;
		}
	}

}
