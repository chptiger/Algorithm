package leetcode.medium;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/
import java.util.List;
import java.util.LinkedList; 
public class Triangle_120{
	public static void main(String[] args){
		LinkedList<LinkedList<Integer>> triangle = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> m1 = new LinkedList<Integer>();
		LinkedList<Integer> m2 = new LinkedList<Integer>();
		LinkedList<Integer> m3 = new LinkedList<Integer>();
		LinkedList<Integer> m4 = new LinkedList<Integer>();
		m1.add(2);
		triangle.add(m1);
		//System.out.println(triangle);
		
		m2.add(3);
		m2.add(4);
		triangle.add(m2);
		//System.out.println(triangle);
		
		m3.add(6);
		m3.add(5);
		m3.add(7);
		triangle.add(m3);
		//System.out.println(triangle);
		
		m4.add(4);
		m4.add(1);
		m4.add(8);
		m4.add(3);
		triangle.add(m4);
		System.out.println(triangle);
		
		int result = minimumTotal( triangle);
		System.out.println( result );
	}
	// status equation: sum[i][j]=min(sum[i-1][j-1],sum[i-1][j])+triangle[i][j]
	/*
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {  
    if(triangle == null || triangle.size() == 0)  
        return 0;  
    if(triangle.size()==1)  
        return triangle.get(0).get(0);  
    int[] sums = new int[triangle.size()];  
    sums[0] = triangle.get(0).get(0);  
    for(int i=1;i<triangle.size();i++)  
    {  
        sums[i] = sums[i-1]+triangle.get(i).get(i);  
        for(int j=i-1;j>=1;j--)  
        {  
            sums[j] = (sums[j]<sums[j-1]?sums[j]:sums[j-1]) + triangle.get(i).get(j);  
        }  
        sums[0] = sums[0]+triangle.get(i).get(0);  
          
    }  
    int minimum = sums[0];  
    for(int i=1;i<sums.length;i++)  
    {  
        if(sums[i]<minimum)  
        {  
            minimum = sums[i];  
        }  
    }  
    return minimum;  
}  
	
	*/
	// from down to top
	public static int minimumTotal(LinkedList<LinkedList<Integer>> triangle) {
		for( int i = triangle.size()-2; i >=0; i--){
			for( int j=0; j <= i; j++){
				triangle.get( i ).set( j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
			}
		}
		return triangle.get(0).get(0);
    }
    
	//  this is wrong idea. too yong too native, for only caculate minium value of one element of every row.
	public static int minimumTotal_(LinkedList<LinkedList<Integer>> triangle) {
		if( triangle == null ) return 0;
		int result = 0 ;
		int[] sum = new int[ triangle.size()];
		sum[0] = triangle.get(0).get(0);
		for( int i = 1; i < triangle.size(); i++){
			int index = triangle.get(i - 1).indexOf(sum[i-1]);
			sum[i] = Math.min( triangle.get(i).get(index), triangle.get(i).get(index+1));
			result = result + sum[i];
		}			
			
        return result;
    }
	
	
}