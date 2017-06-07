import java.awt.Point;
import java.util.ArrayList;

public class Node {
	
	public String name;
	public int x,y;
	public double weight;
	public Point location;
	ArrayList<Node> links = new ArrayList<Node>();
	ArrayList<Link> linkLength = new ArrayList<Link>();
	
	public boolean tested;
	public boolean expanded;
	public int depth;
	public Node parent = null;
	public double cost;
	
	public Node(String n){
		this.name = n;
	}
	
	public Node(String n, int x , int y){
		this.name = n;
		this.x = x;
		this.y = y;				
	}
	
	public Node(String n, int x , int y,double weight){
		this.name = n;
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
	
	public void reset(){
		this.tested = false;
		this.expanded = false;
		this.depth = 0;
		this.parent = null;
		this.cost = 0;
	}
}
