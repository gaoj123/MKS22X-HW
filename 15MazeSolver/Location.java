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
    public compareTo(Location other){
	if(aStar){
	}
    }
}
