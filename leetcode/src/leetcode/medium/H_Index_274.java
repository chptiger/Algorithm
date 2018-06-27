package leetcode.medium;

import java.util.*;
public class H_Index_274 {
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,5};
		int res = hIndex(nums);
		System.out.println( res );
	}
	
	public static int hIndex(int[] citations) {
        if (citations.length <= 0)
            return 0;
        Arrays.sort(citations);

        int len = citations.length,maxH = 0;
        for (int i = len - 1; i >= 0; --i)
        {
            int h = len - i;
            if (citations[i] >= h && h > maxH){
                maxH = h;
            }
            else{
                break;
            }
        }//for
        return maxH;
    }
}
