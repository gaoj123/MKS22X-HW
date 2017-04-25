import java.util.*;

public class StackCalc{
    public static double eval(String s){
	String[] arr=s.split(" ");
	Stack<Double> stack=new Stack<Double>();
	for(int i=0;i<arr.length;i++){
	    if(isOperand(arr[i])){
		stack.push(apply(arr[i],stack.pop(),stack.pop()));
	    }
	    else{
		stack.push(Double.parseDouble(arr[i]));
	    }
	}
	    return stack.pop();
    }
    public static boolean isOperand(String s){
	return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("%");
    }
    public static double apply(String op, Double a, Double b){
	double toRet=0;
	double numOne=b;
	double numTwo=a;
	if(op.equals("+")){
	    toRet=numOne+numTwo;
	}
	else if(op.equals("-")){
	    toRet=numOne-numTwo;
	}
	else if(op.equals("*")){
	    toRet=numOne*numTwo;
	}
	if(op.equals("/")){
	    toRet=numOne/numTwo;
	}
	if(op.equals("%")){
	    toRet=numOne%numTwo;
	}
	return toRet;
    }
    public static void main(String[] args){
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
