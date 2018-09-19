/*
 *    If  arr.length == 0, this is an empty array;
      If declare an array, without declare default value of each element, this is an empty array and default value is null, the array is not null;
      In the case of int arr[] = null; we can use if (arr== null)

 * */

public class Array_Null_Empty {
	public static void main(String[] args) {
		int[] arr = null;
		if (arr == null)
			System.out.println("arr is null");

		int[] b = new int[10]; // default is null
		if (b == null)
			System.out.println("b is null");

		int[] c = new int[0];
		if (c == null)
			System.out.println("c is null");
		if (c.length == 0)
			System.out.println("c is null +++++++++");
	}
}
