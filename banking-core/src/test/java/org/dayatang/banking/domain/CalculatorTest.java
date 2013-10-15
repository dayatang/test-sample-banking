package org.dayatang.banking.domain;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest {
	
	private int result, x, y;
	

	public CalculatorTest(int result, int x, int y) {
		this.result = result;
		this.x = x;
		this.y = y;
	}
	
	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] {
				{2, 1, 1},
				{3, 2, 1},
				{4, 3, 1},
				{4, 4, 0},
				{3, 4, -1}
		});
	}

	@Test
	public void sum() {
		Calculator calculator = new Calculator();
		assertEquals(result, calculator.add(x, y));
	}
}
