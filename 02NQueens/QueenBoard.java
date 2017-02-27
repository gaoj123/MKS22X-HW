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
    public int getSize(){
	return board.length;
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
    public void reset(){
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		board[i][j]=0;
	    }
	}
    }
    public void solve(){
	solveH(0);
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
	    reset();
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
	    reset();
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
	if(solved){
	    if(oneAtLeast){
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
	    else{
		return "";
	    }
	}
	else{
	    return "";
	}
    }
    public static void main(String[] args){
	// QueenBoard one=new QueenBoard(1);
	//QueenBoard two=new QueenBoard(2);
	// QueenBoard three=new QueenBoard(3);
	// QueenBoard four=new QueenBoard(4);
	//QueenBoard five=new QueenBoard(5);
	// QueenBoard six=new QueenBoard(6);
	// QueenBoard seven=new QueenBoard(7);
	// QueenBoard eight=new QueenBoard(8);
	// QueenBoard nine=new QueenBoard(9);
	// QueenBoard ten=new QueenBoard(10);
	
	//-----------------------------------------
	//Test Cases for Count
	
	// one.countSolutions();
	// System.out.println(one.getCount());

	//two.countSolutions();
	//System.out.println(two.getCount());

	// three.countSolutions();
	// System.out.println(three.getCount());

	// four.countSolutions();
	// System.out.println(four.getCount());

	// five.countSolutions();
	// System.out.println(five.getCount());

	// six.countSolutions();
	// System.out.println(six.getCount());

	// seven.countSolutions();
	// System.out.println(seven.getCount());

	// eight.countSolutions();
	// System.out.println(eight.getCount());

	// nine.countSolutions();
	// System.out.println(nine.getCount());

	// ten.countSolutions();
	// System.out.println(ten.getCount());
	//---------------------------------------------------

	
	//----------------------------------------------------
	//Test Cases for Printing Board
	// one.solve();
	// System.out.println(one);
	//two.solve();
	//System.out.println(two);
	// three.solve();
	// System.out.println(three);
	// four.solve();
	// System.out.println(four);
	//five.solve();
	//System.out.println(five);
	// six.solve();
	// System.out.println(six);
	// seven.solve();
	// System.out.println(seven);
	// eight.solve();
	// System.out.println(eight);
	// nine.solve();
	// System.out.println(nine);
	// ten.solve();
	// System.out.println(ten);
	//--------------------------------------------------------
    }
}
