import java.util.*;

public class MyHeap{
    private boolean maxx;
    private ArrayList<String> arr=new ArrayList<String>();
    public MyHeap(){
	arr.add(null);
	maxx=true;
    }
    public MyHeap(boolean maxMin){
	arr.add(null);
	maxx=maxMin;
    }
    public int size(){
	return arr.size()-1;
    }
    public void add(String s){
	arr.add(s);
	if(size()>1){
	    pushUp();
	}
    }
    public String remove(){
	String toRem=arr.get(1);
	arr.remove(1);
	if(size()>1){
	    //System.out.println(arr.get(size()));
	    arr.add(1,arr.remove(size()));
	    pushDown();
	}
	return toRem;
    }
    public String peek(){
	return arr.get(1);
    }
    private void pushUp(){
	int lastChildInd=size();
	//System.out.println(size());
	int parentInd=lastChildInd/2;
	//System.out.println(parentInd);
	boolean finished=false;
	while(finished==false){
	    if(parentInd==1){
		finished=true;
	    }
	    String lookingAt=arr.get(lastChildInd);
	    int largerOrNot=lookingAt.compareTo(arr.get(parentInd));
	    if(maxx){
		if(largerOrNot>0){
		    swap(lastChildInd,parentInd,arr);
		    lastChildInd=parentInd;
		    parentInd=lastChildInd/2;
		}
		else{
		    finished=true;
		}
	    }
	    else{
		if(largerOrNot<0){
		    swap(lastChildInd,parentInd,arr);
		    lastChildInd=parentInd;
		    parentInd=lastChildInd/2;
		}
		else{
		    finished=true;
		}
	    }
	}
    }
    public void swap(int ind1, int ind2, ArrayList<String> arrr){
	String ele1=arrr.get(ind1);
	String ele2=arr.get(ind2);
	arr.set(ind1,ele2);
	arr.set(ind2,ele1);
    }
    private void pushDown(){
	if(size()==2){
	    if(maxx){
		if(arr.get(1).compareTo(arr.get(2))<0){
		    swap(1,2,arr);
		}
	    }
	    else{
		if(arr.get(1).compareTo(arr.get(2))>0){
		    swap(1,2,arr);
		}
	    }
	}
	else{
	    int parentInd=1;
	    boolean finished=false;
	    int childInd1=2;
	    int childInd2=3;
	    while(finished==false){
		if(childInd1*2>size()||childInd2*2>size()){
		    finished=true;
		}
		if(maxx){
		    String par=arr.get(parentInd);
		    String chil1=arr.get(childInd1);
		    if(childInd2<=size()){
			String chil2=arr.get(childInd2);
			String larger="";
			int ind=0;
			if(chil1.compareTo(chil2)>0){
			    larger=chil1;
			    ind=childInd1;
			}
			else{
			    larger=chil2;
			    ind=childInd2;
			}
			if(par.compareTo(larger)<0){
			    swap(ind,parentInd,arr);
			    parentInd=ind;
			    childInd1=parentInd*2;
			    childInd2=parentInd*2+1;
			    if(childInd1>size()||childInd2>size()){
				finished=true;
			    }
			}
			else{
			    finished=true;
			}
		    }
		    else if(childInd2>size()){
			if(par.compareTo(chil1)<0){
			    swap(childInd1,parentInd,arr);
			    parentInd=childInd1;
			    childInd1=parentInd*2;
			    childInd2=parentInd*2+1;
			    if(childInd1>size()||childInd2>size()){
				finished=true;
			    }
			}
			else{
			    finished=true;
			}
		    }
		}
		else{
		    String par=arr.get(parentInd);
		    String chil1=arr.get(childInd1);
		    if(childInd2<=size()){
			String chil2=arr.get(childInd2);
			String smaller="";
			int ind=0;
			if(chil1.compareTo(chil2)<0){
			    smaller=chil1;
			    ind=childInd1;
			}
			else{
			    smaller=chil2;
			    ind=childInd2;
			}
			if(par.compareTo(smaller)>0){
			    swap(ind,parentInd,arr);
			    parentInd=ind;
			    childInd1=parentInd*2;
			    childInd2=parentInd*2+1;
			    if(childInd1>size()||childInd2>size()){
				finished=true;
			    }
			}
			else{
			    finished=true;
			}
		    }
		    else{
			if(par.compareTo(chil1)>0){
			    swap(childInd1,parentInd,arr);
			    parentInd=childInd1;
			    childInd1=parentInd*2;
			    childInd2=parentInd*2+1;
			    if(childInd1>size()||childInd2>size()){
				finished=true;
			    }
			}
			else{
			    finished=true;
			}
		    }
		}
	    }
	}
    }
public static void main(String[] args){
    // MyHeap a=new MyHeap(false);
    // for(int i=0;i<99;i++){
    // 	a.add(""+i);
    // }
    // a.add("hi");
    // a.add("bye");
    // a.add("hello");
    // a.add("i");
    // a.add("123");
    // a.add("j");
    //System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
}
}
