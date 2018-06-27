package leetcode.medium;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that
*/
public class GrayCode_89{
	public static void main(String[] args){
		int n = 2;
		List<Integer> res = grayCode(n);
		System.out.println( res );
	}
	
	public static List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
//	    1<<n = 1*2^n
	    for (int i = 0; i < 1<<n; i++) {
//	    æ ¼é›·ç �æœ‰ä¸ªå…¬å¼�ï¼Œè‡ªç„¶æ•´æ•°nå¯¹åº”çš„æ ¼é›·ç �ä¸ºï¼š 
//	    	n ^ (n/2)
	    	result.add(i ^ i>>1);
	    }
	    return result;
	}
	
}


/*
public ArrayList<Integer> grayCode(int n) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(0);
    for(int i=0;i<n;i++){
        int inc = 1<<i;
        for(int j=arr.size()-1;j>=0;j--){
            arr.add(arr.get(j)+inc);
        }
    }
    return arr;
}


vector<int> grayCode(int n) {
    unordered_set<int> s{0};
    vector<int> r{0};
    for (int c = 0, i = 1; i < (1<<n); ++i) {
        for (int j = 0; j < n; ++j) {
            if (s.insert(c ^ (1<<j)).second) {
                r.push_back(c ^= (1<<j));
                break;
            }
        }
    }
    return r;
}*/