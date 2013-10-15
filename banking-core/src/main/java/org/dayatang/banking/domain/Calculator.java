package org.dayatang.banking.domain;

public class Calculator {

	public Calculator() {
	}

	public int add(int x, int y) {
		return x + y;
	}

	public int multiply(int x, int y) {
		return x * y;
	}

	public double divide(int x, int y) {
		if (y == 0) {
			throw new IllegalStateException();
		}
		return x * 1.0 / y;
	}

}
