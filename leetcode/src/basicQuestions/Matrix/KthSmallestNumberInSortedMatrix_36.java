package Algorithm.Matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Given a matrix of size N x M. 
For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. 
Find the Kth smallest number in it.

Assumptions
the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M

Examples
{ {1,  3,   5,  7},
  {2,  4,   8,   9},
  {3,  5, 11, 15},
  {6,  8, 13, 18} }
the 5th smallest number is 4
the 8th smallest number is 6
 *
 */
public class KthSmallestNumberInSortedMatrix_36 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 1, 1, 1, 1 }, 
				{ 1, 1, 2, 9 },
				{ 2, 5, 11, 15 }, 
				{ 6, 8, 13, 18 } };
		System.out.println(findIthSmallestNumber(matrix, 6));
	}
	
	public static int findIthSmallestNumber(int[][] matrix, int index) {
		if (matrix == null) {
			return -1;
		}
		int row = matrix.length;
		int column = matrix[0].length;

		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(index,
				new Comparator<Cell>() {
					public int compare(Cell o1, Cell o2) {
						if (o1.key == o2.key) {
							return 0;
						}
						return o1.key < o2.key ? -1 : 1;
					}
				});
		boolean[][] visited = new boolean[row][column];
		queue.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;
		for (int i = 0; i < index - 1; i++) {
			Cell cur = queue.poll();
			if (cur.row + 1 < row && !visited[cur.row + 1][cur.column]) {
				visited[cur.row + 1][cur.column] = true;
				queue.offer(new Cell(cur.row + 1, cur.column,
						matrix[cur.row + 1][cur.column]));
			}
			if (cur.column + 1 < column && !visited[cur.row][cur.column + 1]) {
				visited[cur.column][cur.column + 1] = true;
				queue.offer(new Cell(cur.row, cur.column + 1,
						matrix[cur.row][cur.column + 1]));
			}
		}

		return queue.peek().key;
	}
}

class Cell {
	int row;
	int column;
	int key;
	public Cell(int row, int column, int key) {
		this.row = row;
		this.column = column;
		this.key = key;
	}
}
