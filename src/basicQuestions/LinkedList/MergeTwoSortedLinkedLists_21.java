package Algorithm.LinkedList;

import entities.ListNode;

/**
 * Given a linked list and a target value T, partition it such that all nodes
 * less than T are listed before the nodes larger than or equal to target value
 * T. The original relative order of the nodes in each of the two partitions
 * should be preserved. Examples L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is
 * partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 * 
 * @author Thomas
 *
 */
public class MergeTwoSortedLinkedLists_21 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n5.next = n6;
		n6.next = n7;
		ListNode result = mergeTwoSortedLinkedLists(n1, n5);
		while (result != null) {
			System.out.println(result.value);
			result = result.next;
		}
	}

	public static ListNode mergeTwoSortedLinkedLists(ListNode head1, ListNode head2) {
		ListNode dumpNode = new ListNode(0);
		ListNode cur = dumpNode;
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}

		if (head2 != null) {
			cur.next = head2;
		} else {
			cur.next = head1;
		}

		return dumpNode.next;
	}
}
