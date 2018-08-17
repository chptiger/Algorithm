package basicQuestions.DP;
/*
 * 将一个问题分解为子问题递归求解，且将中间结果保存以避免重复计算。
 * 通常用来求最优解，且最优解的局部也是最优的。求解过程产生多个决策序列，下一步总是依赖上一步的结果，自底向上的求解。
 * 
 * 01背包: 有N件物品和一个重量为M的背包。（每种物品均只有一件）第i件物品的重量是w[i]，价值是p[i]。求解将哪些物品装入背包可使价值总和最大。
 * 		      特点是：每种物品仅有一件，可以选择放或不放。
 * 
 * 即c[i][m]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值。则其状态转移方程便是：
 * 
     c[i][m]=max{c[i-1][m],c[i-1][m-w[i]]+p[i]}
     
   这个方程非常重要，基本上所有跟背包相关的问题的方程都是由它衍生出来的。
   所以有必要将它详细解释一下：
 “将前i件物品放入重量为m的背包中”这个子问题，若只考虑第i件物品的策略（放或不放），那么就可以转化为一个只牵扯前i-1件物品的问题。
  如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中”，价值为c[i-1][m]；
  如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的重量为m-w[i]的背包中”，此时能获得的最大价值就是c[i-1][m-w[i]]再加上通过放入第i件物品获得的价值p[i]。
 */
public class Knapsack_ZeroOne {
	public static void main(String[] args) {
		int m = 10;
		int n = 3;
		int w[] = { 3, 4, 5 };
		int p[] = { 4, 5, 6 };
		Knapsack_ZeroOne pack01 = new Knapsack_ZeroOne();
		int[][] tmp = pack01.pack(m, n, w, p);
		pack01.print(tmp, w, m , n);
	}
	
//	w[i - 1]: 第 i 个物品的重量
//	p[i - 1]: 第 i 个物品的价值
//	m: 背包能够容纳的最大重量
//	n: 计划向背包中放入物品的个数
	public static int[][] pack(int m, int n, int[] w, int[] p){
//  tmp[i][j]: 前i件物品恰放入一个重量为j的背包可以获得的最大价值
		int [][] tmp = new int[n+1][m+1];
		
		for(int i = 0; i< m+1; i++){
			tmp[0][i] = 0;
		}
		
		for(int i=1; i<n+1; i++){
			tmp[i][0] = 0;
		}
		
		for( int i = 1; i < n + 1; i++){
			for( int j = 1; j < m + 1; j++){
//				当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：  
				if( w[i-1] <= j ){
					if(tmp[i-1][j] < tmp[i-1][j-w[i-1]]+p[i-1]){
						//(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值 
						tmp[i][j] = tmp[i-1][j-w[i-1]]+p[i-1];
					}else{
						//(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
						tmp[i][j] = tmp[i-1][j];
					}
				}else{
					//当物品为i件重量为j时，如果第i件的重量(w[i-1])大于重量j时， c[i][j]为c[i-1][j]的值
					tmp[i][j] = tmp[i-1][j];
				}
			}
		}
		return tmp;		
	} 
	
	public static void print(int[][] tmp, int m, int n){
		for( int i = 0; i < n + 1; i++){
			for( int j = 0; j < m + 1; j++){
				System.out.print(" "+tmp[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	 
	   public static void print(int c[][],int[] w, int m, int n){  
          
	        int x[] = new int[n];  
	        //从最后一个状态记录c[n][m]开始逆推  
	        for(int i = n;i>0;i--){  
	            //如果c[i][m]大于c[i-1][m]，说明c[i][m]这个最优值中包含了w[i-1](注意这里是i-1，因为c数组长度是n+1)  
	            if(c[i][m]>c[i-1][m]){  
	                x[i-1] = 1;  
	                m-=w[i-1];  
	            }  
	        }  
	        for(int j = 0;j<n;j++)  
	            System.out.println(x[j]);  
	        //return x;  
	    }
	     

}
