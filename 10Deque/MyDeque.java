import java.util.*;

public class MyDeque{
    int front;
    int back;
    String[] x;
    public MyDeque(){
	x=new String[5];
	front=0;
	back=4;
    }
    public int size(){
	return x.length;
    }
    public void resize(){
	int lookingAt=front;
	String[] newArr=new String[size()*2];
	for(int i=0;i<spacesFilled();i++){
	    newArr[i]=x[lookingAt];
	    lookingAt=(lookingAt+1)%size();
	}
	x=newArr;
	front=0;
	back=size()/2-1;
    }
    public boolean filled(){
	for(int i=0;i<size();i++){
	    if (x[i]==null){
		return false;
	    }
	}
	return true;
    }
    //resize
    public int spacesFilled(){
	int count=0;
	for(int i=0;i<size();i++){
	    if(x[i]!=null){
		count++;
	    }
	}
	return count;
	// if(back>front){
	//     return back-(front-1);
	// }
	// else{
	//     return size()-front+back+1;
	// }
    }
    public void addFirst(String a){
	if(a==null){
	    throw new NullPointerException();
	}
	if(filled()){
	    resize();
	}
	if(front==0){
	    front=x.length-1;
	}
	else{
	    front--;
	}
	x[front]=a;
	//x[front]=a;
    }
    public void addLast(String a){
	if(a==null){
	    throw new NullPointerException();
	}
	if(filled()){
	    resize();
	}
	back=(back+1)%size();
	x[back]=a;
    }
    public String removeFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	String toRemove=x[front];
	x[front]=null;
	front=(front+1)%size();
	return toRemove;
    }
    public String removeLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	String toRemove=x[back];
	x[back]=null;
	back=(back-1)%size();
	return toRemove;
    }
    public String getFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	// if(front==x.length-1){
	//     return x[0];
	// }
	// else{
	//     return x[front+1];
	// }
	return x[front];
    }
    public String getLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	// if(back==0){
	//     return x[size()-1];
	// }
	// else{
	//     return x[back-1];
	// }
	return x[back];
    }
    public String toString(){
	String toRet="";
	toRet+="[";
	for(int i=0;i<size();i++){
	    if(x[i]==null){
		toRet+="null";
	    }
	    else{
		toRet+=x[i];
	    }
	    if(i!=size()-1){
		toRet+=", ";
	    }
	}
	toRet+="]";
	return toRet;
    }
    public static void main(String[] args){
	// MyDeque test=new MyDeque();
	// test.addLast("2");
	// test.addLast("1");
	// test.addFirst("3");
	// test.addFirst("4");
	// test.addFirst("5");
	// test.addFirst("6");
	// test.addFirst("7");
	// test.addFirst("8");
	// test.addFirst("9");
	// test.addLast("11");
	// System.out.println(test);
	// test.removeLast();
	// test.removeLast();
	// test.addFirst("10");
	//System.out.println(test.spacesFilled());
	//System.out.println(test.getFirst());
	//System.out.println(test.getLast());
	//System.out.println(test);
    }
}
