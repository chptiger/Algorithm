package leetcode.medium;
/*
318 Max Product of Word Lengths

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
where the two words do not share common letters. 
You may assume that each word will contain only lower case letters. 
If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words
*/
import java.util.Arrays;
import java.util.Comparator;
public class MaxWordlength_318{
	public static void main(String[] args){
		String[] arr = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		int res = maxProduct( arr );
		System.out.println( res );
	}
	
	public static int maxProduct(String[] words) {
        if( words == null || words.length <= 1 ) return 0;
		
		Arrays.sort( words, new Comparator<String>(){
			public int compare(String s1, String s2){
				return s2.length() - s1.length();
			}
		});
		//System.out.println( Arrays.toString(words));
		int[] mask = new int[words.length];
		
		for( int i=0; i < words.length; i++){
			for( char s:words[i].toCharArray()){
				mask[i] |= 1 << (s - 'a');   // 'a' - 'a' = 0, left romve 0 position. every charcater has its flag, 0 means not exist, 1 means exit;
			}
		}
		int max = 0;
		for( int i=0; i<mask.length; i++){
				if(words[i].length() * words[i].length() <= max) break;  // words is sorted with order of descending 5 4 3 2 1
			for( int j = i+1; j<mask.length; j++){
				if( (mask[i] & mask[j]) == 0){ // like 0110 1001, the two words do not have same character.
					max = Math.max(max, words[i].length() * words[j].length());
					break;
				}
					
			}
		}
		
		return max;
    }
}






