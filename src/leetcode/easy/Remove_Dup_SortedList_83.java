/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3
*/
package leetcode.easy;
public class Remove_Dup_SortedList_83{
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		printf(n1);
		
		Remove_Dup_SortedList(n1);
		printf(n1);
	}
	
	public static void Remove_Dup_SortedList(ListNode n){
		if(n.next == null) return ;
		
		while(n.next !=null){
			if(n.val == n.next.val){
				n.next = n.next.next;
				if(n.next == null) break;// 1-1-2-3-3
			}
			n = n.next;
		}
	}
	
	public static void printf(ListNode n1){
		while(n1!=null){
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
}