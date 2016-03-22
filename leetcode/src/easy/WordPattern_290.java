/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
pattern = "itwas", str = "i ttttttttttttttttttttt wwwwwww aa ssssss"; return true;
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/
import java.util.Hashtable;
public class WordPattern_290{
	public static void main(String[] args){
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean flag = WordPattern_wrong(pattern, str);
		flag = WordPattern(pattern, str);
		System.out.println(flag);
	}
	// solution: same pattern, same string
	public static boolean WordPattern(String pattern , String str){
		String[] s = str.split(" ");
		if(pattern.length() != s.length) return false;
		char[] cur = str.toCharArray();
		Hashtable<Character, String> tmp = new Hashtable<Character , String>();
		for(int i = 0; i < s.length; i++){
			if(tmp.containsKey(pattern.charAt(i)) && !tmp.containsValue(s[i])){
				return false;
			}
			else if(!tmp.containsKey(pattern.charAt(i)) && tmp.containsValue(s[i])){
				return false;
			}else
			tmp.put(pattern.charAt(i), s[i]);
		}
		return true;
	}
	//	y=129  yyyyyyyyyyy=129 return false. 
	//	char arrange is -127~127
	public static boolean WordPattern_wrong(String pattern , String str){
		HashMap<String, Integer> m1 = new HashMap<String, Integer>();
		HashMap<String, Integer> m2 = new HashMap<String, Integer>();
		String[] s = str.split(" ");
		if(pattern.length() != s.length) return false;
		
		for(int i = 0; i < pattern.length(); i++){
			if(!m1.containsKey(pattern.charAt(i))) 
				m1.put(pattern.charAt(i) , i+1);
			if(!m2.containsKey(s[i])) 
				m2.put(s[i] , i+1);
			if(m1.get(pattern.charAt(i)) != m2.get(s[i])) 
				return false;
		}
		
		return true;
	}
}