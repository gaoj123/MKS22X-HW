import java.util.*;
import java.io.*;

public class Maze{
    public static String name(){
	return "Gao,Jenny";
    }
    private char[][]maze;
    private boolean animate;
    private int startR;
    private int startC;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	try{
	    File infile=new File(filename);
	    Scanner lineNum=new Scanner(infile);
	    int lineNumb=0;
	    int lineLen=0;
	    while(lineNum.hasNextLine()){
		String line=lineNum.nextLine();
		//System.out.println(line);
		lineLen=line.length();
		lineNumb+=1;
	    }
	    //System.out.println(lineLen);
	    // System.out.println(lineNumb);
	    maze =new char[lineNumb][lineLen];
	    int onLineNumber=0;
	    Scanner inf=new Scanner(infile);
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for(int i=0;i<line.length();i++){
		    if(line.substring(i,i+1).equals("S")){
			startC=i;
			startR=onLineNumber;
		    }
		    maze[onLineNumber][i]=line.charAt(0);
		}
		onLineNumber+=1; 
		//System.out.println(line);
	    }	
	}
	catch (FileNotFoundException e) {
	    System.out.println("File not found!");
	}
	// Scanner inf=new Scanner(infile);
	// int lineNumber = -1;
        // while(inf.hasNextLine()){
	//     lineNumber+=1;
        //     String line = inf.nextLine();
	//     for(int i=0;i<line.length();i++){
	// 	maze[lineNumber][i]=line.charAt(0);
	//     }
        //     //System.out.println(line);
        // }
	animate=false;
	//System.out.println(startR);
	//System.out.println(startC);
        //COMPLETE CONSTRUCTOR
    }
    private void wait(int millis){ //ADDED SORRY!
       try {
	   Thread.sleep(millis);
       }
       catch (InterruptedException e) {
       }
   }
    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
	    startr=startR;
	    startc=startC;
            //Initialize starting row and startint col with the location of the S. 

            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if(maze[row][col]=='E'){
	    System.out.println("solved");
	    return true;
	}
	if(maze[row][col]=='@'){
	    maze[row][col]='.';
	}
	if(notDeadEnd(row,col)){
	    maze[row][col]='@';
	    if(solve(row,col+1)){
		return true;
	    }
	    if(solve(row+1,col)){
		return true;
	    }
	    if(solve(row,col-1)){
		return true;
	    }
	    if(solve(row-1,col)){	
		return true;
	    }
	    // maze[row][col]=".";
	    // return false;
	}
	else{
	    String sideFree=sideOpen(row,col);
	    if(sideFree.equals("right")){
	        return solve(row,col+1);
	    }
	    if(sideFree.equals("left")){
		return solve(row,col-1);
	    }
	    if(sideFree.equals("up")){
		return solve(row-1,col);
	    }
	    if(sideFree.equals("down")){
		return solve(row+1,col);
	    }
	}
        //COMPLETE SOLVE

        return false; //so it compiles
    }
    public String sideOpen(int r,int c){
	if(maze[r][c+1]==' '||maze[r][c+1]=='@'){
	    return "right";
	}
	else if(maze[r][c-1]==' '||maze[r][c-1]=='@'){
	    return "left";
	}
	else if(maze[r+1][c]==' '||maze[r+1][c]=='@'){
	    return "down";
	}
	else{
	    return "up";
	}
    }
    public boolean notDeadEnd(int r, int c){
	int sidesBlocked=0;
	if(maze[r][c+1]=='#'||maze[r][c+1]=='@'){
	    sidesBlocked+=1;
	}
	if(maze[r][c-1]=='#'||maze[r][c-1]=='@'){
	    sidesBlocked+=1;
	}
	if(maze[r+1][c]=='#'||maze[r+1][c]=='@'){
	    sidesBlocked+=1;
	}
	if(maze[r-1][c]=='#'||maze[r-1][c]=='@'){
	    sidesBlocked+=1;
	}
	if(sidesBlocked>=3){
	    return false;
	}
	return true;
    }
}
