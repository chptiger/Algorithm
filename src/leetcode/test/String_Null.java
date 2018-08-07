import java.util.Arrays;

public class String_Null {
	public static void main(String[] args){
		String s = " "; 	 char[] tmp = s.toCharArray();	//	s.length() = 0;	tmp.length =1	[]
		System.out.println(Arrays.toString(tmp));
		System.out.println((String.valueOf(tmp[0])).equals(" "));
	}
}
