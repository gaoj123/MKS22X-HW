public class RunningMedian{
    MyHeap minHeap;
    MyHeap maxHeap;
    double median;
    public RunningMedian(){
	minHeap=new MyHeap(false);
	maxHeap=new MyHeap(true);
	median=0;
    }
    public double getMedian(){
	return median;
    }
    public void updateMedian(){
	if(minHeap.size()==1&&maxHeap.size()==0){
	    median=minHeap.peek();
	}
	else if(maxHeap.size()==1&&minHeap.size()==0){
	    median=maxHeap.peek();
	}
	else if(minHeap.size()==maxHeap.size()){
	    median=(minHeap.peek()+maxHeap.peek())/2.0;
	}
	else if(minHeap.size()==maxHeap.size()+1){
	    median=minHeap.peek();
	}
	else if(maxHeap.size()==minHeap.size()+1){
	    median=maxHeap.peek();
	}
	else if(minHeap.size()==maxHeap.size()+2){
	    int x=minHeap.peek();
	    maxHeap.add(x);
	    minHeap.remove();
	    median=(minHeap.peek()+maxHeap.peek())/2.0;
	}
	//else if(maxHeap.size()==minHeap.size()+2){
	else{
	    minHeap.add(maxHeap.peek());
	    maxHeap.remove();
	    median=(minHeap.peek()+maxHeap.peek())/2.0;
	}
	// median=toRet;
	// return toRet;
    }
    public void add(int x){
	if(minHeap.size()==0&&maxHeap.size()==0){
	    median=x;
	}
	if(x>median){
	    minHeap.add(x);
	    updateMedian();
	}
	else{
	    maxHeap.add(x);
	    updateMedian();
	}
    }
    public static void main(String[] args){
	RunningMedian test=new RunningMedian();
	for(int i=0;i<20;i+=1){
	    test.add(i);
	    System.out.println(test.getMedian());
	}
	// test.add(14);
	// test.add(450);
	// test.add(1000);
	// test.add(20);
	// test.add(5);
	// test.add(6);
	// System.out.println("size: "+test.maxHeap.size());
	// System.out.println("size: "+test.minHeap.size());
	// System.out.println("median: "+test.getMedian());
	// System.out.println(test.maxHeap.peek());
	// System.out.println(test.minHeap.peek());
    }
}
