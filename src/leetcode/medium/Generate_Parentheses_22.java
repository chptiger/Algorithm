package leetcode.medium;
import java.util.ArrayList;
import java.util.List;

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

public class Generate_Parentheses_22{
	public static void main(String []args){
		List<String> result = generateParenthesis(3);
		System.out.println(result);
	}
	
	/*
 	public static List<String> generateParenthesis_1(int n) {
	    List<String> list = new ArrayList<String>();
	    generateOneByOne("", list, n, n);
	    return list;
	}
	public static void generateOneByOne(String sublist, List<String> list, int left, int right){
	    if(left > right){
	        return;
	    }
	    if(left > 0){
	        generateOneByOne( sublist + "(" , list, left-1, right);
	    }
	    if(right > 0){
	        generateOneByOne( sublist + ")" , list, left, right-1);
	    }
	    if(left == 0 && right == 0){
	        list.add(sublist);
	        return;
	    }
	}
	*/
	
	
	public static List<String> generateParenthesis(int n) {
	    List<String> list = new ArrayList<String>();
	    backtrack(list, "", 0, 0, n);
	    return list;
	}

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
