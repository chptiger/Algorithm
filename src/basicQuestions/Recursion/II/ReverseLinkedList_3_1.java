package basicQuestions.Recursion.II;

import org.junit.Test;

import entities.ListNode;

/**
 * Reverse pairs of elements in a singly-linked list. Examples L = null, after
 * reverse is null L = 1 -> null, after reverse is 1 -> null L = 1 -> 2 -> null,
 * after reverse is 2 -> 1 -> null L = 1 -> 2 -> 3 -> null, after reverse is 2
 * -> 1 -> 3 -> null
 * 
 * 
 * @author xx65
 *
 */
public class ReverseLinkedList_3_1 {

	public static ListNode a1 = new ListNode(1);
	public static ListNode a2 = new ListNode(2);
	public static ListNode a3 = new ListNode(3);
	public static ListNode a4 = new ListNode(4);

	@Test
	public void test_reverseLinkedListInPairs() {
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;

		reverseLinkedList(a1);
	}

	public static ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode tmpNode = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		return tmpNode;
	}
}
