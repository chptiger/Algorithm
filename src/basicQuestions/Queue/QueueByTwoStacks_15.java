package Algorithm.Queue;

import java.util.Stack;

/**
 * Java: Implement a queue by using two stacks. The queue should provide size(),
 * isEmpty(), offer(), poll() and peek() operations. When the queue is empty,
 * poll() and peek() should return null. C++: Implement a queue by using two
 * stacks. The queue should provide size(), isEmpty(), push(), front() and pop()
 * operations. When the queue is empty, front() should return -1.
 * 
 * Assumptions
 * 
 * The elements in the queue are all Integers. size() should return the number
 * of elements buffered in the queue. isEmpty() should return true if there is
 * no element buffered in the queue, false otherwise.
 * 
 * @author Thomas
 *
 */
public class QueueByTwoStacks_15 {

	private Stack<Integer> in;
	private Stack<Integer> out;

	public QueueByTwoStacks_15(Stack<Integer> in, Stack<Integer> out) {
		in = new Stack<Integer>();
		out = new Stack<Integer>();
	}

	private boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}

	private int size() {
		return in.size() + out.size();
	}

	private void offer(Integer input) {
		in.push(input);
	}

	private Integer poll() {
		if (out.empty()) {
			move();
		}
		return out.empty() ? null : out.pop();
	}

	private Integer peek() {
		if (out.empty()) {
			move();
		}
		return out.empty() ? null : out.peek();
	}

	private void move() {
		while (!in.isEmpty()) {
			out.push(in.pop());
		}
	}
}
