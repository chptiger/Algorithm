package Sort;
import java.util.Arrays;

public class QuickSort
{
	public static void main(String[] args)
	{
		Integer[] a = {2, 4, 1, 6, 8};
		int low = 0, high = a.length - 1;
		quickSort(a, low, high);
		System.out.println(Arrays.toString(a));
	}

	private static void quickSort(Integer[] a, int low, int high) {
		if(a == null || a.length < 1) return;
		if(low >= high) return;
		int middle = low + (high - low) / 2, pivot = a[middle];
		int i = low, j = high;
		while(i < j) {
			while(a[i] < pivot) {
				i++;
			}
			while(a[j] > pivot){
				j--;
			}
			if(i <= j){  //  TODO: we need swap "==" to jump out the while loop
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}
		if(low < j) quickSort(a, low, j); 
		if(high > i) quickSort(a, i, high);
		
	}
 }