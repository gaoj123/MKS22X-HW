public class MyLinkedList{
    LNode start;
    int size;
    public MyLinkedList(){
	size=0;
	start=null;
    }
    //first try adding to the front
    public boolean add(int value){
	LNode newNode=new LNode(value,start);
	start=newNode;
	size++;
	return true;
    }
    private class LNode{
	private int val;
	private LNode next;
	public LNode(int value){
	    val=value;
	}
	public LNode(int value, LNode nex){
	    val=value;
	    next=nex;
	}
    }
    public String toString(){
	String toRet="[";
	LNode current=start;
	for(int i=0;i<size;i++){
	    toRet+=current.val;
	    if(i!=size-1){
		toRet+=",";
	    }
	    current=current.next;
	}
	toRet+="]";
	return toRet;
    }
    public static void main(String[] args){
	MyLinkedList c=new MyLinkedList();
	c.add(5);
	c.add(4);
	c.add(6);
	System.out.println(c);
    }
}
