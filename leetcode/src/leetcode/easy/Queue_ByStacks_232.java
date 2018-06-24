package leetcode.easy;
/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Notes:

You must use only standard operations of a stack 
-- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.

You may assume that all operations are valid 
(for example, no pop or peek operations will be called on an empty queue).
*/
import java.util.Stack;

public class Queue_ByStacks_232{
	public static void main(String[] args){
		MyQueue q = new MyQueue();
		
		System.out.println(q.empty());
		
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		
		System.out.println(q.peek());
		
		q.pop();
		
		System.out.println(q.peek());
		
		q.pop();
		q.pop();
		
		System.out.println(q.peek());
		
	}
	
	static class MyQueue {
	
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		
		
		// Push element x to the back of queue.
		public void push(int x) {
			
		   if(s1.isEmpty() && s2.isEmpty()) s2.push(x);
		   else{
			   Integer cur = 0;
			   
			   while(!s2.isEmpty()){
				   cur = s2.pop();
				   s1.push(cur);
			   }
			   
			   s2.push(x);	
			   
				while(!s1.isEmpty()){
					cur = s1.pop();
					s2.push(cur);
				}
		   }
		   
		}

		// Removes the element from in front of queue.
		public void pop() {
			s2.pop();
		}

		// Get the front element.
		public int peek() {
			return s2.peek();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			if(s1.isEmpty() && s2.isEmpty()) return true;
			return false;
		}
	}
}

