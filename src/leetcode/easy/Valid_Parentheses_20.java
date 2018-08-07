package leetcode.easy;
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, '()' and '()[]{}' are all valid but '(]' and '([)]' are not.

follow up: how about tons of characters? Use hashtable to store these characters.
switch()

*/
import java.util.Stack;
public class Valid_Parentheses_20{
	public static void main(String[] args){
		String s = "()[](){()}";
		boolean flag = isValid(s);
		System.out.println(flag);
	}
	
	public static boolean isValid(String s){
		/*
		Hashtable<Character , Character> cur = new Hashtable<Character , Character>();
		cur.put('(' , ')');
		cur.put('{' , '}');
		cur.put('[' , ']');
		.
		.
		.
		use switch() case;
		
		for(int i = 0; i < length ; i++ ){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				stack.push(stack.charAt(i));
			}
			
			if(s.charAt(i) == ')' && !stack.Empty() && stack.peek() == cur.get(')');){
				stack.pop();
			}
			
			if(s.charAt(i) == '}' && !stack.Empty() && stack.peek() == cur.get('}');){
				stack.pop();
			}
			
			if(s.charAt(i) == ']' && !stack.Empty() && stack.peek() == cur.get(']');){
				stack.pop();
			}
			
			else
				return false;
		
		*/
		
		Stack<Character> stack = new Stack<Character>();
		int length = s.length();
		for(int i = 0; i < length ; i++ ){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				stack.push(s.charAt(i));
			}
			
			else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '('){
				stack.pop();
			}
			
			else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{'){
				stack.pop();
			}
			
			else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '['){
				stack.pop();
			}
			
			else {
				return false;
			}
		}
		
		return stack.empty();
	}
}