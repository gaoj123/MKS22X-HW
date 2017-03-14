public class QuickSelect{
    public static String name(){
	return "Gao,Jenny";
    }
    public static int kthSmallest(int[] data, int k){
	return helper(data,k,0,data.length-1);
    }
    public static int helper(int[] data,int k, int start, int end){
	int index=part(data,start,end);
	if(index==k-1){
	    return data[index];
	}
	else{
	    if(k-1>index){
		return helper(data,k,index,end);
	    }
	    else{
		return helper(data,k,start,index);
	    }
	}
    }
    public static int part(int[] data, int start, int end){
	int pivot=start+(int)(Math.random() * (end-start+1));
	int divider=data[pivot];
	int[] newData=new int[data.length];
	int[] changed=new int[data.length];
	for(int i=0;i<changed.length;i++){
	    changed[i]=0;
	}
	int lower=start;
	int higher=end;
	int indexDividerFinal=0;
	for(int i=0;i<newData.length;i++){
	    newData[i]=data[i];
	}
	for(int i=start;i<=end;i++){
	    if(data[i]<divider){
		newData[lower]=data[i];
		changed[lower]=1;
		lower+=1;
	    }
	    else if(data[i]>divider){
		newData[higher]=data[i];
		changed[higher]=1;
		higher-=1;
	    }
	}
	for(int j=0;j<changed.length;j++){
	    if(changed[j]==0&&j>=start&&j<=end){
		newData[j]=divider;
		indexDividerFinal=j;
	    }
	}
	for(int i=0;i<newData.length;i++){
	    data[i]=newData[i];
	}
	return indexDividerFinal;
    }
    public static void main(String[] args){
	int[] test1=new int[]{12,4,1,23,5,8,11};
	//System.out.println(test1.length);
	for(int i=1;i<test1.length+1;i++){
	    System.out.println(QuickSelect.kthSmallest(test1,i));
	}
	 // System.out.println(QuickSelect.kthSmallest(test1,8));
	 // System.out.println(QuickSelect.kthSmallest(test1,1));
    }
}
