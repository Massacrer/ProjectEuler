package me.massacrer.euler;

import java.math.BigInteger;

public class Problem014
{
	public static void main(String[] args)
	{
		int longest = 0;
		BigInteger bestStart = null;
		// System.out.println(collatzLength(BigInteger.valueOf(13)));
		
		System.out.println("This is going to take > 20 seconds (Intel i7)");
		
		for (BigInteger current = BigInteger.valueOf(1); current
				.compareTo(BigInteger.valueOf(1_000_000L)) == -1; current =
				current.add(BigInteger.valueOf(1)))
		{
			int length = collatzLength(current);
			if (length > longest)
			{
				longest = length;
				bestStart = current;
			}
		}
		System.out.println(bestStart + " has length " + longest);
	}
	
	private static int collatzLength(BigInteger initial)
	{
		int length = 1;
		// take a copy
		BigInteger current = initial.add(BigInteger.valueOf(0));
		
		while (!current.equals(BigInteger.valueOf(1)))
		{
			if (current.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0))
			{
				// even
				current = current.divide(BigInteger.valueOf(2));
			}
			else
			{
				// odd
				BigInteger result = current.multiply(BigInteger.valueOf(3));
				result = result.add(BigInteger.valueOf(1));
				current = result;
			}
			
			length++;
		}
		
		return length;
	}
}
