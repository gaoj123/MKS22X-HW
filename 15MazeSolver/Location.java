public class Location implements Comparable<Location>{
    private int row,col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;
    public Location(int r,int c,Location previous,int distToStart, int distToGoal,boolean aStar){
	row=r;
	col=c;
	this.previous=previous;
	this.aStar=aStar;
	this.distToStart=distToStart;
	this.distToGoal=distToGoal;

    }
    public int compareTo(Location other){
	if(aStar){
	    int mine=this.distToGoal+this.distToStart;
	    int otherr=other.distToGoal+other.distToStart;
	    if(mine<otherr){
		return -1;
	    }
	    else if(mine==otherr){
		return 0;
	    }
	    else{
		return 1;
	    }
	}
	else{
	    int mine=this.distToGoal;
	    int otherr=other.distToGoal;
	    if(mine<otherr){
		return -1;
	    }
	    else if(mine==otherr){
		return 0;
	    }
	    else{
		return 1;
	    }
	}
    }
}
