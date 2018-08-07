package leetcode.easy;
/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

http://blog.csdn.net/u013027996/article/details/25128335 



*/

public class Count_Say_38{
	public static void main(String[] args){
		int m = 5;
		String s = countAndSay(m);
		System.out.println(s);
	}
	
	public static String countAndSay(int n){
		String[] tmp = new String[n];
		tmp[0] = "1";
		for(int i = 1; i < n ; i++ ){
			char[] arr = tmp[i-1].toCharArray();
			int len = arr.length;
			StringBuilder sb = new StringBuilder();
			int l = 0;
			while(l < len) {
				int j = l+1;
				int count = 1;
				while(j < len && arr[l] == arr[j]){
					count++;
					j++;
				}
				sb.append(count);
				sb.append(String.valueOf(arr[l]));
				l = j;
			}
			tmp[i] = sb.toString();
		}
		return tmp[n-1];
	}
	
}