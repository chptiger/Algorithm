package leetcode.test;

public class char_test {
	public static void main(String[] args){
		char[] test = "".toCharArray();
		for( int i = 0; i < test.length; i++){
		System.out.println(test[i]);
		
		}
		System.out.println(test.equals('\u0000'));
		System.out.println(test.equals("".toCharArray()));
		System.out.println(test=="".toCharArray());
		System.out.println(String.valueOf(test) == "");
		System.out.println(test.length);
	}
}
