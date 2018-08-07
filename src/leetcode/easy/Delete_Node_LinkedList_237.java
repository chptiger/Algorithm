/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
the linked list should become 1 -> 2 -> 4 after calling your function.
*/
package leetcode.easy;
import java.util.Arrays;
public class Delete_Node_LinkedList_237{
	public static void main(String [] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
				
		Delete_Node_LinkedList(n3);
		while(n1!=null){
			System.out.println(n1.val);
			n1 = n1.next;
		}
		
		
	}
	
	public static void Delete_Node_LinkedList(ListNode n){
			n.val = n.next.val;
			n.next = n.next.next;
		
	}
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
}