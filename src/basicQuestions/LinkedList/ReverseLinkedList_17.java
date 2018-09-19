package Algorithm.LinkedList;

import entities.ListNode;

/**
 * Reverse a singly-linked list. Examples L = null, return null L = 1 -> null,
 * return 1 -> null L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 * 
 * @author Thomas
 *
 */
public class ReverseLinkedList_17 {
	public ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode nextNode = head.next; // keep control the head node.
			cur.next = pre; // reverse linkedlist
			pre = cur;
			cur = nextNode;
		}
		return pre;
	}

	public ListNode reverseLinkedListRecursion(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseLinkedListRecursion(head.next); // ���ײŷ���

		head.next.next = head;
		head.next = null;
		return nextNode; // ��Զ���صĶ������һ��node��nextNode��
	}
}
