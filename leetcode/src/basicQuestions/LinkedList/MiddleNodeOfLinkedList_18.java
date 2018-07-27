package Algorithm.LinkedList;

import POJO.ListNode;

/**
 * 
Find the middle node of a given linked list.
Examples
L = null, return null
L = 1 -> null, return 1
L = 1 -> 2 -> null, return 1
L = 1 -> 2 -> 3 -> null, return 2
L = 1 -> 2 -> 3 -> 4 -> null, return 2

 * @author Thomas
 *
 */
public class MiddleNodeOfLinkedList_18 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(middleNodeOfLinkedList(n1).value);
	}
	
	public static ListNode middleNodeOfLinkedList(ListNode n1) {
		if(n1 == null || n1.next == null) {
			return n1;
		}
		ListNode slow = n1;
		ListNode fast = n1;
		while(fast.next != null && fast.next != null) {
			slow = slow.next;
			fast = slow.next.next;
		}
		return slow;
	}
}

