/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/
import java.util.Arrays;
public class LongestCommonPrefix_14{
	public static void main(String[] args){
		String[] st = {"" , " " , " "};
		String res = longestCommonPrefix(st);
		res = longestCommonPrefix_sort(st);
		System.out.println(res);
	}
	
	public static String longestCommonPrefix_sort(String[] strs) {
		StringBuilder sb = new StringBuilder();
		if(strs == null || strs.length == 0) 
			return sb.toString();
		
		Arrays.sort(strs);
		char[] start = strs[0].toCharArray();
		//System.out.println(Arrays.toString(start));
		//System.out.println(start.length);
		char[] end = strs[strs.length - 1].toCharArray();
//		System.out.println(Arrays.toString(end));
//		System.out.println(end.length);
		int j = 0;
		int m = Math.min(start.length , end.length);
		System.out.println(start.length);
		System.out.println(end.length);
		
		if( start[j] == end[j]){
			sb.append(start[j]);
			j++;
			while(j < m ){
				if(start[j] == end[j]){
						sb.append(start[j]);
						j++;
				}else {
					return sb.toString();
				}
			}			
		}else{
			return "";
		}	
		
		return sb.toString();
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return null;
		String tmp = strs[0];
		int i = 1;
		while( i < strs.length ){
			while(strs[i].indexOf(tmp) != 0){
				tmp = tmp.substring(0 , tmp.length() - 1);
			}
			i++;
		}
		
		return tmp.toString();
    }
	
	public String longestCommonPrefix_2(String[] strs) {
		String prefix = new String();
		int n = strs.length;
		if ( n == 0)
		return prefix;
		if ( n == 1)
		return strs[0];
		int index = 0;
		char c;
		while ( index < strs[0].length()) {
		c = strs[0].charAt(index);
		for ( int i = 1 ; i < n ; i++) {
		if ( index >= strs[i].length() || strs[i].charAt(index) != c )
		return prefix;
		}
		prefix += c;
		index++;
		}
		return prefix;
		}


		public String longestCommonPrefix_1(String[] strs) {
		if (strs == null || strs.length == 0)
		return "";
		int last = 0;
		while (last < strs[0].length()) {
		for (int i = 1; i < strs.length; i++) 
		if (strs[i].length() == last || strs[i].charAt(last) != strs[0].charAt(last))
		return strs[0].substring(0, last);
		last++;
		}
		return strs[0].substring(0, last);
		}

}