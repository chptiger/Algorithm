package Sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {1,3,5,9,6,8,0,9,3};
		selectionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void selectionSort(int[] arr) {
		if(arr.length < 1) return;
		int global, tmp;
		for(int i = 0; i < arr.length; i++) {
			global = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[global] > arr[j]) {
					global = j;
				}
			}
			tmp = arr[global];
			arr[global] = arr[i];
			arr[i] = tmp;
		}
	}
}
