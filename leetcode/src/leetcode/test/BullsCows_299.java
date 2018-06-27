
/* http://blog.csdn.net/xyt8023y/article/details/49586183 
 题目描述
题目要求对secret和guess进行比对，找出bull和cow:
bull指的是位置相同且字符相同的情况，
cow指的是guess中的数在secret中出现过，但是位置不同。

需要特别注意的是多个重复字符的情况，在匹配出一个bull后，那个字符就不能再被cow匹配了，因此需要计数当前还剩下多少个secret字符未被bull匹配。
并且bull匹配优先于cow匹配。

解法一
通过一个secretMap记录出现的字符以及出现次数，先遍历一边guess，找出所有cow，并且记录下所有可能的bull字符。
接着对所有可能的bull字符进行遍历，通过查询secretMap判断是否可以匹配。这种方法的效率略低

解法二
通过一个count[10]来记录字符0~9的次数，然后遍历secret和guess，如果相同，则匹配为cow。
如果不同，则约定每当secret中出现字符s，就把s计数+1；每当guess中出现字符g，就把g计数-1。

这样，当s计数+1，并且发现s的计数≤0，说明有guess中的字符s已经在等待匹配，因此应该把bull计数加一。
同理，当g计数-1，并且发现g的计数≥0，说明有secret字符可匹配为bull，也应当把bull计数加一，这种算法比较高效。
 */
public class BullsCows_299 {
	public static void main(String[] args){
		String secret = "1012";
		String guess = 	"2034";
		
		String hints = getHint(secret , guess);
		System.out.println(hints);
	}
	
	public static String getHint(String secret, String guess) {
	    int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        int s = Character.getNumericValue(secret.charAt(i));
	        int g = Character.getNumericValue(guess.charAt(i));
	        if (s == g) bulls++;
	        else {
	            if (numbers[s] < 0) cows++;
	            if (numbers[g] > 0) cows++;
	            numbers[s] ++;
	            numbers[g] --;
	        }
	    }
	    return bulls + "A" + cows + "B";
	}
}
