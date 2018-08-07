package leetcode.medium;

/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

public class LinkedListCircle_141{
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l1;
		
		boolean circle = hasCycle( l1 );
		System.out.println( circle );
	}
	
	public static boolean hasCycle(ListNode head) {
		if( head == null) return false;
        ListNode slow = head;
		ListNode fast = head;
		
		while(true){
			slow = slow.next;
			if(fast.next != null){
				fast = fast.next.next;
			}else{
				return false;
			}
			if( slow == fast) return true;
			if( slow == null || fast == null) return false;
		}
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