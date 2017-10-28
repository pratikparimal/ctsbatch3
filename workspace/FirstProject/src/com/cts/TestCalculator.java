package com.cts;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculator {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		int result = calc.add(2,2);
		int expectation = 4;
		assertEquals(result, expectation);
	}
	@Test
	public void testAddForNegativeValues() {
		Calculator calc = new Calculator();
		int result = calc.add(-2,-3);
		int expectation = -5;
		assertEquals(result, expectation);
	}

}
