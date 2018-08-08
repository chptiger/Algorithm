package painPoints;

import org.junit.Test;

import pojo.TreeNode;

/**
 * https://www.javaworld.com/article/2077424/learn-java/learn-java-does-java-pass-by-reference-or-pass-by-value.html
 * 
 * Java does manipulate objects by reference, and all object variables are
 * references. However, Java doesn't pass method arguments by reference; it
 * passes them by value. 
 * 
 * The method successfully alters the value of pnt1, even
 * though it is passed by value; however, a swap of pnt1 and pnt2 fails! This is
 * the major source of confusion. In the main() method, pnt1 and pnt2 are
 * nothing more than object references. When you pass pnt1 and pnt2 to the
 * tricky() method, Java passes the references by value just like any other
 * parameter. This means the references passed to the method are actually copies
 * of the original references.
 * 
 * Java copies and passes the reference by value, not the object. Thus, method
 * manipulation will alter the objects, since the references point to the
 * original objects. But since the references are copies, swaps will fail.
 * 
 * @author thomas
 *
 */
public class PassbyValueOrReference {
	
	@Test
	public void test_passbyValueOrReference() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		
		System.out.println("Before:");
		System.out.println("node1 key: " + node1.key);
		System.out.println("node2 key: " + node2.key);
		swap(node1, node2);
		System.out.println("Before:");
		System.out.println("node1 key: " + node1.key);
		System.out.println("node2 key: " + node2.key);
	}
	
	public void swap(TreeNode node1, TreeNode node2) {
//		values of key were updated
		node1.key = 3;
		node2.key = 5;
		
//		swap was not working
		TreeNode tmp = node2;
		node2 = node1;
		node1 = tmp;
	}
}
