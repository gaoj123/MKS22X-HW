import java.util.*;
import java.io.*;

public class USACO{
    //Partner: William Hong
    
    public USACO(){}

    public static int bronze(String filename){
	Scanner scan=null;
	try{
	    scan = new Scanner(new File(filename));
	}
	catch(FileNotFoundException e){	
	    System.out.println("Error! File not found");
	    System.exit(1);
	}			
	int answer = 0;
	//Line 1 specifies R, C, E, N
	Scanner firstLine = new Scanner(scan.nextLine());
	int row = Integer.parseInt(firstLine.next());
	int col = Integer.parseInt(firstLine.next());
	int elevationFinal = Integer.parseInt(firstLine.next());
	int numDig = Integer.parseInt(firstLine.next());
	// System.out.println(row);
	// System.out.println(col);
	// System.out.println(elevationFinal);
	// System.out.println(numDig);
	//Lines 2 to R+1
	int[][] lake = new int[row][col];
	for (int r=0; r < row; r++){
	    for (int c=0; c < col; c++){
		lake[r][c] = Integer.parseInt(scan.next());
		//System.out.println(lake[r][c]);
	    }
	}

	//Retreiving digging instructions
	//digging is the array that stores the instructions
	for(int i=0;i<numDig;i++){
	    int a=scan.nextInt();
	    int b=scan.nextInt();
	    int c=scan.nextInt();
	    stomp(lake,a-1,b-1,c);
	}
	// int[][] digging = new int[numDig][3];
	// int line=0;
	// while (line < numDig){
	//     //this is the line with commands (ex: 1 4 4)
	//     Scanner sequence = new Scanner(scan.nextLine());
				
	//     //these are the individuals ints in the command (ex: 1)
	//     digging[line][0] = Integer.parseInt(sequence.next());
	//     digging[line][1] = Integer.parseInt(sequence.next());
	//     digging[line][2] = Integer.parseInt(sequence.next());
					
	//     line += 1;
	// }
		
	// //note: there are possible restrictions... some squares cannot
	// //have a 3x3 grid possible (uppermost left corner)
	// //the section below executes the digging instructions 
			
	// int execute=0;
	// while (execute < numDig){
	//     int R_s = digging[execute][0], C_s = digging[execute][1], D_s = digging[execute][2];
	//     //making a new array to store the 3x3 grid
	//     int[][] cows = new int[3][3];
	//     int i=0;
	//     cows[0][0] = lake[R_s][C_s];
	//     cows[0][1] = lake[R_s][C_s+1];
	//     cows[0][2] = lake[R_s][C_s+2];
				
	//     cows[1][0] = lake[R_s+1][C_s];
	//     cows[1][1] = lake[R_s+1][C_s+1];
	//     cows[1][2] = lake[R_s+1][C_s+2];
				
	//     cows[2][0] = lake[R_s+1][C_s];
	//     cows[2][1] = lake[R_s+1][C_s+1];
	//     cows[2][2] = lake[R_s+1][C_s+2];
				
	//     //find initial max elevation first to stomp down 
	//     //find min elevation for later steps
	//     int maxElev = cows[0][0], minElev = cows[0][0];
	//     for (int r=0; r < 3; r++){
	// 	for (int c=0; c < 3; c++){
	// 	    if (cows[r][c] > maxElev){
	// 		maxElev = cows[r][c]; }
	// 	    if (cows[r][c] < minElev){
	// 		minElev = cows[r][c]; }
	// 	}
	//     }
				
	//     //commence the stomping for highest squares first
	//     for (int r=0; r < 3; r++){
	// 	for (int c=0; c < 3; c++){
	// 	    if (cows[r][c] == maxElev){
	// 		cows[r][c] -= D_s; }
	// 	}
	//     }
				

	//     //match the other ones to stomp down
	//     maxElev -= D_s;
	//     for (int r=0; r < 3; r++){ 
	// 	for (int c=0; c < 3; c++){
	// 	    if (cows[r][c] > maxElev){
	// 		cows[r][c] = maxElev; }
	// 	}
	//     }


	//     //going back to the original lake
	//     lake[R_s][C_s] = cows[0][0];
	//     lake[R_s][C_s+1] = cows[0][1];
	//     lake[R_s][C_s+2] = cows[0][2];
				
	//     lake[R_s+1][C_s] = cows[1][0];
	//     lake[R_s+1][C_s+1] = cows[1][1];
	//     lake[R_s+1][C_s+2] = cows[1][2];
				
	//     lake[R_s+1][C_s] = cows[2][0];
	//     lake[R_s+1][C_s+1] = cows[2][1];
	//     lake[R_s+1][C_s+2] = cows[2][2];
				
	//     execute += 1;
	// }

	//accounting for final elevation
	int totalDepth=0;
	for (int r=0; r < lake.length; r++){
	    for (int c=0; c < lake[0].length; c++){
		if(elevationFinal>lake[r][c]){
		    lake[r][c]=elevationFinal-lake[r][c];
		}
		else{
		    lake[r][c]=0;
		}
		totalDepth+=lake[r][c];
		// if (lake[r][c] - elevationFinal > 0){
		//     lake[r][c] = 0; }
		// else{
		//     lake[r][c] = Math.abs(lake[r][c] - elevationFinal); }
	    }
	}

	//final step: finding the sum
	// int totalDepth = 0;
	// for (int r=0; r < lake.length; r++){
	//     for (int c=0; c < lake[0].length; c++){
	// 	totalDepth += lake[r][c]; }
	// }

	answer = 5184 * totalDepth;  
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
	
    public static void stomp(int[][] field,int rowCor,int colCor, int stomping){
	int max=field[rowCor][colCor];
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		if(field[rowCor+i][colCor+j]>max){
		    max=field[rowCor+i][colCor+j];
		}
	    }
	}
	int finalDep=max-stomping;
	//set all others to this finalDep
        for(int i =rowCor; i<field.length && i <rowCor+3;i++){
	    for(int j=colCor; j<field[0].length && j<colCor +3;j++){
		if(field[i][j] > finalDep){
			field[i][j] = finalDep;
		}
	    }
	}

    }
	//testing
	public static void main(String[]args){
		// USACO x = new USACO();
		// System.out.println(x.bronze("infile2.txt"));
		// System.out.println(x.bronze("infile3.txt"));
		// System.out.println(x.bronze("infile4.txt"));
		// System.out.println(x.bronze("infile5.txt"));
		// System.out.println(x.bronze("infile10.txt"));
	}
	
}
