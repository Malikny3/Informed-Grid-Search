package map;

import java.io.IOException;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MapGenerate {
String[] arrval = new String[301];
String[] mapstring = new String[1];

	public MapGenerate(){}
	
	public void genMap(int p){
		try{
			String filen = "Input" + p + ".txt";
			System.out.println(filen);
			FileWriter writ = new FileWriter(filen, false);
			BufferedWriter buffwrit = new BufferedWriter(writ);
			
			Random endx = new Random();
			Random endy = new Random();
			Random x = new Random();
			Random y = new Random();
			
			
			int endcoordx = endx.nextInt(160);
			int endcoordy = endy.nextInt(20);
			String end = endcoordx+ "," + endcoordy;
			arrval[0] = end;
			buffwrit.write(arrval[0]);
			buffwrit.newLine();
			
			
			int startx = x.nextInt(160);
			int starty = y.nextInt(120);
			
			boolean up = false;
			boolean right = false;
			
			if(Math.abs((startx - endcoordx)) > 50){
				if(startx > endcoordx){
					startx = startx - ((startx - endcoordx) - 50);
					right = false;
				}
				else{
					startx = startx + ((endcoordx - startx) - 50);
					right = true;
				}
			}
			else if(Math.abs((startx - endcoordx)) < 50){
				if(startx > endcoordx){
					startx = startx + (50 - (startx - endcoordx));
					right = false;
				}
				else{
					startx = startx - (50 - (endcoordx - startx));
					right = true;
				}
			}
			else{
				System.out.println(Math.abs(startx - endcoordx));
			}
			
			
			if(Math.abs((starty - endcoordy)) > 50){
				if(starty > endcoordy){
					starty = starty - ((starty - endcoordy) - 50);
					up = false;
				}
				else{
					starty = starty + ((endcoordy - starty) - 50);
					up = true;
				}
			}
			
			
			else if(Math.abs((starty - endcoordy)) < 50){
				if(starty > endcoordy){
					starty = starty + (50 - (starty - endcoordy));
					up = false;
				}
				else{
					starty = starty - (50 - (endcoordy - starty));
					up = true;
				}
			}
			else{
				System.out.print(Math.abs(starty - endcoordy));
			}
			
			String start = startx + "," + starty;
			arrval[1] = start;
			
			
			for(int i = 2; i < 51; i++){
				if(up){
					starty = starty + 1;
				}
				else{
					starty = starty - 1;
				}
				String temp = startx + "," + starty;
				arrval[i] = temp;
				buffwrit.write(arrval[i]);
				buffwrit.newLine();
			}
			for( int i = 51; i < 101; i++){
				if(right){
					startx = startx + 1;
				}
				else{
					startx = startx - 1;
				}
				String temp = startx + "," + endcoordy;
				arrval[i] = temp;
				buffwrit.write(arrval[i]);
				buffwrit.newLine();
			}
			for(int i = 101; i < 151; i++){
				String direction;
				if(up){
					direction = "U";
				}
				else{
					direction = "D";
				}
				arrval[i] = direction;
				buffwrit.write(arrval[i]);
				buffwrit.newLine();
			}
			for(int i = 151; i < 201; i++){
				String direction;
				if(right){
					direction = "R";
				}
				else{
					direction = "L";
				}
				arrval[i] = direction;
				buffwrit.write(arrval[i]);
				buffwrit.newLine();
			}
				if(p == 1 || p == 10 || p == 20 || p == 30 || p == 40 || p == 50 || p == 60 || p == 70 || p == 80 || p == 90 || p == 100){
					String temp = "";
					mapstring[0] = temp;
					CreateNewString(mapstring);
				}
				arrval[201] = mapstring[0];
				buffwrit.write(arrval[201]);
			
			buffwrit.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}	
	}
	
	public void CreateNewString(String[] map){
		for(int i = 201; i < 301 ; i++){
			Random t = new Random();
			int type;
			type = t.nextInt(10);
			if(type <= 4){
				map[0] = map[0] + "N";
			}
			else if(type == 5 || type == 6){
				map[0] = map[0] + "H";
			}
			else if(type == 7 || type == 8){
				map[0] = map[0] + "T";
			}
			else{
				map[0] = map[0] + "B";
			}
		}
	}
	
	public static void main(String[] args) {
			MapGenerate map = new MapGenerate();
			int i = 1;
			while(i <= 100){
				map.genMap(i);
				i++;
			}
    }
}
