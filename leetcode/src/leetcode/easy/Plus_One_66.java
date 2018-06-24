/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
package leetcode.easy;
import java.util.Arrays;
public class Plus_One_66{
	public static void main(String[] args){
		
		int[] m = {9,9,9};
		Plus_One(m);
		
	}
	
	public static void Plus_One(int[] m){
		int s = 0;
		int l = m.length;
		int count = 0;
		System.out.println(Arrays.toString(m));
		
		if(m[l-1] < 9){
			m[l-1] = m[l-1] + 1;
		}
		
		for(int i = 0; i<= l-1; i++){
			s += m[i] * Math.pow(10,(l-i-1));
				System.out.println(s);
			if(m[i] == 9) count++;
		}
		
		if(count == l) {
			l++;
			int[] new_array = new int[l];
		}
		
			int[] new_array = new int[l];
		
		
		s++;
			
		//System.out.println(s);	
		//System.out.println(l);	
		while(s >=0 && l >=1 ){
			new_array[l-1] = s%10;
			//System.out.println(s%10);
			s=s/10;
			//System.out.println(s);
			l--;
		}
			
	System.out.println(Arrays.toString(new_array));
	}
}