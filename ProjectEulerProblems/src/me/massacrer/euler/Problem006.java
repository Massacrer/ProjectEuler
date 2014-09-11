package me.massacrer.euler;

public class Problem006
{
	
	public static void main(String[] args)
	{
		int n = 100;
		long sumOfSquares = 0;
		for (int i = 1; i <= n; i++)
		{
			sumOfSquares += i * i;
		}
		System.out.println(sumOfSquares);
		
		long sum = (long) (0.5 * n * (n + 1));
		System.out.println(sum);
		
		long squareOfSum = sum * sum;
		System.out.println(squareOfSum);
		
		System.out.println("Anwer: " + (squareOfSum - sumOfSquares));
	}
}
