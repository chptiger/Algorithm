package leetcode.easy;
/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
public class Rectangle_Area_223{
	public static void main(String[] args){
		int a = -2;
		int b = -2;
		int c = 2;
		int d = 2;
		int e = -2;
		int f = -2;
		int g = 2;
		int h = 2;
		
		int s = Rectangle_Area(a,b,c,d,e,f,g,h);
		System.out.println(s);
	}
	
	public static int Rectangle_Area(int a,int b,int c,int d,int e,int f,int g,int h){
		int i = (Math.abs(a)*d + c * (Math.abs(f)+d) + (g-c)*(h+Math.abs(f)));
		System.out.println(i);
		return i;
	}
}