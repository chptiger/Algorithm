/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 

Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
package easy;
public class Happy_Number_202{
	public static void main(String[] args){
		int n = 19;
		boolean flag = Happy_Number(n);
		System.out.println(flag);
	}
	
	public static boolean Happy_Number(int n){
		int[] a = int2Array_Help(n);
		int tmp = 0;
		for(int i = 0; i< a.length;i++){
			tmp += a[i]*a[i];
		}
		
		if(tmp == 1) {
			return true;
		}else {
			try{
				return Happy_Number(tmp);
			} catch(Exception e){
				return false;
			}
		}
	}
	
	public static int[] int2Array_Help(int n){
		String s = Integer.toString(n);
		//System.out.println(s.length());  2
		int[] a = new int[s.length()];
		int i = 0;
		while(n!=0){
			a[i] = n%10;
			//System.out.println("a[i] = "+a[i]);
			//System.out.println("n%10 = "+n%10);
			n = n/10;
			//System.out.println("n = "+n);
			i++;
			
		}
		return a;
	}
}

/*
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            int result = 0;
            while (n != 0) {
                result += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }
}

*/
