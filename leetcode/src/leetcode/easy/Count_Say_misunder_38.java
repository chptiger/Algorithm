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

1)�?1
2)�?11，表示1)有1个1，组�?�起�?�就是11。
3)�?21，表示2)有2个1，组�?�起�?�就是11。
4)�?1211，表示3)有1个2，2个1，组�?�起�?�就是1121。
5)�?111221，表示4)有1个1，1个2，2个1，组�?�起�?�就是111221。
6)�?312211，表示5)有3个1，2个2，2个1，组�?�起�?�就是312211
.......
以此类推。
其实就是统计连续的相�?�的字符的个数。考察基本功。

*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Count_Say_misunder_38{
	public static void main(String[] args){
		int m = 211113;
		String s = countAndSay(m);
		System.out.println(s);
	}
	
	public static String countAndSay(int n) {
        String s = String.valueOf(n);
		char[] tmp = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int a = 0, b =0, c = 0, d = 0, e = 0, f = 0,g = 0, h = 0, i = 0, j = 0;
		String output = "";
		for(int l = 0; l < tmp.length; l++){
			
			switch(tmp[l]){
				case '0':
					map.put('0', ++a );
					break;
				case '1':
					map.put('1', ++b );
					System.out.println("number of 1");
					System.out.println(map.get('1'));
					break;
				case '2':
					map.put('2', ++c );
					System.out.println("number of 2");
					System.out.println(map.get('2'));
					break;
				case '3':
					map.put('3', ++d );
					System.out.println("number of 3");
					System.out.println(map.get('3'));
					break;
				case '4':
					map.put('4', ++e );
					break;
				case '5':
					map.put('5', ++f );
					break;
				case '6':
					map.put('6', ++g );
					break;
				case '7':
					map.put('7', ++h );
					break;
				case '8':
					map.put('8', ++i );
					break;
				case '9':
					map.put('9', ++j );
					break;
			}
		}
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			output += pair.getValue() + "" + pair.getKey()+ "";
		}
		return output;
    }
}