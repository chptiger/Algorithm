package Sort;

import java.util.Arrays;

/**
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
 * 
 * Sorting is ordering a list of objects. We can distinguish two types of
 * sorting. If the number of objects is small enough to fits into the main
 * memory, sorting is called internal sorting. If the number of objects is so
 * large that some of them reside on external storage during the sort, it is
 * called external sorting. In this chapter we consider the following internal
 * sorting algorithms
 * 
 * Bucket sort 
 * Bubble sort 
 * Insertion sort 
 * Selection sort 
 * Heapsort 
 * Mergesort
 * 
 * 
 * Q1. insertion sort vs merge sort?
 * 1. merge sort O(n) quxiliary space
 *    insertion sort is in-place sort ---> o(1) quxiliary space
 *    
 * merge sort i Python = 2.2 nlgn microseconds
 * insertion sort in Python = 0.2 n*n microseconds
 * insertion sort in C =      0.01 n*n microseconds
 * @author Thomas
 *
 */
public class InternalSorts {
	public static void main(String[] args) {
		int[] arr1 = {8, 7, 3, 1, 6};
		bubbleSort(arr1);
		
		int[] arr2 = {8, 7, 3, 1, 6};
		selectionSort(arr2);
		
		int[] arr3 = {8, 7, 3, 1, 6};
		insertionSort(arr3);
		
		int[] arr4 = {8, 7, 3, 1, 6};
		mergeSort(arr4);
		
		System.out.println(7%4 == 0);
	}

	private static void mergeSort(int[] arr4) {
		
	}

	/**Let us compute the worst-time complexity of the insertion sort. In sorting the most expensive part is a comparison of two elements. 
	 * Surely that is a dominant factor in the running time. We will calculate the number of comparisons of an array of N elements:
		we need 0 comparisons to insert the first element
		we need 1 comparison to insert the second element
		we need 2 comparisons to insert the third element
		...
		we need (N-1) comparisons (at most) to insert the last element
		Totally,
		1 + 2 + 3 + ... + (N-1) = O(n2)
		The worst-case runtime complexity is O(n2).What is the best-case runtime complexity? O(n).
		
		
		note:
		binary insertion sort, save compare time, not saving swap times.
		compare is more expensive than swap
	 */
	private static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int index = arr[i]; 
			int j = i-1;
			/**
			 * Move elements of arr[0,..i-1], that are greater than key,
			 * to one position ahead of their current position
			 */
			while(j >= 0 && arr[j] > index) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = index;
		}
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * The selection sort works as follows: you look through the entire array
	 * for the smallest element, once you find it you swap it (the smallest
	 * element) with the first element of the array. Then you look for the
	 * smallest element in the remaining array (an array without the first
	 * element) and swap it with the second element. Then you look for the
	 * smallest element in the remaining array (an array without first and
	 * second elements) and swap it with the third element, and so on. Here is
	 * an example,
	 * 
	 * The worst-case runtime complexity is O(n2).
	 * @param arr
	 */
	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i; j < arr.length; j++){
				if(arr[min] > arr[j]) min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * The algorithm works by comparing each item in the list with the item next
	 * to it, and swapping them if required. In other words, the largest element
	 * has bubbled to the top of the array. The algorithm repeats this process
	 * until it makes a pass all the way through the list without swapping any
	 * items.
	 * 
	 * The worst-case runtime complexity is O(n2).
	 * @param arr
	 */
	private static void bubbleSort(int[] arr) {
		int tmp = 0;
		for(int i = arr.length-1; i >= 0; i--) {
			for(int j = 1; j <= i; j++){
				if(arr[j-1] > arr[j]){
					tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
