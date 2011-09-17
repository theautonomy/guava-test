package com.test.guava.base;

import org.junit.Test;

import com.google.common.base.Objects;
import com.sun.org.apache.bcel.internal.generic.NEW;

import static junit.framework.Assert.*;
import  static com.google.common.base.Objects.*;

public class ObjectsTest {
	
	@Test
	public void testEqual() {
		Object a = null;
		Object b = null;
		assertTrue(equal(a, b));
		
		a = "test";
		b = "test";
		assertTrue(equal(a, b));
		
		assertFalse(equal(a, null));
	}
	
	@Test 
	public void testHashCode() {
		A temp = new A();
	    temp.name = "you";
	    temp.age  = 10;
	    temp.salary = 16;
	    
	    System.out.println(Objects.hashCode(temp, temp));
	    System.out.println(Objects.hashCode(temp));
	    System.out.println(Objects.hashCode(temp.age, temp.name, temp.salary));
	}
	
	@Test
	public void testToStringHelper() {
			A temp = new A();
	    temp.name = "you";
	    temp.age  = 10;
	    temp.salary = 16;
	
	    ToStringHelper ts = toStringHelper(temp);
	    System.out.println(ts.toString());
	    
	    ts = toStringHelper(temp)
	         .add("name", temp.name)
	         .add("age", temp.age)
	         .add("salary", temp.salary);
	    System.out.println(ts.toString());
	}
	
	@Test 
	public void testFirstNonNull() {
		Object a = null;
		Object b = "test";
		assertSame("test", firstNonNull(a, b));
		
		a = new java.util.Date();
		
		assertSame(a, firstNonNull(a, b));
		
	}

}

class A {
	protected String name;
	protected int age;
	
	protected int salary;
}
