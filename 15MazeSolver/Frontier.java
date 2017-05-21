public interface Frontier{
    public boolean hasNext();
    public Location next();
    public void add(Location loc);
}
