public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private boolean solved;
    private boolean oneAtLeast;
    public QueenBoard(int size){
	board = new int[size][size];
	for(int i=0;i<size;i++){
	    for(int j=0;j<size;j++){
		board[i][j]=0;
	    }
	}
	solutionCount=0;
	solved=false;
	oneAtLeast=false;
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
    public void solve(){
	solveH(0);
	// if(solveH(0)){
	//     System.out.println(this);
	// }
    }
    
    public void countSolutions(){
	solveH(0);
	if(solved&&oneAtLeast){
	    solutionCount+=1;
	}
	boolean notDone=true;
	while(notDone){
	    if(solveH(board.length-1)&&queensPlaced()==board.length){
		solutionCount+=1;
	    }
	    else{
		notDone=false;
	    }
	}
    }
    
    public int getCount(){
	if(solved){
	    return solutionCount;
	}
	else{
	    return -1;
	}
    }
    
    private int queensPlaced(){
	int toRet=0;
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		if(board[i][j]==-1){
		    toRet+=1;
		}
	    }
	}
	return toRet;
    }
    
    private boolean solveH(int col){
	solved=true;
	int r=0;
	while(r<board.length){
	    if(board[r][col]==0){
		addQueen(r,col);
		if(col+1>board.length-1){
		    if(queensPlaced()==board.length){
			oneAtLeast=true;
		    }
		    //solutionCount+=1;
		    return true;
		}
		else{
		    return solveH(col+1);
		}
	    }
	    else if(board[r][col]>=1){
		if(r==board.length-1){
		    if(col==0){
			return false;
		    }
		    else{
			return solveH(col-1);
		    }
		}
		else{
		    r+=1;
		}
	    }
	    else if(board[r][col]==-1){
		if(r==board.length-1){
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
	if(solved){
	    return solutionCount;
	}
	else{
	    return -1;
	}
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
    // public String toString(){
    // 	String retString="";
    // 	if(this.solve()){
    // 	    for(int i=0;i<board.length;i++){
    // 		for(int j=0;j<board.length;j++){
    // 		    if(board[i][j]==-1){
    // 			retString+="Q";
    // 		    }
    // 		    else{
    // 			retString+="_";
    // 		    }
    // 		}
    // 		retString+="\n";
    // 	    }		    
    // 	    return retString;
    // 	}
    // 	else{
    // 	    for(int i=0;i<board.length;i++){
    // 		for(int j=0;j<board.length;j++){
    // 		    retString+="_";
    // 		}
    // 		retString+="\n";
    // 	    }		    
    // 	    return retString;
    // 	}
    // }
    public static void main(String[] args){
	//Note: solve() prints the board with Qs and _s
	// QueenBoard test=new QueenBoard(4);
	// test.solve();
	// System.out.println(test);
	// test.countSolutions();
	// System.out.println(test.getCount());
	// System.out.println(test.getSolutionCount());
	// QueenBoard test2=new QueenBoard(4);
	// test2.solve();
	// System.out.println(test2);
	// test2.countSolutions();
	// System.out.println(test2.getCount());
	// System.out.println(test2.getSolutionCount());
	// System.out.println("\n\n");
	QueenBoard one=new QueenBoard(1);
	//one.solve();
	//System.out.println(one);
         one.countSolutions();
	System.out.println(one.getCount());
	// System.out.println("\n\n");
	QueenBoard two=new QueenBoard(2);
	//two.solve();
	//System.out.println(two);
         two.countSolutions();
	System.out.println(two.getCount());
	// System.out.println("\n\n");
	QueenBoard three=new QueenBoard(3);
	//three.solve();
	//System.out.println(three);
         three.countSolutions();
	System.out.println(three.getCount());
	// System.out.println("\n\n");
	 QueenBoard four=new QueenBoard(4);
	// four.solve();
        four.countSolutions();
	System.out.println(four.getCount());
	// System.out.println("\n\n");
	QueenBoard five=new QueenBoard(5);
	// five.solve();
        five.countSolutions();
	System.out.println(five.getCount());
	// System.out.println("\n\n");
	QueenBoard six=new QueenBoard(6);
	// six.solve();
        six.countSolutions();
	System.out.println(six.getCount());
	// System.out.println("\n\n");
        QueenBoard seven=new QueenBoard(7);
	// seven.solve();
        seven.countSolutions();
	 System.out.println(seven.getCount());
	// System.out.println("\n\n");
	 QueenBoard eight=new QueenBoard(8);
	 //eight.solve();
	 // System.out.println(eight);
         eight.countSolutions();
	 System.out.println(eight.getCount());
	// System.out.println("\n\n");
	QueenBoard nine=new QueenBoard(9);
	// nine.solve();
        nine.countSolutions();
	System.out.println(nine.getCount());
	// System.out.println("\n\n");
	QueenBoard ten=new QueenBoard(10);
	//ten.solve();
	//System.out.println(ten);
	ten.countSolutions();
	System.out.println(ten.getCount());
	System.out.println("\n\n");
	// System.out.println(one.getCount());
	// System.out.println(two.getCount());
	// System.out.println(three.getCount());
	// System.out.println(four.getCount());
	// System.out.println(five.getCount());
	// System.out.println(six.getCount());
	// System.out.println(seven.getCount());
	// System.out.println(eight.getCount());
	// System.out.println(nine.getCount());
	//System.out.println(ten.getCount());
    }
}
