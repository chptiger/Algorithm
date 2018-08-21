package Algorithm.LinkedList;

import entities.ListNode;

/**
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. 
The original relative order of the nodes in each of the two partitions should be preserved.

Examples
L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

  * @author Thomas
 *
 */
public class PartitionLinkedList_22 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n5;
		ListNode result = partitionLinkedList(n1, 3);
		while(result != null){
			System.out.println(result.value);
			result = result.next;
		}
	}
	
	public static ListNode partitionLinkedList(ListNode head, Integer Target) {
		if (head == null || head.next == null) return head; 
		ListNode leftNodes = new ListNode(0);
		ListNode curLeft = leftNodes;
		ListNode rightNodes = new ListNode(0);
		ListNode curRight = rightNodes;
		while (head != null) {
			if(head.value < Target) {
				curLeft.next = head;
				curLeft = curLeft.next;
			} else {
				curRight.next = head;
				curRight = curRight.next;
			}
			head = head.next;
		}
		curLeft.next = rightNodes.next;
		return leftNodes.next;
	}
}
