package leetcode.easy;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 -> a2
					   ->
							c1 -> c2 -> c3
					   ->            
B:     b1 -> b2 -> b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
public class Intersection_2_LinkedList_160 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode m1 = new ListNode(2);
		ListNode m2 = new ListNode(8);
		ListNode m3 = new ListNode(9);
		ListNode m4 = new ListNode(3);
		ListNode m5 = new ListNode(3);
		ListNode m6 = new ListNode(3);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;
		m5.next = m6;

		getIntersectionNode(n1, m1);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

/*
 * 
 * I found most solutions here preprocess linkedlists to get the difference in
 * len. Actually we don't care about the "value" of difference, we just want to
 * make sure two pointers reach the intersection node at the same time.
 * 
 * We can use two iterations to do that.
 * 
 * In the first iteration, we will reset the pointer of one linkedlist to the
 * head of another linkedlist after it reaches the tail node.
 * 
 * In the second iteration, we will move two pointers until they points to the
 * same node.
 * 
 * 
 * Our operations in first iteration will help us counteract the difference.
 * 
 * So if two linkedlist intersects, the meeting point in second iteration must
 * be the intersection point.
 * 
 * If the two linked lists have no intersection at all, then the meeting pointer
 * in second iteration must be the tail node of both lists, which is null
 * 
 * Below is my commented Java code:
 * 
 * 
 * 
 * public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 * //boundary check if(headA == null || headB == null) return null;
 * 
 * ListNode a = headA; ListNode b = headB;
 * 
 * //if a & b have different len, then we will stop the loop after second
 * iteration while( a != b){ //for the end of first iteration, we just reset the
 * pointer to the head of another linkedlist a = a == null? headB : a.next; b =
 * b == null? headA : b.next; }
 * 
 * return a; }
 * 
 */