/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0
*/
public class SearchInsertPosition_35{
	public static void main(String[] args){
		int[] nums = { 1,2,4,6,7};
		int target = 3;
		int res = searchInsert( nums, target );
		System.out.println( res );
	}
	// better solution 
	public int searchInsert(int[] A, int target) {
        if( A == null|| A.length <= 0) return 0;
		int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }	
	
	public static int searchInsert(int[] nums, int target) {
         if( nums == null|| nums.length <= 0) return 0;
		int start = 0, end = nums.length-1;
		int middle = 0;
		int len = nums.length;
		int min = nums[0], max = nums[len - 1];
		if( target == nums[0]) return 0; // [1,3] 1
		if( target == nums[len - 1]) return len - 1;// [1,3] 3
		if( target < min && target < max) return 0;// [1,3] 0
		if( target > max && target > min) return nums.length;// [1,3] 4
		//general case
		while( middle < nums.length){
			if( nums[ middle ] > target && nums[ middle - 1 ] < target) return middle ;
			if( nums[ middle ] < target && nums[ middle + 1 ] > target) return middle+1 ;
			if( nums[middle] == target ) return middle ;
			else if( nums[middle] > target) end = middle;
			else start = middle;
			
			middle = start + (end - start)/2;
		}
		return 0;
    }
}