package Algorithm.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
When the queue is empty, poll() and peek() should return null.
C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.

Assumptions

The elements in the queue are all Integers.
size() should return the number of elements buffered in the queue.
isEmpty() should return true if there is no element buffered in the queue, false otherwise.



???????????????????????
Dequeue vs Stack

 * @author Thomas
 *
 */
public class QueueByDequeue_15 {

	private Deque<Integer> in;
	  private Deque<Integer> out;
	  public QueueByDequeue_15() {
	    // Write your solution here.
	    in = new ArrayDeque<Integer>(); // ???????????????
	    out = new ArrayDeque<Integer>();
	  }
	  
	  public Integer poll() {
	    if(out.size() == 0) {
	        move();
	    }
	    
	    return out.isEmpty() ? null : out.removeFirst();
	  }
	  
	  public void offer(int element) {
	    in.addFirst(element);
	  }
	  
	  public Integer peek() {
	    if(out.size() == 0) {
	        move();
	    }
	    
	    return out.isEmpty() ? null:out.peekFirst();
	  }
	  
	  public int size() {
	    return out.size() + in.size();
	  }
	  
	  public boolean isEmpty() {
	    return out.size() == 0 && in.size() == 0;
	  }
	  
	  private void move(){
	      while(in.size() != 0) {
	        out.addFirst(in.removeFirst());
	    }
	  }
}
