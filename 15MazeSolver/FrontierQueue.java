public class FrontierQueue implements Frontier{
    LinkedList<Location> locations=new LinkedList<Location>();
    public void add(Location x){
	locations.add(x);
    }
    public Location next(){
    }
}
