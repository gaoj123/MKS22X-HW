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
    private boolean noS;
    private boolean noE;

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
	noE=true;
	noS=true;
	try{
	    File infile=new File(filename);
	    Scanner lineNum=new Scanner(infile);
	    int lineNumb=0;
	    int lineLen=0;
	    while(lineNum.hasNextLine()){
		String line=lineNum.nextLine();
		lineLen=line.length();
		lineNumb+=1;
	    }
	    maze =new char[lineNumb][lineLen];
	    int onLineNumber=0;
	    Scanner inf=new Scanner(infile);
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for(int i=0;i<line.length();i++){
		    if(line.substring(i,i+1).equals("E")){
			noE=false;
		    }
		    if(line.substring(i,i+1).equals("S")){
			noS=false;
			startC=i;
			startR=onLineNumber;
		    }
		    maze[onLineNumber][i]=line.charAt(i);
		}
		onLineNumber+=1; 
	    }	
	}
	catch (FileNotFoundException e) {
	    System.out.println("File not found!");
	    System.exit(0);
	}
	animate=false;
	if(noE){
	    System.out.println("There is no 'E' in the maze");
	    System.exit(0);
	}
	if(noS){
	    System.out.println("There is no 'S' in the maze");
	    System.exit(0);
	} 
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
            if(!solve(startr,startc)){
		System.out.println("No Solution\n");
		return false;
	    }
	    else{
		return true;
	    }
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
    	    return true;
    	}
    	if(maze[row][col]=='#'||maze[row][col]=='.'){
    	    return false;
    	}
    	else if(maze[row][col]==' '){
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
    	    maze[row][col]='.';
    	    return false;
    	}
    	return false;
	    
    }
    public String toString(){
	String retString="";
	for(int i=0;i<maze.length;i++){
	    for(int j=0;j<maze[0].length;j++){
		retString+=maze[i][j];
	    }
	    retString+="\n";
	}
	return retString;
    }
}
