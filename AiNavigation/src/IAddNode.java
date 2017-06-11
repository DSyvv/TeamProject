
public interface IAddNode { 
	/*implementation
	 * Graph g;
	 *AddNode(node){
	 *g.addNode(node);
	 *JOptionPane.showMessageDialog(this, "Node "+node.name+" added.");
	 *display.repaint();
	 *}
	 *
	 *usage
	 *use node constructors - Node(String n); , Node(String n, int x , int y); ,
	 * Node(String n, int x , int y,double weight);
	 *
	 *add and links >
	 * startNode.links.add(endNode);
	 * startNode.linkLength.add(new Link(endNode,l));
	 *<
	 *
	 *AddNode(Node node,IAddNode i){
	 *i.AddNode(node);
	 *}
	 * */
	public void AddNode(Graph node);
}
