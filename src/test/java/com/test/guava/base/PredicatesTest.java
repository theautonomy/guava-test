package com.test.guava.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import  static com.google.common.base.Preconditions.*;
import  static com.google.common.base.Objects.*;
import static org.junit.Assert.*;
import static com.google.common.collect.Iterables.*;

import static org.hamcrest.core.Is.*;

public class PredicatesTest {
	List<Person> aList;
	ToStringHelper tsh;
	
	@Before
	public void setup() {
		aList = new ArrayList<Person>();
		aList.add(new Person("test1", 12));
		aList.add(new Person("test2", 10));
		aList.add(new Person("test2", 9));
		tsh = toStringHelper(Person.class);
	}
	
	@Test
	public void transformUsingFunction() {
		Iterable<Integer> ages = transform(aList, new GetAgeFunction()); 
		for (Integer i : ages) {
			ToStringHelper tsh = toStringHelper(i).add("value",  i.intValue());
			System.out.println(tsh.toString());
		}
		
		Integer  [] agesArray = Iterables.toArray(ages, Integer.class);
		
		assertThat(agesArray[0].intValue(), is (1));
		assertThat(agesArray[1].intValue(), is (10));
		assertThat(agesArray[2].intValue(), is (9));
	}
	
	@Test
	public void findUsingPredicate() {
		Person p = Iterables.find(aList, new AgeGreaterThan10Predicate(), null); 
		ToStringHelper tsh = toStringHelper(p).add("name", p.getName()).add("age", p.getAge());
		System.out.println(tsh.toString());
		assertThat(p.getName(), is("test1"));
	}
	
	@Test
	public void filterUsingPredicate() {
		Iterable<Person> c = Iterables.filter(aList, new AgeGreaterThan10Predicate());
		Person [] people = Iterables.toArray(c, Person.class);
		
		for (Person p : people) {
			ToStringHelper tsh = toStringHelper(p).add("name", p.getName()).add("age", p.getAge());
			System.out.println(tsh.toString());
		}
		assertThat(people.length, is(2));
		assertThat(people[0].getName(), is("test1"));
		assertThat(people[1].getName(), is("test2"));
		assertThat(people[0].getAge(), is(12));
		assertThat(people[1].getAge(), is(10));
	}
	
	@Test 
	public void predicateApply() {
		boolean b = new AgeGreaterThan10Predicate().apply(new Person("test", 11));
		assertThat (b, is(true));
	}

	@Test
	public void functionApply() {
		int i = new GetAgeFunction().apply(new Person("test", 10));
		assertThat(i, is(10));
	}

}
class AgeGreaterThan10Predicate implements Predicate<Person> {
    
	@Override
	public boolean apply(Person person) {
		checkNotNull(person);
		return person.getAge() >= 10;
	}
}

class GetAgeFunction implements Function<Person, Integer> {
	@Override
	public Integer apply(Person person) {
		checkNotNull(person);
		return new Integer(person.getAge());
	}
}

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age  = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}