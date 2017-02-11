public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    public QueenBoard(int size){
	board = new int[size][size];
	for(int i=0;i<size;i++){
	    for(int j=0;j<size;j++){
		board[i][j]=0;
	    }
	}
    }
    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	int r=0;
	while(r<board.length){
	    if(board[r][col]==0){
		addQueen(r,col);
		if(col+1>board.length-1){
		    return true;
		}
		else{
		    System.out.println(col+1);
		    return solveH(col+1);
		}
	    }
	    else if(board[r][col]>=1){
		if(r==board.length-1){
		    if(col==0){
			System.out.println("a");
			return false;
		    }
		    else{
			System.out.println("go back");
			return solveH(col-1);
		    }
		}
		else{
		    System.out.println("down");
		    r+=1;
		}
	    }
	    else if(board[r][col]==-1){
		System.out.println("entered");
		if(r==board.length-1){
		    System.out.println("b");
		    if(col!=0){
			removeQueen(r,col);
			return solveH(col-1);
		    }
		    else{
			return false;
		    }
		}
		else{
		    removeQueen(r,col);
		    r+=1;
		}
	    }
	}
	System.out.println("end");
	return false;
    }
    public void addQueen(int row, int c){
	board[row][c]=-1;
	for(int i=0;i<board.length;i++){
	    if(i!=row){
		board[i][c]+=1;
	    }
	}
	for(int j=0;j<board.length;j++){
	    if(j!=c){
		board[row][j]+=1;
	    }
	}
	for(int k=1;(row+1*k)<board.length&&(c+1*k)<board.length;k++){
	    board[row+1*k][c+1*k]+=1;
	}
	for(int m=1;(row-1*m)>-1&&(c-1*m)>-1;m++){
	    board[row-1*m][c-1*m]+=1;
	}
	for(int n=1;(row-1*n)>-1&&(c+1*n)<board.length;n++){
	    board[row-1*n][c+1*n]+=1;
	}
	for(int p=1;(row+1*p)<board.length&&(c-1*p)>-1;p++){
	    board[row+1*p][c-1*p]+=1;
	}
    }
    public void removeQueen(int row, int c){
	board[row][c]=0;
	for(int i=0;i<board.length;i++){
	    if(i!=row){
		board[i][c]-=1;
	    }
	}
	for(int j=0;j<board.length;j++){
	    if(j!=c){
		board[row][j]-=1;
	    }
	}
	for(int k=1;(row+1*k)<board.length&&(c+1*k)<board.length;k++){
	    board[row+1*k][c+1*k]-=1;
	}
	for(int m=1;(row-1*m)>-1&&(c-1*m)>-1;m++){
	    board[row-1*m][c-1*m]-=1;
	}
	for(int n=1;(row-1*n)>-1&&(c+1*n)<board.length;n++){
	    board[row-1*n][c+1*n]-=1;
	}
	for(int p=1;(row+1*p)<board.length&&(c-1*p)>-1;p++){
	    board[row+1*p][c-1*p]-=1;
	}
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String retString="";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		if(board[i][j]==-1){
		    retString+="Q";
		}
		else{
		    retString+="_";
		}
	    }
	    retString+="\n";
	}		    
    	return retString;
    }
    public static void main(String[] args){
	QueenBoard test=new QueenBoard(6);
	System.out.println(test.solve());
	//test.solve();
	//System.out.println(test.solve());
	System.out.println(test);
    }
}
