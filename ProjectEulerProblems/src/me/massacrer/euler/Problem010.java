package me.massacrer.euler;

import java.math.BigInteger;

public class Problem010
{
	// you thought problem 7 was bad
	// runs in ~6 seconds on an Intel i7
	public static void main(String[] args)
	{
		long numberTested = 2;
		long sum = 0; // 1; // apparently 1 isn't prime :(
		while (numberTested < 2_000_000)
		{
			if (Problem003.trialDiv3(numberTested).size() == 1)
			{
				sum += numberTested;
			}
			numberTested++;
		}
		System.out.println(sum);
	}
}
