public class MyLinkedList{
    LNode start;
    int size;
    public MyLinkedList(){
	size=0;
	start=null;
    }
    public int get(int index){
	LNode current=start;
	int toRet=0;
	for(int i=0;i<size();i++){
	    if(index==i){
		toRet=current.val;
	    }
	    else{
		current=current.next;
	    }
	}
	return toRet;
    }
    public int set(int index, int newValue){
	int oldVal=0;
	LNode current=start;
	for(int i=0;i<size();i++){
	    if(index==i){
		oldVal=current.val;
		current.val=newValue;
	    }
	    else{
		current=current.next;
	    }
	}
	return oldVal;
    }
    //first try adding to the front
    public boolean add(int value){
	if(size()==0){
	    LNode newNode=new LNode(value);
	    start=newNode;
	}
	//--------Adds to Front------------
	// LNode newNode=new LNode(value,start);
	// start=newNode;
	// size++;
	// return true;
	//---------------------------------
	else{
	    LNode newNode=new LNode(value);
	    LNode current=start;
	    for(int i=0;i<size();i++){
		if(i==size()-1){ //last link
		    current.next=newNode;
		}
		else{
		    current=current.next;
		}
	    }
	}
	size++;
	return true;
    }
    public int size(){
	return size;
    }
    public int indexOf(int value){
	int indToRet=-1;
	LNode current=start;
	int i=0;
	while(i<size()){
	    if(current.val==value){
		indToRet=i;
		i=size()+2;
	    }
	    else{
		current=current.next;
	    }
	    i++;
	}
	// for(int i=0;i<size();i++){
	//     if(current.val==value){
	// 	indToRet=i;
	//     }
	//     else{
	// 	current=current.next;
	//     }
	// }
	return indToRet;
    }
    public void add(int index, int value){
    }
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
	c.add(10);
	System.out.println(c);
	//System.out.println(c.get(0));
	//c.set(2,30);
	System.out.println(c.indexOf(10));
    }
}
