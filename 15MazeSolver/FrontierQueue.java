import java.util.*;
public class FrontierQueue implements Frontier{
    LinkedList<Location> locations=new LinkedList<Location>();
    public FrontierQueue(){
    }
    public Location peek(){
	return locations.peek();
    }
    public void add(Location loc){
	locations.add(loc);
    }
    public Location next(){
	Location toRet=locations.remove();
	return toRet;	
    }
    public boolean hasNext(){
	boolean x=locations.peek()==null;
	return !x;
    }
    public int size(){
	return locations.size();
    }
}
