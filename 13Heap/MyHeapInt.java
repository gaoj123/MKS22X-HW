import java.util.*;

public class MyHeapInt{
    private boolean maxx;
    private ArrayList<Integer> arr=new ArrayList<Integer>();
    public MyHeapInt(){
	arr.add(null);
	maxx=true;
    }
    public MyHeapInt(boolean maxMin){
	arr.add(null);
	maxx=maxMin;
    }
    public int size(){
	return arr.size()-1;
    }
    public void add(int s){
	arr.add(s);
	if(size()>1){
	    pushUp();
	}
    }
    public int remove(){
        int toRem=arr.get(1);
	arr.remove(1);
	if(size()>1){
	    //System.out.println(arr.get(size()));
	    arr.add(1,arr.remove(size()));
	    pushDown();
	}	
	return toRem;
    }
    public int peek(){
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
	    Integer lookingAt=arr.get(lastChildInd);
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
    public void swap(int ind1, int ind2, ArrayList<Integer> arrr){
        int ele1=arrr.get(ind1);
	int ele2=arr.get(ind2);
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
		if(childInd1*2>size()&&childInd2*2>size()){
		    finished=true;
		}
		if(maxx){
		    Integer par=arr.get(parentInd);
		    Integer chil1=arr.get(childInd1);
		    if(childInd2<=size()){
		        Integer chil2=arr.get(childInd2);
		        Integer larger=0;
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
		    Integer par=arr.get(parentInd);
		    Integer chil1=arr.get(childInd1);
		    if(childInd2<=size()){
			Integer chil2=arr.get(childInd2);
			int smaller=0;
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
    //MyHeapInt a=new MyHeapInt(false);
    // a.add(20);
    // a.add(19);
    // a.add(17);
    // a.add(12);
    // a.add(18);
    // a.add(5);
    // a.add(8);
    // a.add(1);
    // a.add(2);
    // a.remove();
    // System.out.println("top "+a.peek());
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
