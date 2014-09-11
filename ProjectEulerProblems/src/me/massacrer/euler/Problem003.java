package me.massacrer.euler;

import java.util.LinkedList;
import java.util.Stack;

public class Problem003
{
	// private Stack<Long> composites = new Stack<Long>();
	private Stack<Long> factors = new Stack<Long>();
	
	public static void main(String[] args)
	{
		Long start = new Long("59698759685446619");// 254343659438407");//
													// 145));// 13195); // new
		// Long("600851475143");//13195;
		if (args.length > 0)
		{
			try
			{
				start = Long.parseLong(args[0]);
			}
			catch (NumberFormatException e)
			{
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
		// p3.composites.push();
		
		// p3.fermat(start);
		System.out.println(Problem003.trialDiv3(start));
	}
	
	private void fermat(long n)
	{
		long sqrtR = Math.round(Math.sqrt(n)) - 1; // get smallest root to use
		
		long r = 0L, a = 0L;
		do
		{
			sqrtR++;
			r = sqrtR * sqrtR;
			a = r - n;
			// System.out.println(Math.sqrt(a));
		}
		while (!isSquare(a));
		// n=a+r, both square
		// n=y^2=sqrtR^2 -> n = (y+sqrtR)(y-sqrtR)
		long root1 = (long) (sqrtR + Math.sqrt(a));
		long root2 = (long) (sqrtR - Math.sqrt(a));
		System.out.println(n + " = " + root1 + " * " + root2);
		boolean foundPrime = root1 == 1 || root2 == 1;
		if (foundPrime)
		{
			// one of the roots == 1: found a factor
			// add the other as result
			this.factors.push(root1 == 1 ? root2 : root1);
		}
		else
		{
			// this.composites.push(root1);
			fermat(root1);
			// this.composites.push(root2);
			fermat(root2);
		}
	}
	
	private static boolean isSquare(long n)
	{
		int x = (int) n & 0xf;
		if (x > 9)
		{
			return false;
		}
		if (x != 2 && x != 3 && x != 5 && x != 6 && x != 7 && x != 8)
		{
			double root = Math.floor(Math.sqrt(n));
			return root * root == n;
		}
		return false;
	}
	
	private static void trialDivision()
	{
		LinkedList<Long> factors = new LinkedList<Long>();
		// number to factor
		Long mainProduct = new Long("600851475143");// 13195;
		// intermediate product, divided along the way
		long intProduct = mainProduct;
		for (long i = 2, remadeProduct = 1; i < mainProduct
				&& remadeProduct < mainProduct; i++, remadeProduct = 1)
		{
			System.out.print(i);
			if (intProduct % i == 0)
			{ // i is a factor of intProduct
				intProduct /= i; // remove the factor from the product
				factors.add(i); // record factor
				for (long j : factors)
				{
					remadeProduct *= j; // calculate product of factors found so
										// far
				}
				System.out.println(": true, factors: " + factors.toString());
			}
			else
			{
				System.out.println(": false");
			}
		}
		System.out.println(factors.toString());
	}
	
	/**
	 * Given a number, tries to divide it by 2, 3, 4...etc. to identify factors.
	 * Once a factor is found, it is recorded, and the running product is
	 * divided by this factor to remove it, and the process repeats until all
	 * factors have been found - the product has been reduced to 1.
	 * 
	 * Only possible factors below half of the working product are tested - no
	 * number above this can produce a factor above or equal to 2. The case
	 * where the only valid factor is the working product itelf - the number is
	 * prime - is treated as a special case, by having the factor extraction
	 * logic as the default case, and falling through to it instead of breaking
	 * out of the for loop
	 * 
	 * 
	 * @param product
	 */
	private static Stack<Long> trialDiv2(Long product)
	{
		Stack<Long> factors = new Stack<Long>();
		long possibleFactor;
		while (product != 1)
		{
			for (possibleFactor = 2; possibleFactor <= product / 2; possibleFactor++)
			{
				if (product % possibleFactor == 0)
				{
					break;
				}
			}
			product /= possibleFactor;
			System.out.println(possibleFactor);
			factors.add(possibleFactor);
		}
		return factors;
	}
	
	// comments, yay
	// Rewritten and tidied up from #trialDiv2
	public static Stack<Long> trialDiv3(Long product)
	{
		if (product < 1)
		{
			throw new IllegalArgumentException(
					"Product cannot be 0 or negative");
		}
		Stack<Long> factors = new Stack<Long>();
		long possibleFactor = 2;
		while (product != 1)
		{
			boolean foundFactor = false;
			// largest number to check for divisibility - saves time searching
			// for the final prime with large numbers
			long maxdiv = product;
			// search starts at last factor found (2 if first run)
			while (possibleFactor <= maxdiv && !foundFactor)
			{
				maxdiv = product / possibleFactor;
				if (product % possibleFactor == 0)
				{
					// product /= possibleFactor;
					product = maxdiv;
					foundFactor = true;
				}
				else
				{
					// only increment if factor not found - enables checking for
					// duplicate factors
					possibleFactor++;
				}
			}
			if (!foundFactor)
			{
				// product is prime -> product is last factor
				possibleFactor = product;
				product /= possibleFactor;
			}
			// System.out.println(possibleFactor);
			factors.add(possibleFactor);
		}
		return factors;
	}
	
	private void trialdiv2_old(Long product)
	{
		while (product != 1)
		{
			for (long i = 2; i <= (product / 2) + 1; i++)
			{
				// no point testing higher than product/2 - cannot give a factor
				// - result of division always below 2
				// only possible factor remaining is product itself - prime
				if (i > product / 2)
				{
					i = product;
				}
				if (product % i == 0)
				{
					product /= i;
					factors.add(i);
					System.out.println("found factor " + i
							+ ", int product now " + product);
					break;
				}
			}
		}
	}
}
