
public class Link {
	
	Node relatedNode;
	double length;
	int type;
	double price;
	
	public Link(Node n,double l){
		this.relatedNode = n;
		this.length = l;
	}
	public Link(Node relatedNode, double length, int type) {
		super();
		this.relatedNode = relatedNode;
		this.length = length;
		this.type = type;
		price = setPrice(type,length);
	}
	
	private double setPrice(int type,double len){
		
		switch(type){
		case 1:{
			double length=len - 5;
			while(length>0){
				price = price + 2;
				length = length -10;
			}
			return price;
		}
		case 0:{
			double length=len - 10;
			price = 3;
			while(length>=1){
				price = price + 0.5;
				length = length -1;
			}
			return price;
		}
		default : return 0; 
			}//end switch
	}// end setPrice()
}
