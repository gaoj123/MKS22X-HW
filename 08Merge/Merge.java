public class Merge{
    public static String name(){
	return "Gao,Jenny";
    }
    public static void mergesort(int[] ary){
	int len=ary.length;
	if(len!=1){
	    int divide=0;
	    if((len%2)!=0){
		divide=len/2+1;
	    }
	    else{
		divide=len/2;
	    }
	    int[] left=makeArr(ary,0,divide-1);
	    int[] right=makeArr(ary,divide,len-1);
	    if(left.length>1){
		mergesort(left);
	    }
	    if(right.length>1){
		mergesort(right);
	    }
	    merge(left,right,ary);
	}
    }
    public static int[] makeArr(int[] array, int leftInd, int rightInd){
	int[] toRet=new int[rightInd-leftInd+1];
	for(int i=0;i<=rightInd-leftInd;i++){
	    toRet[i]=array[leftInd+i];
	}
	return toRet;
    }
    public static void merge(int[] a, int[] b, int[] destination){
	int i=0;
	int j=0;
	int ind=0;
	int notDoneA=0;
	int notDoneB=0;
	while(i<a.length&&j<b.length){
	    if(a[i]<b[j]){
		destination[ind]=a[i];
		i++;
		if(i>=a.length){
		    notDoneB=1;
		}
	    }
	    else{
		destination[ind]=b[j];
		j++;
		if(j>=b.length){
		    notDoneA=1;
		}
	    }
	    ind++;
	}
	if(notDoneA==1){
	    for(int k=i;k<a.length;k++){
		destination[ind]=a[k];
		ind++;
	    }
	}
	if(notDoneB==1){
	    for(int k=j;k<b.length;k++){
		destination[ind]=b[k];
		ind++;
	    }
	}
    }
    public static void main(String[] arg){
	// int j=1000000;
	// int[] test=new int[1000000];
	// for(int i=0;i<1000000;i++){
	//     test[i]=(int)(Math.random()*900);
	// }
	// // int[] test=new int[]{1,6,3,2,4,45,23,4,2,1};
	// mergesort(test);
	// for(int i=0;i<test.length;i++){
	//     System.out.println(test[i]);
	// }
	// int[] t=new int[]{2,1,34,45,4};
	// int[] a=new int[]{1,2};
	// int[] b=new int[]{4,34,45};
	// merge(a,b,t);
	// for(int i=0;i<t.length;i++){
	//     System.out.println(t[i]);
	// }
    }
}
