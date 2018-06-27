package sort;

import java.util.Arrays;
//http://blog.csdn.net/morewindows/article/details/6684558 
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 2, 3, 6, 8 };
		int low = 0;
		int high = arr.length - 1;
		quickSort(arr, low, high);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0) {
			return;
		}

		if (low >= high) {
			return;
		}

		int mid = low + ( high - low ) / 2;
		int pivot = arr[mid];
		int i = low;
		int j = high;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}

		}

		if (j > low) {
			quickSort(arr, low, j);
		}

		if (high > i) {
			quickSort(arr, i, high);
		}
	}


/*
 * public void quickSort(int[] nums) {
	         
	        if (nums == null || nums.length == 0) {
	            return;
	        }
	        int n = nums.length;
	        quickSort(nums, 0, n - 1);
	    }
	 
	    private void quickSort(int[] nums, int lower, int higher) {
	         
	        int i = lower;
	        int j = higher;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = nums[lower + (higher - lower) / 2];
	        // Divide into two arrays
	        while (i <= j) {
	            
//	             * In each iteration, we will identify a number from left side which
//	             * is greater then the pivot value, and also we will identify a number
//	             * from right side which is less then the pivot value. Once the search
//	             * is done, then we exchange both numbers.
	             
	            while (nums[i] < pivot) {
	                i++;
	            }
	            while (nums[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                swap(nums, i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lower < j)
	            quickSort(nums, lower, j);
	        if (i < higher)
	            quickSort(nums, i, higher);
	    }
	 
		  private void swap(int[] nums, int i, int j) {
			    if (i == j)  return;
			    int tmp = nums [i]; 
			    nums[i] = nums [j];
			    nums[j] = tmp;
			  }
 * */
 
}
