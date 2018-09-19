package leetcode.easy;
/*
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. 
Could you implement both?

*/

public class Reverse_ListNode_206 {
	static int count = 0;

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		print(n1);

		// Reverse_ListNode_Ite(n1);

		ListNode cur = Reverse_ListNode_Rec(n1);
		print(cur);
	}

	/*
	 * There's code in one reply that spells it out, but you might find it easier to
	 * start from the bottom up, by asking and answering tiny questions (this is the
	 * approach in The Little Lisper):
	 * 
	 * What is the reverse of null (the empty list)? null. What is the reverse of a
	 * one element list? the element. What is the reverse of an n element list? the
	 * reverse of the second element on followed by the first element.
	 */

	public static ListNode Reverse_ListNode_Rec(ListNode head) {
		if (head == null)
			return null; // first question

		if (head.next == null)
			return head; // second question

		// third question - in Lisp this is easy, but we don't have cons
		// so we grab the second element (which will be the last after we reverse it)

		ListNode secondElem = head.next;

		// bug fix - need to unlink head from the rest or you will get a cycle
		head.next = null;

		// then we reverse everything from the second element on
		ListNode reverseRest = Reverse_ListNode_Rec(secondElem);

		// then we join the two heads
		secondElem.next = head;

		return reverseRest;

	}

	/*
	 * To reverse this head, we need 3 additional pointers. currentNode pointer to
	 * traverse through the head; nextNode pointer to save the next node in the
	 * head; prevNode pointer to keep track of the last node in the new head as we
	 * keep on reversing the input head. So, in essence, here is the pseudo
	 * algorithm to reverse the head:
	 * 
	 * Initialize currentNode pointer to the start of the head and prevNode to NULL
	 * (as the new head is currently pointing to NULL). While currentNode is not
	 * NULL Save the next node in nextNode Set the currentNode to point to the
	 * prevNode. Move the prevNode to the currentNode. Move the currentNode pointer
	 * to the nextNode.
	 * 
	 */
	public static ListNode Reverse_Linkedhead_Ite_NoDummy(ListNode head) {
		// Initialize currentNode pointer to the start of the head
		// and prevNode to NULL
		// (as the new head is currently pointing to NULL)
		ListNode preNode = null;
		ListNode curNode = head;
		ListNode nxtNode = null;
		while (curNode != null) {
			// Save the next node in nextNode
			nxtNode = curNode.next;
			// Set the currentNode to point to the prevNode.
			curNode.next = preNode;
			// Move the prevNode to the currentNode.
			preNode = curNode;
			// Move the currentNode pointer to the nextNode.
			curNode = nxtNode;
		}

		// reset the head pointer to point to the prevNode
		// as that is now the current head of the reversed head
		head = preNode;
		return head;
	}

	public static ListNode Reverse_Linkedhead_Ite(ListNode head) {
		ListNode dummp = new ListNode(0);
		while (head != null) {
			ListNode tmp = dummp.next;
			dummp.next = head;
			head = head.next;
			dummp.next.next = tmp;
		}
		ListNode cur = dummp.next;
		return cur;
	}

	public static void print(ListNode n) {
		if (n == null)
			return;
		System.out.println(n.val);
		print(n.next);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
