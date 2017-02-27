public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
        f.clearTerminal();
        f.setAnimate(true);
        f.solve();

        f.clearTerminal();
        System.out.println(f);
    }
}
