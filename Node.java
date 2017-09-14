package map;

public class Node {
	
	int x;
	int y;
	int type;  //type 0 = normal, 1 = highway, 2 = hard to traverse, 3 = blocked
	double probOfBeingHere;
	
	public Node(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
