package com.test.guava.base;

import org.junit.Test;
import static junit.framework.Assert.*;

import  static com.google.common.base.Strings.*;

public class StringsTest {
	
	@Test
	public void testIsNullOrEmpty() {
		String temp = "";
		assertTrue(isNullOrEmpty(temp));
		
		temp = null;
		assertTrue(isNullOrEmpty(temp));
		
		temp = " ";
		assertFalse(isNullOrEmpty(temp));
	}
	
	@Test
	public void testEmptyToNull() {
		String temp = "";
		assertNull(emptyToNull(temp));
		
		temp = "  ";
		assertNotNull(emptyToNull(temp));
	}
	
	@Test 
	public void testNullToEmpty() {
		String temp = null;
		assertEquals("", nullToEmpty(temp));
		assertSame("", nullToEmpty(temp));
		assertNotSame(" ", nullToEmpty(temp)); 
	}

}
