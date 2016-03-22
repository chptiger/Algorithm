/*

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.

*/

public class Merge_SortedArray_88{
	public static void main(String[] args){
		int[] num1 = {1,2,3,4,,,,};
		int[] num2 = {1,1,2};
		
		int m = num1.length();
		int n = num2.length();
		merge(num1, m, num2, n);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < m ; i++){
			if(num1[i] <= num2[i]){
				merge_tail_Help(nums1, m, num2[i], i);
			}else{
				merge_head_Help(nums1, m, num2[i], i);
			}
		}
    }
	
	public static void merge_tail_Help(int[] nums1, int m, int n, int index){
		for(int i = m; i >= index; i--){
			nums1[i+1] = nums[i];
			nums[i] = n;
		}
	} 
	
	public static void merge_head_Help(int[] nums1, int m, int n, int index){
		for(int i = m; i >= index; i--){
			nums1[i+1] = nums[i];
			nums[i] = n;
		}
	} 
}