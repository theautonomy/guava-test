package com.test.guava.base;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.firstNonNull;
import static com.google.common.base.Objects.toStringHelper;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.*;

import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

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
	   
        System.out.println(Objects.hashCode(temp));
        System.out.println(Objects.hashCode(temp, temp));
        System.out.println(Objects.hashCode(temp.age, temp.name, temp.salary));
        
	    assertEquals(86529409, Objects.hashCode(temp));
	    assertEquals(1479099053, Objects.hashCode(temp, temp));
	    assertEquals(3754426, Objects.hashCode(temp.age, temp.name, temp.salary));
	}
	
	@Test
	public void testToStringHelper() {
		A temp      = new A();
        
	    temp.name   = "you";
	    temp.age    = 10;
	    temp.salary = 16;
	
	    ToStringHelper ts = toStringHelper(temp);
	    assertEquals("A{}", ts.toString()); 
        
	    ts = toStringHelper(temp)
	         .add("name", temp.name)
	         .add("age", temp.age)
	         .add("salary", temp.salary);
        
	    assertEquals("A{name=you, age=10, salary=16}", ts.toString()); 
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
