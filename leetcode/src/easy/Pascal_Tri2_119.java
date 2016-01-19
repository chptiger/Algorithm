/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/
import java.util.Arrays;
public class Pascal_Tri2_119{
	public static void main(String[] args){
		int k = 3;
		List<Integer> m = Pascal_Tri2(k);
		System.out.println(m);
	}
	
	public static List<Integer> Pascal_Tri2(int k){
		List<Integer> l = new LinkedList<Integer>();
		Pascal_Tri_Help(l,0,k);
	}
	
	public static void Pascal_Tri_Help(List<Integer> l, int level, int k){
		
		if(level >= l.size()){
			l.add(new List<Integer>());
		}
		
		if(level == 0) {
			l.get(0).add(1);
		}
		if(level == 1){
			l.get(1).add(1);
		}
		
		int length = l.size();
		
		for(int i = 0 ; i< length; i++){
			
		}
		
		Pascal_Tri_Help(l.level=1;)
	}
}