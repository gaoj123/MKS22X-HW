public class KnightBoard{
    private int[][] board;
    private int[] x={1,1,-1,-1,2,2,-2,-2};
    private int [] y={2,-2,2,-2,1,-1,-1,1};
    public KnightBoard(int startingRows, int startingCols){
	board=new int[startingRows][startingCols];
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board[0].length;j++){
		board[i][j]=0;
	    }
	}
    }
    public boolean isOnGoodSpot(int r,int c){
	//return (r<board.length&&r>=0)&&(c<board[0].length&&c>=0);
	if((r<board.length&&r>=0)&&(c<board[0].length&&c>=0)){
	    return board[r][c]==0;
	}
	else{
	    return false;
	}
    }
    public void solve(){
	solveH(0,0,1);
    }
    private boolean solveH(int row,int col,int level){
	if(level>board.length*board[0].length){
	    return true;
	}
	else{
	    if(isOnGoodSpot(row,col)){
		board[row][col]=level;
		for(int i=0;i<8;i++){
		    if(solveH(row+x[i],col+y[i],level+1)){
			return true;
		    }
		}
		board[row][col]=0;
		return false;
	    }
	    else{
		return false;
	    }
	}
    }
    public String toString(){
	String toRet="";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board[0].length;j++){
		if(board[i][j]<10){
		    toRet+=" "+board[i][j]+" ";
		}
		else{
		    toRet+=""+board[i][j]+" ";
		}
	    }
	    toRet+="\n";
	}
	return toRet;
    }
    public static void main(String[] args){
	// KnightBoard test=new KnightBoard(7,5);
	// test.solve();
	// System.out.println(test);
    }
}
