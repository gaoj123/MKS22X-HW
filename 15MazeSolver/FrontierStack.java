import java.util.*;
public class FrontierStack implements Frontier{
    Stack<Location> locations=new Stack<Location>();
    public FrontierStack(){
    }
    public Location peek(){
	return locations.peek();
    }
    public void add(Location loc){
	locations.push(loc);
    }
    public Location next(){
	Location toRet=locations.pop();
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
