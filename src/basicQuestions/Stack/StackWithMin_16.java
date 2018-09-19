package Algorithm.Stack;

import java.util.Stack;

/**
 * 
 * Enhance the stack implementation to support min() operation. min() should
 * return the current minimum value in the stack. If the stack is empty, min()
 * should return -1.
 * 
 * pop() - remove and return the top element, if the stack is empty, return -1
 * push(int element) - push the element to top top() - return the top element
 * without remove it, if the stack is empty, return -1 min() - return the
 * current min value in the stack.
 * 
 * @author Thomas
 *
 */
public class StackWithMin_16 {
	private Stack<Integer> originalStack;
	private Stack<Integer> minStack;

	public StackWithMin_16(Stack<Integer> originalStack, Stack<Integer> minStack) {
		originalStack = new Stack();
		minStack = new Stack();
	}

	private void push(Integer input) {
		if (minStack.isEmpty() || minStack.peek() >= input) {
			minStack.push(input);
		}
		originalStack.push(input);
	}

	private Integer min() {
		return minStack.isEmpty() ? -1 : minStack.peek();
	}

	private Integer top() {
		return originalStack.isEmpty() ? -1 : originalStack.peek();
	}

	private Integer pop() {
		if (originalStack.isEmpty()) {
			return -1;
		}

		if (minStack.peek() == originalStack.peek()) {
			minStack.pop();
		}
		return minStack.pop();
	}
}
