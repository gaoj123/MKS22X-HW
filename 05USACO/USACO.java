import java.util.*;
import java.io.*;

public class USACO{
	
	
	//bronze problem
	public USACO(){}

	public static int bronze(String filename){
		int answer = 0;
		try{
			Scanner scan = new Scanner(new File(filename));
			
			//PROBLEM WITH SCANNING AND RETRIEVING NUMBERS FROM TEXT FILE!!!!!!!


			//Line 1 specifies R, C, E, N
			String firstLine = scan.nextLine();
			String[] instanceVars = firstLine.split("\\s");
			int row = Integer.parseInt(instanceVars[0]);
			int col = Integer.parseInt(instanceVars[1]);
			int elevationFinal = Integer.parseInt(instanceVars[2]);
			int numDig = Integer.parseInt(instanceVars[3]);
			
			//Lines 2 to R+1
			int[][] lake = new int[row][col];
			String scanning = "";
			int check = 0;
			while (check < row * col){
				scanning = scan.next();
				for (int r=0; r < row; r++){
					for (int c=0; c < col; c++){
						lake[r][c] = Integer.parseInt(scanning); 
						check += 1;
					}
				}
			}

			//Retreiving digging instructions
			//digging is the array that stores the instructions
			int[][] digging = new int[numDig][3];
			int line=0;
			while (line < numDig){
				//this is the line with commands (ex: 1 4 4)
				String sequence = scan.nextLine();
				
				//these are the individuals ints in the command (ex: 1)
				String[] commands = sequence.split("\\s");
				digging[line][0] = Integer.parseInt(commands[0]);
				digging[line][1] = Integer.parseInt(commands[1]);
				digging[line][2] = Integer.parseInt(commands[2]);
					
				line += 1;
			}
			
			//note: there are possible restrictions... some squares cannot
			//have a 3x3 grid possible (uppermost left corner)
			//the section below executes the digging instructions 
			
			int execute=0;
			while (execute < numDig){
				int R_s = digging[execute][0], C_s = digging[execute][1], D_s = digging[execute][2];
				//making a new array to store the 3x3 grid
				int[][] cows = new int[3][3];
				int i=0;
				cows[0][0] = lake[R_s][C_s];
				cows[0][1] = lake[R_s][C_s+1];
				cows[0][2] = lake[R_s][C_s+2];
				
				cows[1][0] = lake[R_s+1][C_s];
				cows[1][1] = lake[R_s+1][C_s+1];
				cows[1][2] = lake[R_s+1][C_s+2];
				
				cows[2][0] = lake[R_s+1][C_s];
				cows[2][1] = lake[R_s+1][C_s+1];
				cows[2][2] = lake[R_s+1][C_s+2];
				
				//find initial max elevation first to stomp down 
				//find min elevation for later steps
				int maxElev = cows[0][0], minElev = cows[0][0];
				for (int r=0; r < 3; r++){
					for (int c=0; c < 3; c++){
						if (cows[r][c] > maxElev){
							maxElev = cows[r][c]; }
						if (cows[r][c] < minElev){
							minElev = cows[r][c]; }
					}
				}
				
				//commence the stomping for highest squares first
				for (int r=0; r < 3; r++){
					for (int c=0; c < 3; c++){
						if (cows[r][c] == maxElev){
							cows[r][c] -= D_s; }
					}
				}
				

				//match the other ones to stomp down
				maxElev -= D_s;
				for (int r=0; r < 3; r++){ 
					for (int c=0; c < 3; c++){
						if (cows[r][c] > maxElev){
							cows[r][c] = maxElev; }
					}
				}


				//going back to the original lake
				lake[R_s][C_s] = cows[0][0];
				lake[R_s][C_s+1] = cows[0][1];
				lake[R_s][C_s+2] = cows[0][2];
				
				lake[R_s+1][C_s] = cows[1][0];
				lake[R_s+1][C_s+1] = cows[1][1];
				lake[R_s+1][C_s+2] = cows[1][2];
				
				lake[R_s+1][C_s] = cows[2][0];
				lake[R_s+1][C_s+1] = cows[2][1];
				lake[R_s+1][C_s+2] = cows[2][2];
				
				execute += 1;
			}

		//accounting for final elevation
		for (int r=0; r < lake.length; r++){
			for (int c=0; c < lake[0].length; c++){
				if (lake[r][c] - elevationFinal > 0){
					lake[r][c] = 0; }
				else{
					lake[r][c] = Math.abs(lake[r][c] - elevationFinal); }
			}
		}

		//final step: finding the sum
		int totalDepth = 0;
		for (int r=0; r < lake.length; r++){
			for (int c=0; c < lake[0].length; c++){
				totalDepth += lake[r][c]; }
		}

		answer = 5184 * totalDepth;

	
		} catch(FileNotFoundException e){
						
			System.out.println("Error! File not found");
			System.exit(1); }
		return answer;
			
	}
	
/**
	public static String toString(){
		String answer = "";
		for (int r=0; r < lake.length; r++){
			for (int c=0; c < lake[0].length; c++){
				answer += lake[r][c] + " ";
			}
			answer += "\n";
		}
		return answer;
	} */
	
	
	//testing
	public static void main(String[]args){
		USACO x = new USACO();
		System.out.println(x.bronze("infile1.txt"));
	}
	
}
