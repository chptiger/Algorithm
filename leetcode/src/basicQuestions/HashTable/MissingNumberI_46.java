package basicQuestions.String;

import java.util.Arrays;

/*
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
Assumptions
The given array is not null, and N >= 1
Examples
A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1
*/
public class MissingNumberI_46 {

	public static void main(String[] args) {
		int[] arr = {1,3,4};
		System.out.println(missingNumber(arr, 4));
	}
	
	public static int missingNumber(int[] arr, int n) {
		if(arr.length <= 0) return 1;
		int result = Arrays.stream(arr).sum();
		return (n * (n + 1)) / 2 - result;
	}
}
