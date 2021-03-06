public class Recursion{
    public static String name(){
	return "Gao,Jenny";
    }
    public static double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	else if(n-0<=0.00000000001){
	    return 0;
	}
	else{
	    return helper(n,1);
	}
    }
    public static double helper(double n, double guess){
	if(Math.abs((Math.pow(guess,2)-n)/n)<=0.00000000001){
	    return guess;
	}
	else{
	    return helper(n,(n/guess+guess)/2);
	}
    }
    public static void main(String[] args){
    }
}
