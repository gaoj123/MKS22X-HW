import java.util.*;
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
    public boolean notEnded(Frontier a){
	return a.size() > 0 && (a.peek().getRow() != board.getEnd().getRow() || a.peek().getCol() != board.getEnd().getCol());
    }
    public void solve(int style){
	Frontier locations;
	if(style==0){
	    locations=new FrontierStack();
	}
	else if(style==1){
	    locations=new FrontierQueue();
	}
	else if(style==2){
	    locations=new FrontierPriorityQueue();
	}
	else{
	    locations=new FrontierPriorityQueue();
	    board.getStart().setAStar(true);
	}
	locations.add(board.getStart());
	board.set(board.getStart().getRow(),board.getStart().getCol(),'S');
        board.set(board.getEnd().getRow(), board.getEnd().getCol(), 'E');
        if (style == 0){
            while (notEnded(locations)){
                System.out.println(toString());
                Location current =locations.next();
                ArrayList<Location> n = paths(current);
                for (int i = 0; i < n.size(); i ++){
                    locations.add(n.get(i));
                }
                if (n.size() == 0){
                    while ((locations.size() == 0 && current != board.getStart()) || (locations.size() > 0 && locations.peek().getPrev() != current)){
                        board.set(current.getRow(), current.getCol(), '.');
                        current = current.getPrev();
                    }
                }
            }
        }
        else if (style == 1){
            while (notEnded(locations)){
                System.out.println(toString());
                Location current = locations.next();
                ArrayList<Location> n = paths(current);
                for (int i = 0; i < n.size(); i ++){
                    locations.add(n.get(i));
                }
                if (n.size() == 0){
                    while (current != board.getStart() && numWalls(current) > 2){
                        board.set(current.getRow(), current.getCol(), '.');
                        current = current.getPrev();
                    }
                }
            }
            while (locations.size() > 0){
                Location now = locations.next();
                while (now != board.getStart() && !(now.getRow() == board.getEnd().getRow() && now.getCol() == board.getEnd().getCol()) && numWalls(now) > 2){
                    board.set(now.getRow(), now.getCol(), '.');
                    now = now.getPrev();
                }
                System.out.println();
            }
        }
        else if (style == 2){
            while (locations.size() > 0 && (locations.peek().getRow() != board.getEnd().getRow() || locations.peek().getCol() != board.getEnd().getCol())){
                System.out.println(toString());
                Location now = locations.next();
                ArrayList<Location> cases = paths(now);
                for (int i = 0; i < cases.size(); i ++){
                    locations.add(cases.get(i));
                }
                if (cases.size() == 0){
                    while (now != board.getStart() && numWalls(now) > 2){
                        board.set(now.getRow(), now.getCol(), '.');
                        now = now.getPrev();
                    }
                }
            }
        }
        else if (style == 3){
            while (locations.size() > 0 && (locations.peek().getRow() != board.getEnd().getRow() || locations.peek().getCol() != board.getEnd().getCol())){
                System.out.println(toString());
                Location current = locations.next();
                ArrayList<Location> n = paths(current);
                for (int i = 0; i < n.size(); i ++){
                    locations.add(n.get(i));
                }
                if (n.size() == 0){
                    while (current != board.getStart() && numWalls(current) > 2){
                        board.set(current.getRow(), current.getCol(), '.');
                        current = current.getPrev();
                    }
                }
            }
        }
        board.set(board.getEnd().getRow(), board.getEnd().getCol(), 'E');
        System.out.println(toString());
    }
    private ArrayList<Location> paths(Location loc){
	int[][]x={{1,0},{-1,0},{0,1},{0,-1}};
        if (loc != board.getStart()){
	    board.set(loc.getRow(), loc.getCol(), '@');
	}
        ArrayList<Location> cases = new ArrayList<Location>();
	for(int i=0;i<4;i++){
	    if (board.get(loc.getRow() + x[i][0], loc.getCol()+x[i][1]) == ' ' || board.get(loc.getRow() + x[i][0], loc.getCol()+x[i][1]) == 'E'){
		cases.add(new Location(loc.getRow() + x[i][0], loc.getCol()+x[i][1], loc, loc.getDist() + 1, distToEnd(loc.getRow() + x[i][0], loc.getCol()+x[i][1]), loc.getAStar()));
		board.set(loc.getRow() + x[i][0], loc.getCol()+x[i][1], '?');
	    }
	}
        return cases;
    }
    private int distToEnd(int row, int col){
        return Math.abs(row - board.getEnd().getRow()) + Math.abs(col - board.getEnd().getCol());
    }
    private int numWalls(Location loc){
        int count = 0;
	int[][]x={{1,0},{-1,0},{0,1},{0,-1}};
	for(int i=0;i<4;i++){
	    if (board.get(loc.getRow() +x[i][0], loc.getCol()+x[i][1]) == '#' || board.get(loc.getRow() + x[i][0], loc.getCol()) == '.' || board.get(loc.getRow() + x[i][0], loc.getCol()+x[i][1]) == ' '){
		count++;
	    }
	}
        return count;
    }
    public String toString(){
	if(color){
	    return board.toString(10);
	}
	return board.toString();
    }
	public String toString(int num){
		return board.toString(num);
	}
    public static void main(String[] args){
	MazeSolver m = new MazeSolver("data5.dat", true);
        m.solve(3);
    }
}
