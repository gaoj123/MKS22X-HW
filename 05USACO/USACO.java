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
	// while(lineNum.hasNextLine()){
	// 	String line=lineNum.nextLine();
	// 	if(line.length()==5){
	// 	    int rows=Integer.parseInt(line.substring(0,1));
	// 	    int cols=Integer.parseInt(line.substring(2,3));
	// 	    int time=Integer.parseInt(line.substring(4,5));
	// 	}
	// }
	//	char[][] maze =new char[rows][cols];
	int[][][] board=new int[rows][cols][2];
	//int onLineNumber=0;
	//Scanner inf=new Scanner(infile);
	// while(inf.hasNextLine()){
	// 	String line = inf.nextLine();
	// 	if(line.length()==7){
	// 	    int startR=Integer.parseInt(line.substring(0,1));
	// 	    int startC=Integer.parseInt(line.substring(2,3));
	// 	    int endR=Integer.parseInt(line.substring(4,5));
	// 	    int endC=Integer.parseInt(line.substring(6,7));
	// 	}
	// 	else{
	// 	    for(int i=0;i<line.length();i++){
	// 		maze[onLineNumber][i]=line.charAt(i);
	// 	    }
	// 	    onLineNumber+=1;
	// 	}
	// }
	// System.out.println(rows);
	// System.out.println(cols);
	for(int i=0;i<rows;i++){
	    String lineOn=lineNum.next();
	    for(int j=0;j<cols;j++){
		//Scanner onNow=new Scanner(lineNum.nextLine());
		// System.out.println(onNow);
		//String now=onNow.next();
		//System.out.println(now);
		//maze[i][j]=now.charAt(0);
		//System.out.println(lineNum.next());
		//String lineOn=lineNum.next();
		//System.out.println(lineOn.substring(j,j+1));
		if(lineOn.substring(j,j+1).equals("*")){
		    board[i][j][1]=-1;
		}
		else{
		    board[i][j][1]=0;
		}
	    }
	}
	//Scanner last=new Scanner(lineNum.nextLine());
	int startR=lineNum.nextInt();
	int startC=lineNum.nextInt();
	int endR=lineNum.nextInt();
	int endC=lineNum.nextInt();
	return solveH(board,startR,startC,endR,endC,time,rows,cols);
	    //solve();
	    //count=countSols();
	    //return count;
	// catch (FileNotFoundException e) {
	//     System.out.println("File not found!");
	//     System.exit(0);
	// }
    }
    public static int solveH(int[][][] pasture, int rStart, int cStart, int rEnd, int cEnd, int timee, int rowsS,int colsS){
	//	int[][] pastureCurrent=new int[pasture.length][pasture[0].length];
	// for(int i=0;i<pasture.length;i++){
	//     for(int j=0;j<pasture[0].length;j++){
	// 	pastureCurrent[i][j]=pasture[i][j];
	// 	System.out.print(pasture[i][j]);
	//     }
	//     System.out.println("\n");
	// }
	// pasture[rStart-1][cStart-1]=1;
	// pastureCurrent[rStart-1][cStart-1]=1;
	pasture[rStart-1][cStart-1][1]=1;
	for(int stepNow=0;stepNow<timee;stepNow++){
	    // for(int i=0;i<pasture.length;i++){
	    // 	for(int j=0;j<pasture[0].length;j++){
	    // 	    pastureCurrent[i][j]=pasture[i][j];
	    // 	    //System.out.print(pasture[i][j]);
	    // 	}
	    // 	//System.out.println("\n");
	    // }
	    // // int[][] pastureCurrent=new int[pasture.length][pasture[0].length];
	    // // for(int i=0;i<pasture.length;i++){
	    // // 	for(int j=0;j<pasture[0].length;j++){
	    // // 	    pastureCurrent[i][j]=pasture[i][j];
	    // // 	}
	    // // }
	     // if(stepNow==0){
	     // 	 pasture[rStart-1][cStart-1][0]=1;
	     // 	 pasture[rStart-1][cStart-1][1]=1;
	     // }
	    // // 	return pasture[rEnd-1][cEnd-1];
	    // // }
	    //else{
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
	//}
	return pasture[rEnd-1][cEnd-1][1];
    }
    // public boolean solve(){
    // 	int startr=-1,startc=-1;
    // 	startr=startR;
    // 	startc=startC;
    // 	//Initialize starting row and startint col with the location of the S. 

    // 	maze[startr][startc] = ' ';//erase the S, and start solving!
    // 	if(!solve(startr,startc,0)){
    // 	    System.out.println("No Solution\n");
    // 	    return false;
    // 	}
    // 	else{
    // 	    return true;
    // 	}
    // }
    public static boolean isOnBoard(int rowss, int cowss, int r, int c){
    	return ((r>=0&&r<rowss)&&(c>=0&&c<cowss));
    }
    // private boolean solve(int row, int col, int moves){
    // 	if(isOnBoard(row,col)){
    // 	    if(row==endR&&col==endC&&moves==time){
    // 		return true;
    // 	    }
    // 	    if(maze[row][col]=='*'||maze[row][col]=='!'){
    // 		return false;
    // 	    }
    // 	    else if(maze[row][col]=='.'){
    // 		maze[row][col]='@';
    // 		if(solve(row,col+1,moves+1)){
    // 		    return true;
    // 		}
    // 		if(solve(row+1,col,moves+1)){
    // 		    return true;
    // 		}
    // 		if(solve(row,col-1,moves+1)){
    // 		    return true;
    // 		}
    // 		if(solve(row-1,col,moves+1)){
    // 		    return true;
    // 		}
    // 		maze[row][col]='!';
    // 		return false;
    // 	    }
    // 	    return false;
    // 	}
    // 	return false;
	    
    // }
    // public int countSols(){
    // }
    //testing
    public static void main(String[]args){
	USACO x = new USACO();
	System.out.println(x.silver("file4.txt"));
	// System.out.println(x.bronze("infile2.txt"));
	// System.out.println(x.bronze("infile3.txt"));
	// System.out.println(x.bronze("infile4.txt"));
	// System.out.println(x.bronze("infile5.txt"));
	// System.out.println(x.bronze("infile10.txt"));
    }
	
}
