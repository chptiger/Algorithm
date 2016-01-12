/*
You are playing the following Nim Game with your friend: 
There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
The one who removes the last stone will be the winner. 
You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. 
Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: 
no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/
package easy;
public class Nim_Game_292{
	public static void main(String [] args){
		int n=100;
		System.out.println(remove(n));
		
	}
	
	public static boolean remove(int n){
		/*
		boolean flag = true;
		if(n <= 0){
			return false;
		} 
		
		if(n <= 3 && n > 0){
			return flag = true;
		}
		
		if(n == 4){
			return flag = false;
		}
		
		if(n == 5){
			return flag = true;
		}
		
		if(n == 6){
			return flag = true;
		}
		else{
			
		}
		*/
		return n%4 == 0? false:true;
	}
}