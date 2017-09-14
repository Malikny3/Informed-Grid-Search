package map;

public class Grid{
	
	Node[][] grid = new Node[3][3];
	
	public Grid(){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				this.grid[x][y] = new Node(x, y, 0);
			}
		}
	}
	public static void main(String[] args){
		Grid g = new Grid();
		g.grid[2][1].type = 3;
		g.grid[0][0].type = 1;
		g.grid[0][1].type = 1;
		g.grid[0][2].type = 2;
		g.grid[2][2].type = 1;
		
		g.printGrid();
		System.out.println();
		g.printGridProbs();
		System.out.println();
		g.update("right");
		g.updateSensor(0);
		
		double sum = 0.0;
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				sum += g.grid[x][y].probOfBeingHere;
			}
		}
		
		System.out.println(sum);
		System.out.println();
		g.update("right");
		g.updateSensor(0);
		System.out.println();
		g.update("down");
		g.updateSensor(1);
		System.out.println();
		g.update("down");
		g.updateSensor(1);
		
		
	}
	
	public void printGrid(){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				System.out.print("[" + this.grid[x][y].type + "]");
			}
			System.out.println();
		}
	}
	
	public void printGridProbs(){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(this.grid[x][y].type == 3){
					this.grid[x][y].probOfBeingHere = 0;
				}
				else{
					this.grid[x][y].probOfBeingHere = 1.0/8.0;
				}
				System.out.print("[" + this.grid[x][y].probOfBeingHere + "]");
			}
			System.out.println();
		}
	}
	
	public void updateSensor(int type){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				
			/*	if(type == 0){
					if(this.grid[x][y].type == 0){
						this.grid[x][y].probOfBeingHere *= .9;
					}
					else{
						this.grid[x][y].probOfBeingHere *= .5;
					}
				}
				else if(type == 1){
					if(this.grid[x][y].type == 1){
						this.grid[x][y].probOfBeingHere *= .9;
					}
					else{
						this.grid[x][y].probOfBeingHere *= .5;
					}
				}*/
				System.out.print("[" + this.grid[x][y].probOfBeingHere + "]");
			}
			System.out.println();
		}
	}
	
	public void update(String s){
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				
				if(s.equals("right")){
					if(y < 2 && this.grid[x][y+1].type == 3){
						this.grid[x][y].probOfBeingHere = this.grid[x][y].probOfBeingHere;
					}
					else{
						if(y == 0){
							this.grid[x][y].probOfBeingHere = .1*this.grid[x][y].probOfBeingHere;
						}
						else if(y == 1){
							this.grid[x][y].probOfBeingHere = .9*this.grid[x][y].probOfBeingHere;
						}
						else if(y == 2){
							this.grid[x][y].probOfBeingHere = this.grid[x][y].probOfBeingHere;
						}
					}
				}
				else{
					if(x < 2 && this.grid[x+1][y].type == 3){
						this.grid[x][y].probOfBeingHere = this.grid[x][y].probOfBeingHere;
					}
					else{
						if(x == 0){
							this.grid[x][y].probOfBeingHere = .1*this.grid[x][y].probOfBeingHere;
						}
						else if(x == 1){
							this.grid[x][y].probOfBeingHere = .9*this.grid[x][y].probOfBeingHere;
						}
						else if(x == 2){
							this.grid[x][y].probOfBeingHere = this.grid[x][y].probOfBeingHere;
						}
					}
				}
			}
		}
	}
	
}

