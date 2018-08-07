package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII140 {

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new LinkedList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("sand");
		wordDict.add("and");
		
		Set<String> dict = new HashSet<>(wordDict);
        Map<String, LinkedList<String>> res = new HashMap<>();
		System.out.println(wordBreak(s, dict, res));
		
	}
	
	 public static List<String> wordBreak(String s, Set<String> dict, Map<String, LinkedList<String>> res) {
	        if(res.containsKey(s)) return res.get(s);
	        
	        LinkedList<String> tmp = new LinkedList<>(); 
	        
	        if(dict.contains(s)) tmp.add(s);
	        
	        for(int i = 0; i < s.length(); i++) {
	            //check wether right part is a word
	            if(!dict.contains(s.substring(i))) continue;
	            
	            //get ans for left part
	            List<String> left = append(wordBreak(s.substring(0,i), dict, res), s.substring(i));
	            
	            tmp.addAll(left);
	        }
	         res.put(s, tmp);
	        return res.get(s);
	    }
	    
	    // >> append({"cats and", "cat sand"}, "dog");
	    // {"cats and dog", "cat sand dog"}
	    public static List<String> append(List<String> pres, String post) {
	        List<String> str = null;
	        for(String pre:pres) {
	            str.add(pre + " " + post);
	        }
	        return str;
	    }
	    
}
