package leetcode.easy;
/*

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

*/
public class Remove_LinkedList_203{
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		ListNode head = removeElements(n1, 6);
		
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
        while(dummy.next!= null){
			if(dummy.next.val == val){
				dummy.next = dummy.next.next;
			}else{
				dummy = dummy.next;
			}
		}
		
		return cur.next;
    }
	
	static class ListNode {
      int val;
      ListNode next;
	  ListNode(int x) { val = x; }
	}
}