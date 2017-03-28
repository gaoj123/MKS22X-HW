public class MyLinkedList{
    LNode start;
    int size;
    class LNode{
	int val;
	LNode next;
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
	while(current.next!=null){
	    toRet+=current.val;
	    toRet+=",";
	    current=current.next;
	}
	toRet+="]";
	return toRet;
    }
    public static void main(String[] args){
	LNode a=new LNode(5);
	LNode b=new LNode(3,a);
    }
}
