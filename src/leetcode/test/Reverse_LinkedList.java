
/*
Reverse a singly linked head.
Hint:
A linked head can be reversed either iteratively or recursively. 
Could you implement both?

*/

//http://www.programminginterviews.info/2011/05/reverse-linked-head.html 

public class Reverse_LinkedList {
	public static void main(String[] args) {
		headNode n1 = new headNode(1);
		headNode n2 = new headNode(2);
		headNode n3 = new headNode(3);
		headNode n4 = new headNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		print(n1);

		headNode cur = Reverse_Linkedhead_Ite_NoDummy(n1);

		// headNode cur = Reverse_Linkedhead_Ite(n1);

		// cur = Reverse_Linkedhead_Rec(n1);
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

	public static headNode Reverse_Linkedhead_Rec(headNode head) {
		if (head == null)
			return null; // first question

		if (head.next == null)
			return head; // second question

		// third question - in Lisp this is easy, but we don't have cons
		// so we grab the second element (which will be the last after we reverse it)

		headNode secondElem = head.next;

		// bug fix - need to unlink head from the rest or you will get a cycle
		head.next = null;

		// then we reverse everything from the second element on
		headNode reverseRest = Reverse_Linkedhead_Rec(secondElem);

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
	public static headNode Reverse_Linkedhead_Ite_NoDummy(headNode head) {
		// Initialize currentNode pointer to the start of the head
		// and prevNode to NULL
		// (as the new head is currently pointing to NULL)
		headNode preNode = null;
		headNode curNode = head;
		headNode nxtNode = null;
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

	public static headNode Reverse_Linkedhead_Ite(headNode head) {
		headNode dummp = new headNode(0);
		while (head != null) {
			headNode tmp = dummp.next;
			dummp.next = head;
			head = head.next;
			dummp.next.next = tmp;
		}
		headNode cur = dummp.next;
		return cur;
	}

	public static void print(headNode n) {
		if (n == null)
			return;
		System.out.println(n.val);
		print(n.next);
	}

	public static class headNode {
		int val;
		headNode next;

		headNode(int x) {
			val = x;
		}
	}
}
