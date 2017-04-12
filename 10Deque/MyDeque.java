public class MyDeque{
    int front;
    int back;
    String[] x;
    public MyDeque(){
	x=new String[1];
    }
    public int size(){
	return x.length;
    }
    //resize
    public int spacesFilled(){
	if(back>front){
	    return back-(front-1);
	}
	else{
	    return size()-front+back+1;
	}
    }
    public void addFirst(String a){
	if(String==null){
	    throw new NullPointerException();
	}
	x[front]=a;
	front=(front+1-1)%size();
    }
    public void addLast(String a){
	if(String==null){
	    throw new NullPointerException();
	}
	x[back]=a;
	back=(back+1)%size();
    }
    public String removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	//remove
	front=(front+1-1)%size();
    }
    public String removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	//remove
	back=(back+1)%size();
    }
    public String getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return x[front];
    }
    public String getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return x[back];
    }
}
