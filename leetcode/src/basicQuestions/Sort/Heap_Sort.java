package sort;

import java.util.Arrays;

public class Heap_Sort {
	public static int heap_size;

	// 双亲编号
	public static int parent(int i) {
		return i / 2;
	}

	// 左孩子编号
	public static int leftChild(int i) {
		return 2 * i;
	}

	// 右孩子编号
	public static int rightChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * 保持最大堆的性质
	 * 
	 * @param a，堆中的数组元素
	 * @param i，对以该元素为根元素的堆进行调整，假设前提：左右子树都是最大堆
	 * 
	 *            由于左右孩子都是最大堆，首先比较根元素与左右孩子，找出最大值，假如不是根元素，则调整两个元素的值；
	 *            由于左孩子（右孩子）的值与根元素交换，有可能打破左子树（右子树）的最大堆性质，因此继续调用，直至叶子元素。
	 */
	public static void max_heapify(int[] a, int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int largest = 0;
		if (left < heap_size && a[i] < a[left]) {
			largest = left;
		} else {
			largest = i;
		}
		if (right < heap_size && a[right] > a[largest]) {
			largest = right;
		}
		if (largest == i) {
			return;
		} else {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			max_heapify(a, largest);
		}
	}

	/**
	 * 建立最大堆。在数据中，a.length/2+1一直到最后的元素都是叶子元素，也就是平凡最大堆，因此从其前一个元素开始，一直到
	 * 第一个元素，重复调用max_heapify函数，使其保持最大堆的性质
	 * 
	 * @param a
	 */
	public static void build_max_heap(int[] a) {
		for (int i = a.length / 2; i >= 1; i--) {
			max_heapify(a, i);
		}
	}

	/**
	 * 堆排序：首先使用建立最大堆的算法建立好最大堆，然后将堆顶元素（最大值）与最后一个值交换，同时使得 堆的长度减小1
	 * ，调用保持最大堆性质的算法调整，使得堆顶元素成为最大值，此时最后一个元素已被排除在外、
	 */
	public static void heapSort(int[] a) {
		build_max_heap(a);
		for (int i = a.length - 1; i >= 2; i--) {
			int temp = a[1];
			a[1] = a[i];
			a[i] = temp;
			heap_size--;
			max_heapify(a, 1);
		}
	}

	public static void main(String[] args) {
		int a[] = { 0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		heap_size = a.length;
		heapSort(a);
		System.out.println("after sorted" + Arrays.toString(a));
		
	}
}