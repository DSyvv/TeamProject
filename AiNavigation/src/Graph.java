import java.util.Collection;
import java.util.HashMap;

public class Graph {
	
	private HashMap<String,Node> map = new HashMap<String,Node>();
	
	public void  addNode(String name){
		Node temp = new Node(name);
		map.put(temp.name, temp);
	}
	public void addNode(Node node){
		map.put(node.name, node);
	}
	public void  addNode(String name,int x, int y){
		Node temp = new Node(name,x,y);
		map.put(temp.name, temp);
	}
	public void  addNode(String name,double weight,int x, int y){
		Node temp = new Node(name,x,y,weight);
		map.put(temp.name, temp);
	}
	public void graphReset(){
		Collection<Node> col = map.values(); 
		for(Node node : col){
			node.reset();
		}
	}
	
	public void addOneWayLink(String start,String end,double l){
		if(map.containsKey(start) && map.containsKey(end)){
			Node startNode = map.get(start);
			Node endNode = map.get(end);
			startNode.links.add(endNode);
			startNode.linkLength.add(new Link(endNode,l));
		}else{
			System.out.println("Fake nodes");
		}		
	}// end addOneWayLink()
	
	public void addTwoWayLink(String name1,String name2,double l){
		addOneWayLink(name1, name2,l);
		addOneWayLink(name2, name1,l);
	}
	public void addOneWayLink(String start,String end,double l,int type){
		if(map.containsKey(start) && map.containsKey(end)){
			Node startNode = map.get(start);
			Node endNode = map.get(end);
			startNode.links.add(endNode);
			startNode.linkLength.add(new Link(endNode,l,type));
		}else{
			System.out.println("Fake nodes");
		}		
	}// end addOneWayLink()
	
	public void addTwoWayLink(String name1,String name2,double l,int type){
		addOneWayLink(name1, name2,l, type);
		addOneWayLink(name2, name1,l, type);
	}
	public Node getNode(String name){
		return map.get(name);
	}
	public HashMap<String,Node> getMap(){
		return map;
	}
	public boolean containsNode(String name){
		return map.containsKey(name);
	}
}
