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
	//Lines 2 to R+1
	int[][] lake = new int[row][col];
	for (int r=0; r < row; r++){
	    for (int c=0; c < col; c++){
		lake[r][c] = Integer.parseInt(scan.next());
	    }
	}

	//digging instructions
	for(int i=0;i<numDig;i++){
	    int a=scan.nextInt();
	    int b=scan.nextInt();
	    int c=scan.nextInt();
	    stomp(lake,a-1,b-1,c);
	}
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
	    }
	}

	//final step: finding the sum
	answer = 5184 * totalDepth;  
	return answer;
    }		
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
