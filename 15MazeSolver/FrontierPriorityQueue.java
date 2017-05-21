import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private MyHeap heap;
    public FrontierPriorityQueue(){
	heap=new MyHeap();
    }
    public Location peek(){
	return heap.peek();
    }
    public void add(Location loc){
	heap.add(loc);
    }
    public Location next(){
	Location toRet=heap.remove();
	return toRet;
    }
    public boolean hasNext(){
	boolean x=heap.peek()==null;
	return !x;
    }
}
