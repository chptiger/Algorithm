
public class Dummy_Node {
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode head = removeNthFromEnd( n1 , 2 );
		
		while(head!=null){
			System.out.println( head.val);
			head = head.next;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {

	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;

	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n; i++)   {
	        fast = fast.next;
	        System.out.println( "fast value is " + fast.val);
	    }
	    
	    if(fast.next == null){
	    	start.next = start.next.next;
	    	return start.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast.next != null) {
	        slow = slow.next;
	        System.out.println( "slow value is " + slow.val);
	        fast = fast.next;
	        System.out.println( "fast value is " + fast.val);
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
}
