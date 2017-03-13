import java.util.*;
import java.io.*;

public class USACO{
    public static String name(){
	return "Gao,Jenny";
    }
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
    public static int silver(String filename){
	Scanner lineNum=null;
	Scanner inf=null;
	int count=0;
	try{
	    File infile=new File(filename);
	    lineNum=new Scanner(infile);
	    //inf=new Scanner(infile);
	}
	catch (FileNotFoundException e) {
	    System.out.println("File not found!");
	    System.exit(0);
	}
	Scanner firstLine=new Scanner(lineNum.nextLine());
	int rows=Integer.parseInt(firstLine.next());
	int cols=Integer.parseInt(firstLine.next());
	int time=Integer.parseInt(firstLine.next());
	System.out.println(rows);
	System.out.println(cols);
	System.out.println(time);
	int[][][] board=new int[rows][cols][2];
	for(int i=0;i<rows;i++){
	    String lineOn=lineNum.next();
	    for(int j=0;j<cols;j++){
		if(lineOn.substring(j,j+1).equals("*")){
		    board[i][j][1]=-1;
		}
		else{
		    board[i][j][1]=0;
		}
	    }
	}
	int startR=lineNum.nextInt();
	int startC=lineNum.nextInt();
	int endR=lineNum.nextInt();
	int endC=lineNum.nextInt();
	return solveH(board,startR,startC,endR,endC,time,rows,cols);
    }
    public static int solveH(int[][][] pasture, int rStart, int cStart, int rEnd, int cEnd, int timee, int rowsS,int colsS){
	pasture[rStart-1][cStart-1][1]=1;
	for(int stepNow=0;stepNow<timee;stepNow++){
		for(int r=0;r<pasture.length;r++){
		    for(int c=0;c<pasture[0].length;c++){
			if(pasture[r][c][1]!=-1){
			    if(isOnBoard(rowsS,colsS,r-1,c)){
				if(pasture[r-1][c][1]!=-1){ //top
				    pasture[r][c][0]+=pasture[r-1][c][1];
				}
			    }
			    if(isOnBoard(rowsS,colsS,r+1,c)){
				if(pasture[r+1][c][1]!=-1){ //bottom
				    pasture[r][c][0]+=pasture[r+1][c][1];
				}
			    }
			    if(isOnBoard(rowsS,colsS,r,c-1)){
				if(pasture[r][c-1][1]!=-1){//left
				    pasture[r][c][0]+=pasture[r][c-1][1];
				}
			    }
			    if(isOnBoard(rowsS,colsS,r,c+1)){
				if(pasture[r][c+1][1]!=-1){//right
				    pasture[r][c][0]+=pasture[r][c+1][1];
				}
			    }
			}
			else{
			    pasture[r][c][0]=-1;
			}
		    }
		}
		for(int i=0;i<pasture.length;i++){
		    for(int j=0;j<pasture[0].length;j++){
			pasture[i][j][1]=pasture[i][j][0];
			pasture[i][j][0]=0;
		    }

		}
	}
	return pasture[rEnd-1][cEnd-1][1];
    }
    public static boolean isOnBoard(int rowss, int cowss, int r, int c){
    	return ((r>=0&&r<rowss)&&(c>=0&&c<cowss));
    }
    //testing
    public static void main(String[]args){
	//USACO x = new USACO();
	//System.out.println(x.silver("file4.txt"));
	// System.out.println(x.bronze("infile2.txt"));
	// System.out.println(x.bronze("infile3.txt"));
	// System.out.println(x.bronze("infile4.txt"));
	// System.out.println(x.bronze("infile5.txt"));
	// System.out.println(x.bronze("infile10.txt"));
    }
	
}
