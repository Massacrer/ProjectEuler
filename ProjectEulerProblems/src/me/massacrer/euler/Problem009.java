package me.massacrer.euler;

public class Problem009
{
	public static void main(String[] args)
	{
		for (int a = 1; a < 1000; a++)
		{
			for (int b = 1; b < 1000; b++)
			{
				for (int c = 1; c < 1000; c++)
				{
					if (a + b + c == 1000)
					{
						// System.out.println("" + a + "+" + b + "+" + c);
						if (a * a + b * b == c * c)
						{
							System.out.println("" + a + " + " + b + " + " + c
									+ ": product = " + a * b * c);
						}
					}
				}
			}
		}
	}
}
