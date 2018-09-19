/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/
package leetcode.easy;

public class Merge_2SortedList_21 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		printf(n1);

		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		printf(n5);

		ListNode n = Merge_2SortedList(n1, n5);
		printf(n);
	}

	public static ListNode Merge_2SortedList(ListNode n1, ListNode n5) {
		ListNode n = n1;

		return n;
	}

	public static void printf(ListNode n) {
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}