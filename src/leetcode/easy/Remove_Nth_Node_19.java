package leetcode.easy;
/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
public class Remove_Nth_Node_19{
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		//ListNode n3 = new ListNode(3);
		//ListNode n4 = new ListNode(4);
		//ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		//n2.next = n3;
		//n3.next = n4;
		//n4.next = n5;
		
		ListNode head = Remove_Nth_Node( n1 , 2 );
		
		while(head!=null){
			System.out.println( head.val);
			head = head.next;
		}
	}
	
	public static ListNode Remove_Nth_Node(ListNode head, int n){
		if(n <= 0 ) return head;
		if(head.next == null ) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tmp = head;
		
		int i = 1;
		while( i <= n && tmp != null){
			System.out.println("=====" + tmp.val);
			tmp = tmp.next;
			i++;
		}
		
		if( tmp == null){
			dummy.next = dummy.next.next;
			return dummy.next;
		} 
		
		while(tmp.next != null){
			head = head.next;
			tmp = tmp.next;
		}
		head.next = head.next.next;
		return dummy.next;
	}
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
}

/*

A one pass solution can be done using pointers. 
Move one pointer fast --> n+1 places forward, 
to maintain a gap of n between the two pointers and then move both at the same speed. 
Finally, when the fast pointer reaches the end, 
the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.

Since the question gives that n is valid, not too many checks have to be put in place. Otherwise, this would be necessary.


public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;

    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}
*/
