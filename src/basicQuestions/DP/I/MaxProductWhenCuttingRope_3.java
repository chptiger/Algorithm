package io.javabrains.unit1;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductWhenCuttingRope_3 {
	
	@Test
	public void test_maxProductWhenCuttingRope() {
		int n = 10;
		Assert.assertEquals(36, ropeCut(n));
	}
	
	public static int ropeCut(int n) {
		if(n == 1) {
			return 0;
		}
		
		int max = 0;
		for(int i = 1; i < n ; i++) {							// right fix cutted rop
			int maxProduct = Math.max(n - i, ropeCut(n - i));   //left part largest count 
			max = Math.max(max, i * maxProduct);
		}
		return max;
	}
}
