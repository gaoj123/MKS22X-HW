public class Quick{
    public static String name(){
	return "Gao,Jenny";
    }
    public static void quicksort(int[] data){
	qsh(data,0,data.length-1);
    }
    public static void qsh(int[] data, int start2, int end2){
	if(start2<end2){
	    int index=part(data,start2,end2);
	    qsh(data,start2,index-1);
	    qsh(data,index+1,end2);
	}
    }
    public static int quickselect(int[] data, int k){
	return helper(data,k,0,data.length-1);
    }
    public static int helper(int[] data,int k, int start, int end){
	int index=part(data,start,end);
	if(index==k-1){
	    return data[index];
	}
	else{
	    if(k-1>index){
		return helper(data,k,index+1,end);
	    }
	    else{
		return helper(data,k,start,index-1);
	    }
	}
    }
    public static int part(int[] data, int start, int end){
    	if(start==end){
    	    return start;
    	}
	int pivot=start+(int)(Math.random() * (end-start+1));
	int divider=data[pivot];
	swap(start,pivot,data);
	int back=end;
	int front=start+1;
	while(front<back){
	    // if(start==end){
	    //     if(data[start]>=divider){
	    // 	swap(0,start-1,data);
	    //     }
	    //     else{
	    // 	swap(0,start,data);
	    //     }
	    // }
	    if(data[front]<divider){
		front++;
	    }
	    else{
		swap(front,back,data);
		back--;
	    }
	}
	if(data[start]<=data[back]){
	    swap(start,back-1,data);
	    return back-1;
	}
	else{
	    swap(start,back,data);
	    return back;
	}
    }

    public static void swap(int ind1, int ind2, int[] ary){
	int firstInd=ary[ind1];
	ary[ind1]=ary[ind2];
	ary[ind2]=firstInd;
    }
    // public static int part(int[] data, int start, int end){
    // 	if(start==end){
    // 	    return start;
    // 	}
    // 	int pivot=start+(int)(Math.random() * (end-start+1));
    // 	int divider=data[pivot];
    // 	int[] newData=new int[data.length];
    // 	int[] changed=new int[data.length];
    // 	for(int i=0;i<changed.length;i++){
    // 	    changed[i]=0;
    // 	}
    // 	int lower=start;
    // 	int higher=end;
    // 	int indexDividerFinal=0;
    // 	for(int i=0;i<newData.length;i++){
    // 	    newData[i]=data[i];
    // 	}
    // 	for(int i=start;i<=end;i++){
    // 	    if(data[i]<=divider&&i!=pivot){
    // 		newData[lower]=data[i];
    // 		changed[lower]=1;
    // 		lower+=1;
    // 	    }
    // 	    else if(data[i]>divider){
    // 		newData[higher]=data[i];
    // 		changed[higher]=1;
    // 		higher-=1;
    // 	    }
    // 	}
    // 	for(int j=0;j<changed.length;j++){
    // 	    if(changed[j]==0&&j>=start&&j<=end){
    // 		newData[j]=divider;
    // 		indexDividerFinal=j;
    // 	    }
    // 	}
    // 	for(int i=0;i<newData.length;i++){
    // 	    data[i]=newData[i];
    // 	}
    // 	return indexDividerFinal;
    // }
    public static void main(String[] args){
	// int[] test3=new int[]{5,2,9,6,3,1};
	// int[] test1=new int[]{12,4,1,10,23,34,2,3,1,5,8,8,11};
	// int[] test2=new int[]{999,999,999,4,1,0,3,2,999,999,999};
	// //System.out.println(test1.length);
	// for(int i=1;i<test1.length+1;i++){
	//     System.out.println(Quick.quickselect(test1,i));
	// }
	// for(int i=1;i<test2.length+1;i++){
	//     System.out.println(Quick.quickselect(test2,i));
	// }
	// for(int i=1;i<test3.length+1;i++){
	//     System.out.println(Quick.quickselect(test3,i));
	// }
	// int[] test4=new int[]{13,6,3,18,6,3,5,2,3,7,3,2,3,7,2};
	// quicksort(test4);
        // for(int i=0;i<test4.length;i++){
	//     System.out.println(test4[i]);
	// }
	//System.out.println(Quick.quickselect(test1,8));
	 // System.out.println(Quick.quickselect(test1,1));
    }
}
