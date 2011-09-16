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
	
	@Test
	public void testPadEnd() {
		String temp = "aaa";
		assertEquals("aaabb", padEnd(temp, 5, 'b'));
		assertEquals("aaa", padEnd(temp, 3, 'b'));
		assertEquals("aaa", padEnd(temp, 2, 'b'));
	}
	
	@Test
	public void testPadStart() {
		String temp = "aaa";
		assertEquals("bbaaa", padStart(temp, 5, 'b'));
		assertEquals("aaa", padStart(temp, 3, 'b'));
		assertEquals("aaa", padStart(temp, 2, 'b'));
	
		temp = "12345678";
		assertEquals("012345678", padStart(temp, 9, '0'));
	}
	
	@Test
	public void testRepeat() {
		String temp = "abc";
		assertEquals("abcabc", repeat(temp, 2));
	}
	
}
