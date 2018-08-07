import java.util.Arrays;

/*
 * http://www.mitbbs.com/article_t/JobHunting/33054453.html 
 aaabbbbccddd，返回最长的连续相同字符的子串。
这个例子，应该返回bbbb。

代码还快写完，其中有一句是
for(int i = 1; i < str.size(); i++){
   这里访问 str[i]
}
然后她非说当str的size是1时，我code有问题，因为访问str[i]越界了。
我说当size是1的时候循环进不去啊，condition i<str.size() 是false啊。。
她说能进去，刚开始进入循环的时候不check condition。。
 */
public class Longest_String {
	public static void main(String[] args){
		String s = "1";
		for( String i:s.split(".")){
			System.out.println(i);
		}
//		char[] t = s.toCharArray();
//		System.out.println(Arrays.toString(t));
//		for( int i = 0 ; i < t.length - 1; i++){
//			if( t[i] == '.')
//			System.out.println( t[i]);
//		}
		for( String i:s.split("\\.")){
			System.out.println(i);
		}
	}
}
