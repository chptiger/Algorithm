/*
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. 
Could you implement both?

*/
package easy;
public class Reverse_LinkedList_206{
	static int count=0;
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		print(n1);
		
		Reverse_LinkedList_Ite(n1);
		
		Reverse_LinkedList_Rec(n1);
	}
	
	public static void Reverse_LinkedList_Rec(ListNode n1){
		for(int i = 0; i<=count; i++){
			Reverse_LinkedList_Rec_Help( n1, i);
		}
	}
	
	public static void Reverse_LinkedList_Rec_Help(ListNode n1){
		if(n1 == null) return;
		ListNode tmp = n1;
		n1 = n1.next;
		n1.next = tmp;
		Reverse_LinkedList_Rec_Help(n1.next);
	}
	
	public static void print(ListNode n){
		if(n == null) return ;
		System.out.println(n.val);
		count++;
		print(n.next);
	}
}

 class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}