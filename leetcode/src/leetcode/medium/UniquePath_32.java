package leetcode.medium;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?
*/
public class UniquePath_32{
	public static void main(String[] args){
		int m = 1;
		int n = 2;
		int result = uniquePaths(m,n);
		System.out.println( result );
	}
	
	public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++){
			arr[i][0] = 1;
		}
		for(int i = 0; i < m; i++){
			arr[0][i] = 1;
		}
		
		for(int i = 0; i < m; i++){
			for( int j =0; j < n; j++){
				System.out.println(arr[i][j]);
				//arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}	
		
		for(int i = 1; i < m; i++){
			for( int j =1; j < n; j++){
				//System.out.println(arr[i][j]);
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}	
		
		return arr[m-1][n-1];
    }
}