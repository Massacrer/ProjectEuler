package me.massacrer.euler;

import java.math.BigInteger;

public class Problem007
{
	
	// this feels like a horrible abuse of hardware time
	// TODO: optimise
	// gets prime factor lists of consecutive numbers - if list length == 1,
	// number is prime, increment counter
	// continue until 10001 primes found
	// output value
	// ???
	// profit
	public static void main(String[] args)
	{
		long numberTested = 2;
		int primesFound = 0;
		BigInteger latestPrime = new BigInteger("0");
		while (primesFound < 10001)
		{
			if (Problem003.trialDiv3(numberTested).size() == 1)
			{
				latestPrime = BigInteger.valueOf(numberTested);
				primesFound++;
			}
			numberTested++;
		}
		System.out.println(latestPrime);
	}
}
