/*
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 = a2 = … = ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

*/
package leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum1_39{
	public static void main(String[] args){
		int[] num = {8,7,4,3};
		int target = 11;
		List<List<Integer>> result = combinationSum(num,target);
		System.out.println( result );
	}
	
	
	// method 1 
	public static List<List<Integer>> combinationSum_(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if(target == 0 ){
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }
	
	
	// method 2
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
		// sort the array to start from small one, with out sort, the result set is not complete like {8,7,4,3} only return [[3,8]]
		Arrays.sort(candidates);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		combinationSum_help( candidates,ans, tmp,0, target);
		return ans;
    }
	
	public static void combinationSum_help( int[] candidates, List<List<Integer>> ans, List<Integer> tmp, int start, int target){
		// remove duplicate
	//	if( tmp.size() >= 2){
	//		if(tmp.get(tmp.size()-1) < tmp.get(tmp.size()-2)) return;
	//	}
		
		if( target == 0 ){
			List<Integer> cur = new ArrayList<Integer>(tmp);
			ans.add(cur);
			return;
		}
		
		for( int j = start; j < candidates.length && target >= candidates[j]; j++){
			tmp.add(candidates[j]);
			combinationSum_help( candidates, ans, tmp, j, target-candidates[j]);
			//combinationSum_help( candidates, target-candidates[j], ans, tmp, start);
			tmp.remove(tmp.size()-1);
		}
		
	}
}