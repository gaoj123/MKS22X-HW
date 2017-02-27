import java.util.*;
public class KnightBoard{
    private int[][] board;
    private int[] x={1,1,-1,-1,2,2,-2,-2};
    private int[] y={2,-2,2,-2,1,-1,-1,1};
    public KnightBoard(int startingRows, int startingCols){
	board=new int[startingRows][startingCols];
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board[0].length;j++){
		board[i][j]=0;
	    }
	}
    }
    public boolean isOnGoodSpot(int r,int c){
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
    public void solveFast(){
	solveFastH(0,0,1);
    }
    private int countMoves(int row2, int col2){
    	int moves=0;
    	for(int i=0;i<8;i++){
    	    if(isOnGoodSpot(row2+x[i],col2+y[i])){
    		moves+=1;
    	    }
    	}
    	return moves;
    }
    private boolean solveFastH(int row,int col,int level){
	board[row][col]=level;
    	if(level==board.length*board[0].length){
    	    return true;
    	}
	ArrayList<Integer> moves=new ArrayList<Integer>();
	ArrayList<Integer> movesCopy=new ArrayList<Integer>();
	for(int i=0;i<8;i++){
	    int movesCounted=countMoves(row+x[i],col+y[i]);
	    moves.add(movesCounted);
	    movesCopy.add(movesCounted);
	}
	Collections.sort(moves);
	ArrayList<Integer> sortedIndex=new ArrayList<Integer>();
	for(int i=0;i<8;i++){
	    int indexx=movesCopy.indexOf(moves.get(i));
	    sortedIndex.add(indexx);			
	    movesCopy.set(indexx,-1);
	}
	for(int i=0;i<8;i++){
	    int rowColIndex=sortedIndex.get(i);
	    if(isOnGoodSpot(row+x[rowColIndex],col+y[rowColIndex])&&solveFastH(row+x[rowColIndex],col+y[rowColIndex],level+1)){
		return true;
	    }
	}
	board[row][col]=0;
	return false;
    }
    public static void sort2d(int[][] array){
    	Arrays.sort(array, new Comparator<int[]>() {
    		@Override
    		public int compare(final int[] a1, final int[] b1) {
    		    return Integer.compare(a1[0],b1[0]);
    		}
    	    });
    }
    public String toString(){
	String toRet="";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board[0].length;j++){
		if(board[i][j]<10){
		    toRet+="    "+board[i][j]+" ";
		}
		else if(!(board[i][j]<10)&&board[i][j]<100){
		    toRet+="   "+board[i][j]+" ";
		}
		else if(!(board[i][j]<100)&&board[i][j]<1000){
		    toRet+="  "+board[i][j]+" ";
		}
		else if(!(board[i][j]<1000)&&board[i][j]<10000){
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
	KnightBoard test=new KnightBoard(16,16);
	test.solveFast();
	System.out.println(test);
	KnightBoard test2=new KnightBoard(7,7);
	test2.solve();
	System.out.println(test2);
    }
}
