package com.test.guava.base;

import junit.framework.Assert;
import org.junit.Test;
import  static com.google.common.base.Strings.*;

public class StringsTest {
	
	@Test
	public void testIsNullOrEmpty() {
		String temp = "";
		Assert.assertTrue(isNullOrEmpty(temp));
	}

}
