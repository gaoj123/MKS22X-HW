public class MazeSolver{
    private Maze board;
    private boolean color;
    public MazeSolver(String filename){
	this(filename,false);
    }
    public MazeSolver(String filename, boolean animate){
	board=new Maze(filename);
	color=animate;
    }
    public void solve(){
	solve(1);
    }
    public void solve(int style){
    }
    public String toString(){
	if(color){
	    return toString(500);
	}
	return board.toString();
    }
}
