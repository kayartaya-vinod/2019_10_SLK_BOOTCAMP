package com.slksoft.training;

/**
 * 
 * @author Vinod
 * @version 1.0
 * 
 * This is a simple utility class for mathematical operations.
 *
 */
public final class MathUtils {

	/**
	 * Constructor is made private so that this class cannot be instantiated!
	 */
	private MathUtils() {
	}

	/**
	 * Calculates the factorial of a given number, by repeated multiplication logic.
	 * 
	 * @param num Input for which you want to calculate the factorial
	 * @return Factorial of the input number
	 */
	public static long factorial(int num) {
		int sign = 1;
		if (num < 0) {
			num = num * -1;
			sign = -1;
		}
		long f = 1;
		for (int i = 1; i <= num; i++) {
			f *= i;
		}
		return f * sign;
	}
}
