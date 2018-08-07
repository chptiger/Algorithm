package leetcode.easy;
/*

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

public class Impl_strStr_28{
	public static void main(String[] args){
		String haystack = "a";
		String needle = "a";
		//int n = strStr_cha(haystack, needle);
		int n = strStr(haystack, needle);
		System.out.println(n);
	}
	
	public static int strStr(String haystack, String needle) {
		if(haystack == null) return -1;
		if(haystack.equals("") && !needle.equals("")) return -1;// "" "a"
		if(haystack.equals("") && needle.equals("")) return 0;// "" ""
		int len = needle.length()-1;
		for(int i = 0; i < haystack.length() - len; i++){
			if(haystack.subSequence(i, i + len+1).equals(needle)) return i;
		}
		return -1;
	}
	
	
	// index is a character
	public static int strStr_cha(String haystack, String needle) {
        char[] tmp = haystack.toCharArray();
        
        if(haystack == null || haystack.equals("")) return 0;
       
        for(int i = 0; i < tmp.length; i++){
            if(needle.equals(String.valueOf(tmp[i])))
            return i;
        }
        return -1;
    }
	
	
}