package Algorithm.LinkedList;


/**
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> бн -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> бн -> null
Examples
L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

 * @author Thomas
 *
 */
public class ReOrderLinkedList_23 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		ListNode result = reOrderLinkedList(n1);
		while(result != null){
			System.out.println(result.value);
			result = result.next;
		}
	}
	
	public static ListNode reOrderLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
//		find middle list node 
		ListNode midNode = findMiddleNode(head);
		
		ListNode secondHalf = midNode.next; // copy nodes to the secondHalof
		// why the midNode.next is updated, secondHalf will not be updated? Compare with line 73
		midNode.next = null; 				// cut the original nodes to half half
		
//		reverse second half list node
		ListNode reverseNode = reverseSecondHalf(secondHalf);

//		merge two list node
		return mergeTwoListNode(head, reverseNode);
	}

	private static ListNode curOriginalNode(ListNode head, ListNode midNode) {
		ListNode cur = head;
		while(cur != null) {
			if(cur.value == midNode.value) { // How about if there are more duplicate elements?
				cur.next = null;
				break;
			}
			cur = cur.next;
		}
		return head;
	}

	/**
	 * 1->2->3
	 * 4->5->6
	 * 6->5->4
	 * 
	 * 
	 */
	private static ListNode mergeTwoListNode(ListNode head, ListNode reverseNode) {
		ListNode dumyLeft = head; // when dumyLeft updated, the reference of head is also updated.
		ListNode dumyRight = reverseNode;
		while(dumyRight != null) {
			ListNode tmpRight = dumyRight.next;
			dumyRight.next = dumyLeft.next;
			dumyLeft.next = dumyRight;
			dumyLeft = dumyLeft.next.next;
			dumyRight = tmpRight;
		}
		return head;
	}

	private static ListNode reverseSecondHalf(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode lastNode = reverseSecondHalf(head.next);
		head.next.next = head;
		head.next = null;
		return lastNode;
	}

	private static ListNode findMiddleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}	
}
