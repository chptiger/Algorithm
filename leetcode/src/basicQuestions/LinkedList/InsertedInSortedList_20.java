package Algorithm.LinkedList;


/**
Insert a value in a sorted linked list.
Examples
L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
  * @author Thomas
 *
 */
public class InsertedInSortedList_20 {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n5;
		System.out.println(insertedInSortedList(n1, n4));
	}
	
	public static ListNode insertedInSortedList(ListNode head, ListNode node) {
		if( head == null){
			return node;
		}
		
		if (head.value > node.value) {
			node.next = head;
			return node;
		}
		
		ListNode cur = head;
		while (cur.next != null && cur.next.value < node.value) {
			cur = cur.next;
		}
		node.next = cur.next;
        cur.next = node;
        
     return head;
	}
}
