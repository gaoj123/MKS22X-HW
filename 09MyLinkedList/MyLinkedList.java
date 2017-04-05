public class MyLinkedList{
    LNode start;
    LNode tail;
    int size;
    public MyLinkedList(){
	size=0;
	start=null;
    }
    public int get(int index){
	if(index<0||index>=size()){
	    throw new IndexOutOfBoundsException();
	}
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
	if(index<0||index>=size()){
	    throw new IndexOutOfBoundsException();
	}
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
		    newNode.prev=current;
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
    private void remove(LNode node){
	if(size()==1||start==tail){
	    //int toRet=-1;
	    //toRet=start.val;
	    start=null;
	    tail=null;
	    size--;
	    //return toRet;
	}
	//     //throw new IndexOutOfBoundsException();
	//     //try not to throw exception; instead, make it print "[]"?
	// }
	//int toRet=-1;
	//toRet=node.val;
	else if(node.prev==null){
	    start=node.next;
	    node.next.prev=null;
	}
	else if(node.next==null){
	    node.prev.next=null;
	    tail=node.prev;
	}
	else{
	    node.prev.next=node.next;
	    node.next.prev=node.prev;
	}
	size--;
	//return toRet;
    }
    public int remove(int index){
	if(index<0||index>=size()){
    	    throw new IndexOutOfBoundsException();
    	}
	if(size()==1||start==tail){
	    int toRet=-1;
	    toRet=start.val;
	    start=null;
	    tail=null;
	    size--;
	    return toRet;
	}
	else{
	    int toRet=-1;
	    toRet=getNthNode(index).val;
	    remove(getNthNode(index));
	    //toRet=remove(getNthNode(index));
	//size--;
	    return toRet;
	}
    	// if(index<0||index>=size()){
    	//     throw new IndexOutOfBoundsException();
    	// }
    	// int valRemoved=0;
    	// int i=0;
    	// LNode current=start;
    	// if(index==0){
    	//     valRemoved=current.val;
    	//     start=current.next;
    	// }
    	// else if(index==size()-1){
    	//     int j=0;
    	//     while(j<size()){
    	// 	if(j==size()-2){
    	// 	    LNode lookingAt=current;
    	// 	    LNode nextNode=current.next;
    	// 	    valRemoved=nextNode.val;
    	// 	    lookingAt.next=null;
    	// 	    j=size()+2;
    	// 	}
    	// 	else{
    	// 	    current=current.next;
    	// 	}
    	// 	j++;
    	//     }
    	// }
    	// else{
	//     //System.out.println("yes");
	//     remove(getNode(index));
    	//     // while(i<size()){
    	//     // 	if(i==index-1){
    	//     // 	    LNode prev=current;
    	//     // 	    LNode next=current.next;
    	//     // 	    valRemoved=next.val;
    	//     // 	    System.out.println("b");
    	//     // 	    prev.next=next.next;
    	//     // 	    i=size()+2;
    	//     // 	}
    	//     // }
    	// }
    	// size--;
    	// return valRemoved;
    }
    // public void remove(int index){
    // 	remove(getNode(index));
    // }
    private void addAfter(LNode location, LNode toBeAdded){
	if(location.next==null){
	    toBeAdded.next=null;
	    location.next=toBeAdded;
	    toBeAdded.prev=location;
	}
	else{
	    toBeAdded.next=location.next;
	    location.next=toBeAdded;
	    toBeAdded.prev=location;
	}
	size++;
    }
    private void insertBefore(LNode toBeAdded, LNode location){
	if(location.prev==null){
	    toBeAdded.prev=null;
	    location.prev=toBeAdded;
	    toBeAdded.next=location;
	}
	else{
	    toBeAdded.prev=location.prev;
	    location.prev=toBeAdded;
	    toBeAdded.next=location;
	}
	size++;
    }
    // private int remove(LNode node){
    // 	if(size()==1){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    // 	int toRet=-1;
    // 	toRet=node.val;
    // 	if(node.prev==null){
    // 	    start=node.next;
    // 	    node.next.prev=null;
    // 	}
    // 	else if(node.next==null){
    // 	    node.prev.next=null;
    // 	    tail=node.prev;
    // 	}
    // 	else{
    // 	    node.prev.next=node.next;
    // 	    node.next.prev=node.prev;
    // 	}
    // 	size--;
    // 	return toRet;
    // }
    private LNode getNthNode(int index){
	int i=0;
	LNode current=start;
	LNode toRet=null;
	while(i<size()){
	    if(i==index){
		//System.out.println("a");
		toRet=current;
		i=size()+2;
	    }
	    else{
		current=current.next;
	    }
	    i++;
	}
	return toRet;
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
	return indToRet;
    }
    public void add(int index, int value){
	if(index<0||index>size()){
	    throw new IndexOutOfBoundsException();
	}
	int i=0;
	LNode current=start;
	if(index==0){
	    LNode newNode=new LNode(value,current);
	    start=newNode;
	    newNode.prev=null;
	}
	else if(index==size()){
	    add(value);
	    size--;
	}
	else{
	    while(i<size()){
		if(i==index-1){
		    LNode newNode=new LNode(value,current.next);
		    current.next=newNode;
		    newNode.prev=current;
		    i=size()+2;
		}
		else{
		    current=current.next;
		}
		i++;
	    }
	}
	size++;
    }
    // public int remove(int index){
    // 	if(index<0||index>=size()){
    // 	    throw new IndexOutOfBoundsException();
    // 	}
    // 	int valRemoved=0;
    // 	int i=0;
    // 	LNode current=start;
    // 	if(index==0){
    // 	    valRemoved=current.val;
    // 	    start=current.next;
    // 	}
    // 	else if(index==size()-1){
    // 	    int j=0;
    // 	    while(j<size()){
    // 		if(j==size()-2){
    // 		    LNode lookingAt=current;
    // 		    LNode nextNode=current.next;
    // 		    valRemoved=nextNode.val;
    // 		    lookingAt.next=null;
    // 		    j=size()+2;
    // 		}
    // 		else{
    // 		    current=current.next;
    // 		}
    // 		j++;
    // 	    }
    // 	}
    // 	else{
    // 	    while(i<size()){
    // 		if(i==index-1){
    // 		    LNode prev=current;
    // 		    LNode next=current.next;
    // 		    valRemoved=next.val;
    // 		    System.out.println("b");
    // 		    prev.next=next.next;
    // 		    i=size()+2;
    // 		}
    // 	    }
    // 	}
    // 	size--;
    // 	return valRemoved;
    // }
    private class LNode{
	int val;
	LNode next;
	LNode prev;
	public LNode(int value){
	    val=value;
	}
	public LNode(int value, LNode nex){
	    val=value;
	    next=nex;
	}
	public String toString(){
	    return val+"";
	}
    }
    public String toString(){
	String toRet="[";
	LNode current=start;
	for(int i=0;i<size();i++){
	    toRet+=current.val;
	    if(i!=size()-1){
		toRet+=",";
	    }
	    current=current.next;
	}
	toRet+="]";
	return toRet;
    }
    public static void main(String[] args){
	//insertBefore not working right now
	//idk if remove is working properly/properly handling cases
	MyLinkedList c=new MyLinkedList();
	MyLinkedList.LNode a=c.new LNode(5);
	// c.add(5);
	// c.add(6);
	// c.add(7);
	// System.out.println(c);
	// c.remove(2);
	c.add(2);
	//c.add(4);
	c.addAfter(c.getNthNode(0),a);
	//c.add(3);
	//c.add(3);
	c.remove(c.getNthNode(0));
	c.remove(c.getNthNode(0));
	//System.out.println(c.remove(c.getNthNode(0)));
	System.out.println(c);
	//c.insertAfter(a,c.getNode(0));
	//System.out.println(c);
	// for(int i=0;i<10000;i++){
	//     c.add(i);
	//     //System.out.println(c.size());
	// }
	// c.insertAfter();
	// c.insertBefore();
	//System.out.println(c.remove(9999));
	// for(int j=0;j<10000;j++){
	//     System.out.println("get "+c.get(j));
	//     System.out.println("index "+c.indexOf(c.get(j)));
	// }
	// System.out.println(c);
	// // System.out.println(c.remove(4));
        // for(int j=9999;j>=0;j--){
	//     //c.remove(j);
	//     System.out.println(c.remove(j));
	// }
	// System.out.println(c);
	//System.out.println(c);
	//c.add(100,6);
	//c.add(100,6);
	//System.out.println(c.indexOf(6));
	// for(int j=0;j<100;j++){
	//     System.out.println(c.set(j,j*2));
	// }
	// c.add(5);
	// c.add(4);
	// c.add(6);
	// c.add(10);
	//System.out.println(c);
	// c.add(5);
	// c.add(4);
	// c.add(3);
	// c.add(2);
	//System.out.println(c);
	// c.add(0,3);
	// c.add(1,2);
        //c.remove(0);
	// for(int i=0;i<100;i++){
	//     c.add(i,j);
	//     j++;
	// }
	//System.out.println(c);
	//System.out.println(c.get(0));
	//c.set(2,30);
	//System.out.println(c.indexOf(10));
    }
}
