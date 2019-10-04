package com.slksoft.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MathUtilsTest {

	@Test
	public void testFactorialPositive() {
		long expected = 120;
		long actual = MathUtils.factorial(5);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFactorialNegative() {
		long expected = -120;
		long actual = MathUtils.factorial(-5);
		assertEquals(expected, actual);
	}
	
}
