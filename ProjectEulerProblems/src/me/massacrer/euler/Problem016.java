package me.massacrer.euler;

import java.math.BigInteger;

public class Problem016
{
	public static void main(String[] args)
	{
		BigInteger largeNumber = BigInteger.ONE;
		largeNumber = largeNumber.shiftLeft(1000);
		char[] digits = largeNumber.toString().toCharArray();
		
		long sum = 0;
		for (char c : digits)
		{
			// (int)0 -> (char)48
			sum += (c - 48);
		}
		
		System.out.println("sum = " + sum);
	}
}
