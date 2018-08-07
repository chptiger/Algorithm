public class SearchInsertPosition_35{
	public static void main(String[] args){
		int[] nums = { 1,2,4,6,7};
		int target = 3;
		int res = searchInsert( nums, target );
		System.out.println( res );
	}
	
	public static int searchInsert(int[] nums, int target) {
        if( nums == null|| nums.length <= 0) return 0;
		int start = 0, end = nums.length-1;
		int middle = start + (end - start)/2;
		int len = nums.length;
		int min = nums[0], max = nums[len - 1];
		if( target < min && target < max) return 0;
		if( target > max && target > min) return nums.length;
		
		while( middle < nums.length){
			if( nums[ middle ] > target && nums[ middle - 1 ] < target) return middle-1 ;
			if( nums[ middle ] < target && nums[ middle + 1 ] > target) return middle+1 ;
			if( nums[middle] == target ) return middle ;
			else if( nums[middle] > target) end = middle;
			else {
				start = middle;
			}
			
			middle = start + (end - start)/2;
		}
		return 0;
    }
}