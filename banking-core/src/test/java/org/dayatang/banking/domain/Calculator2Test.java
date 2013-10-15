package org.dayatang.banking.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Calculator2Test {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass................");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass..................");
	}
	
	Calculator calculator;
	
	@Before
	public void beforeTest() {
		calculator = new Calculator();
		System.out.println("Ha Ha................");
	}
	
	@After
	public void afterTest() {
		System.out.println("Over..................");
	}

	@Test
	public void add() {
		System.out.println("Test add.............");
		assertEquals(5, calculator.add(2, 3));
		assertEquals(3, calculator.add(0, 3));
		assertEquals(-2, calculator.add(-5, 3));
	}

	@Test
	public void multiply() {
		System.out.println("Test multiply.............");
		assertEquals(6, calculator.multiply(2, 3));
		assertEquals(0, calculator.multiply(0, 3));
	}
	
	@Test
	public void divide() {
		assertEquals(2, calculator.divide(6, 3), 0.0001);
	}
	
	@Test
	public void divide1() {
		assertEquals(1.2, calculator.divide(6, 5), 0.0001);
	}
	
	@Test(expected = IllegalStateException.class)
	public void divideByZero() {
		calculator.divide(100, 0);
	}
}
