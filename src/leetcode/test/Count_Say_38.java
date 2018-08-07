/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

http://blog.csdn.net/u013027996/article/details/25128335 

1)、1
2)、11，表示1)有1个1，组合起来就是11。
3)、21，表示2)有2个1，组合起来就是21。
4)、1211，表示3)有1个2，2个1，组合起来就是1211。
5)、111221，表示4)有1个1，1个2，2个1，组合起来就是111221。
6)、312211，表示5)有3个1，2个2，2个1，组合起来就是312211 
										 13112221
										 1113213211
										 31131211131221
										 1321131112311311211
.......
以此类推。
其实就是统计连续的相同的字符的个数。考察基本功。

*/

public class Count_Say_38{
	public static void main(String[] args){
		int m = 13;
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