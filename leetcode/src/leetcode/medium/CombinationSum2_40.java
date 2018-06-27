package leetcode.medium;

/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 = a2 = … = ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum2_40{
	public static void main(String[] args){
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = combinationSum(num,target);
		System.out.println( result );
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
       // sort the array to start from small one, with out sort, the result set is not complete like {8,7,4,3} only return [[3,8]]
		Arrays.sort(candidates);
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		combinationSum_help( candidates,ans, tmp,0, target);
		return ans;
    }
	
	public static void combinationSum_help( int[] candidates, List<List<Integer>> ans, List<Integer> tmp, int start, int target){
		if( target == 0 ){
			List<Integer> cur = new ArrayList<Integer>(tmp);
			ans.add(cur);
			return;
		}
		
		for( int j = start; j < candidates.length && target >= candidates[j]; j++){
			if( j > start && candidates[j] == candidates[j-1]) continue;
			tmp.add(candidates[j]);
			combinationSum_help( candidates, ans, tmp, j+1, target-candidates[j]);
			tmp.remove(tmp.size()-1);
		}
	}
}

