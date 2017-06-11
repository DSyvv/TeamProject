import java.util.ArrayList;

public class PassTrough implements ISearch{
	
	Graph graph;
	String path;
	public PassTrough(Graph g) {
		this.graph = g;
	}
	
	@Override
	public String search(String start, String end) {
		
		if(!graph.containsNode(start) || !graph.containsNode(end)){
			return "No Path";
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
				System.out.println("Path is found with price: " + temp.cost);
			}
			
			queue.remove(0);
			
			if(!temp.expanded){
				for(Link link : temp.linkLength){
					setParent(temp, link);
					Util.sortByCost(link.relatedNode, queue);
					
				}
				temp.expanded = true;
			}// end if
		}// while
		
		if(graph.getNode(end).parent != null){
			System.out.println("Shortest path length: " + graph.getNode(end).cost);
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
