package basicQuestions.Recursion.II;

import org.junit.Test;

import POJO.ListNode;

/**
Reverse pairs of elements in a singly-linked list.
Examples
L = null, after reverse is null
L = 1 -> null, after reverse is 1 -> null
L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null


 * @author xx65
 *
 */
public class ReverseLinkedListInPairs_66 {
	
	public static ListNode a1 = new ListNode(1);
	public static ListNode a2 = new ListNode(2);
	public static ListNode a3 = new ListNode(3);
	
	@Test
	public void test_reverseLinkedListInPairs() {
		a1.next = a2;
		a2.next = a3;
		
		Assert.equ
	}
}
