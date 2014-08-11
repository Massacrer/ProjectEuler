package me.massacrer.euler;

import java.util.Stack;
import java.util.Vector;

public class Problem12
{
	
	public static void main(String[] args)
	{
		long triangleNumber = 1;
		long numberToAdd = 2;
		
		boolean done = false;
		while (!done)
		{
			triangleNumber += (numberToAdd++);
			
			// System.out.print("trying " + triangleNumber);
			Vector<Long> factors = Problem003.trialDiv3(triangleNumber);
			// System.out.println(" -> " + factors);
			
			int divisors = divisorsCount(factorExponents(factors));
			
			done = divisors > 500;
		}
		System.out.println(triangleNumber);
	}
	
	// returns the number of times each factor occurs in the list
	// e.g. a b b c c c d e e e // factors
	// ---> 1 2 - 3 - - 1 3
	// -> 1 2 3 1 3 // result
	private static Vector<Integer> factorExponents(Vector<Long> factors)
	{
		Vector<Integer> exponents = new Vector<>();
		Long lastFactor = 0L;
		for (Long factor : factors)
		{
			if (factor == lastFactor)
			{
				int index = exponents.size() - 1;
				exponents.set(index, exponents.get(index) + 1);
			}
			else
			{
				exponents.add(1);
			}
			lastFactor = factor;
		}
		return exponents;
	}
	
	// implements divisor function sigma_0
	// gives the number of divisors or a number, given the number of prime
	// factors and how many times each occurs
	private static int divisorsCount(Vector<Integer> exponents)
	{
		int result = 1;
		for (Integer exponent : exponents)
		{
			result *= exponent + 1;
		}
		return result;
	}
}
