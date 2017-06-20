package com.github.miniyk2012.coding2017.basic;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.github.miniyk2012.coding2017.basic.Iterator;
import com.github.miniyk2012.coding2017.basic.List;

public class ListTest {
	
	protected static List aList;
	
	@Test
	public void testFunctional() {
		if (getClass() == ListTest.class) return;
		aList.add(1);
		aList.add(2);
		assertEquals(1, aList.get(0));
		assertEquals(2, aList.get(1));
		
		aList.add(3);
		aList.add(0, 5);
		aList.add(2, 11);
		assertEquals(5, aList.get(0));
		assertEquals(11, aList.get(2));
		
		aList.add("hi");
		assertEquals("hi", aList.get(5));
		assertEquals(6, aList.size());
		
		aList.remove(1);
		assertEquals(11, aList.get(1));
		assertEquals(2, aList.get(2));
		
		assertEquals(5, aList.size());
	}
	
	@Test
	public void testAdd() {
		if (getClass() == ListTest.class) return;
		for (int i=0; i<100; i++)
			aList.add(i);
		assertEquals(0, aList.get(0));
		assertEquals(99, aList.get(99));
		assertEquals(44, aList.get(44));
	}
	
	@Test
	public void testRemove() {
		if (getClass() == ListTest.class) return;
		aList.add(1);
		aList.add(2);
		aList.add(3);
		int u = (Integer)aList.remove(2);
		assertEquals(3, u);
		assertEquals(2, aList.size());
		
		aList.add(1, 5);
		u = (Integer)aList.remove(0);
		assertEquals(1, u);
		assertEquals(5, aList.get(0));
		assertEquals(2, aList.get(1));
		assertEquals(2, aList.size());
		
		aList.remove(0);
		aList.remove(0);
		assertEquals(0, aList.size());
		

	}
	
	@Test
	public void testSize() {
		if (getClass() == ListTest.class) return;
		for (int i=0; i<10; i++)
			aList.add(i*2);
		assertEquals(10, aList.size());
	}
	
	@Rule  
	public ExpectedException expectedEx = ExpectedException.none(); 
	
	@Test
	public void testException() {
		if (getClass() == ListTest.class) return;
		expectedEx.expect(Exception.class);
		
		aList.remove(1);
		aList.add(3);
		aList.add(2, 5);
	}
	
	@Test
	public void testIterator() {
		if (getClass() == ListTest.class) return;
		Iterator it = aList.iterator();
		assertEquals(false, it.hasNext());
		
		aList.add(1);
		aList.add(2);
		aList.add(3);
		
		it = aList.iterator();
		assertEquals(true, it.hasNext());
		assertEquals(1, it.next());
		assertEquals(2, it.next());
		assertEquals(3, it.next());
		assertEquals(false, it.hasNext());
		
		aList.remove(1);
		it = aList.iterator();
		assertEquals(true, it.hasNext());
		assertEquals(1, it.next());
		assertEquals(3, it.next());
		assertEquals(false, it.hasNext());	
		
		expectedEx.expect(Exception.class);
		it.next();
	}

}
