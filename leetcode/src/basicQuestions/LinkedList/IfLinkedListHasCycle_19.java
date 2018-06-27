package Algorithm.LinkedList;


/**
 * Check if a given linked list has a cycle. Return true if it does, otherwise return false.
 * @author Thomas
 *
 */
public class IfLinkedListHasCycle_19 {
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
		System.out.println(isLinkedListHasCircle(n1));
	}
	
	public static boolean isLinkedListHasCircle(ListNode head) {
		if( head == null || head.next == null || head.next.next == null){
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
}
