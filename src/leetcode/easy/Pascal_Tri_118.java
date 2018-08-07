/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
package leetcode.easy;
import java.util.LinkedList;
public class Pascal_Tri_118{
	public static void main(String[] args){
		int n = 10;
		LinkedList<LinkedList<Integer>> arr = Pascal_Tri(n);
		System.out.println(arr);
		
	}
	
	public static LinkedList<LinkedList<Integer>> Pascal_Tri(int n) {
        LinkedList<LinkedList<Integer>> a = new LinkedList<LinkedList<Integer>>();
		a.add(new LinkedList<Integer>());
		a.add(new LinkedList<Integer>());
		a.get(0).add(1);
		a.get(1).add(1);
		a.get(1).add(1);
		generate_Pascal_Tri(a, 2, n);
		return a;
    }
	
	public static void generate_Pascal_Tri(LinkedList<LinkedList<Integer>> a, int level,int n){
		if(level == n) return;
		
		if(level >= a.size()){
			LinkedList<Integer> cur = new LinkedList<Integer>();
			cur.add(1);
			
			int length = a.get(level-1).size();
			LinkedList<Integer> pre = a.get(level-1);
			
			for(int i = 1; i<length; i++){
			cur.add(pre.get(i) + pre.get(i-1));
		}
		
		cur.add(1);
		a.add(cur);
		}
		generate_Pascal_Tri(a, level+1, n);
	}
}