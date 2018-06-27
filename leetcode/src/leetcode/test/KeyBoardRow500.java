package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyBoardRow500 {
	public static void main(String[] args) {
		String[] test = {"asdfghjkla","qwertyuiopq","zxcvbnzzm","asdfghjkla","qwertyuiopq","zxcvbnzzm"};
		System.out.println(Arrays.toString(findWords(test)));
	}
	
	public static String[] findWords(String[] words) {
        String a = "qwertyuiop";int a1 = 0;
        String b = "asdfghjkl"; int b1 = 0;
        String c = "zxcvbnm"; int c1 = 0;
        List<String> re = new ArrayList<>(); 
        for(int i = 0; i < words.length; i++){
            char[] tmp = words[i].toLowerCase().toCharArray();
            for(int j = 0; j < tmp.length; j++){
                if(a.contains(tmp[j]+"")){
                    a1++;
                }
                if(b.contains(tmp[j]+"")){
                    b1++;
                }
                if(c.contains(tmp[j]+"")){
                    c1++;
                }
            }
            if(a1 == tmp.length || b1 == tmp.length || c1 == tmp.length){
                re.add(words[i]);
            }
            a1 = 0; b1 = 0; c1 = 0;
        }
        return re.toArray(new String[re.size()]);
     }
}
