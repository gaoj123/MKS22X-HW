import java.util.*;
public class Quiz2Redux{
    public static String name(){
	return "Gao,Jenny";
    }
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help( words ,s,0,""/*fill this in with more */);
      Collections.sort(words);
      return words;
  }
  
    private static void help( ArrayList<String> words, String input, int index, String combination
                             /*fill this in with more arguments*/ ){
   /*METHOD TO BE WRITTEN BY YOU.*/
	if(index>=input.length()){
	    words.add(combination);
	}
	else{
	    help(words,input,index+1,combination);
	    help(words,input,index+1,combination+input.substring(index,index+1));
	}
    }
    public static void main(String[] args){
	//System.out.println(combinations("kji"));
    }
}
