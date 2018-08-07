package basicQuestions.Recursion.II;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
	Description
	Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
	Assumptions
	N > 0
	Return
	A list of ways of putting the N Queens
	Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
	Example
	N = 4, there are two ways of putting 4 queens:
	[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.
	[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
	Medium
	Backtracking
	Depth First Search
*/
public class NQueen_2_3 {
	
	@Test
	public void test_nQueen() {
		int n = 4;
		List<List<Integer>> result = new ArrayList<>();
		nQueen(result, n);
		for(List<Integer> cur : result) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < cur.size(); i++) {
				sb.append(cur.get(i) + "-> ");
			}
			System.out.println(sb.toString());
		}
	}

	public static void nQueen(List<List<Integer>> result, int n) {
		List<Integer> cur = new ArrayList<>();
		helper(n, result, cur);
	}
	
	/**
	 * cur: 1->3->5
	 * in the row 0, first queen is in the column 1
	 * in the row 1, second queen is in the column 3
	 * in the row 2, thrid queen is in the column 5
	 */
	public static void helper(int n, List<List<Integer>> result, List<Integer> cur) {
		if(cur.size() == n) {
//			result.add(cur);					not working.
			result.add(new ArrayList<>(cur));	// put one method into container of the all possible answer
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(valid(cur, i)) {	// i is the column for row(cur.size()) 
				cur.add(i);
				helper(n, result, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	//Queen could threaten each other if they are in the same row, same column and diagonal
	//In the method, row is fixed, try to find the valid column
	public static boolean valid(List<Integer> cur, int column) {
		int row = cur.size();
		for(int r = 0; r < row; r++) { 				// i is the row of previous Queens
			if(cur.get(r) == column 				// to check if the new Queen in the same column of the previous one
					|| Math.abs(cur.get(r) - column) == (row - r) 	// to check if the new Queen and the previous one in the diagonal
					) {
				return false;
			}
		}
		return true;
	}
}
