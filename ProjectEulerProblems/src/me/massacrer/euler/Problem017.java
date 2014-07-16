package me.massacrer.euler;

public class Problem017
{
	// number of characters in the number - one->3, three->5, etc
	// 0 added as element 0 to make array access code cleaner
	public static final int [] ones = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
	// ten added as special case here
	public static final int [] teens = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
	// apparently it's "forty", not "fourty" - thanks, 3am coding
	public static final int [] tens = {0, 3, 6, 6, 5, 5, 5, 7, 6, 6};
	// powers of 10 - 10^0=1, 10^1=10, 10^2=100, 10^3=1000
	// lengths of names "hundred" & "thousand"
	// one and ten set to 0 here to enable simple code in the face of
	// complex english
	public static final int [] powerTensWordLength = {0, 0, 7, 8};
	// use "and" after section e.g. "one hundred and ten",
	// contrast "seventy three"
	public static final boolean [] useAnd = {false, false, true, true};
	// hopefully faster than calling Math.pow(double, double) all the time
	public static final int [] powersOfTen = {1, 10, 100, 1000};
	
	//debug
	private static final boolean DEBUG = false;
	// private static final String [] dbgOnes = {"[zero]", "one","two","three","four","five","six","seven","eight","nine"};
	// private static final String [] dbgTeens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	// private static final String [] dbgTens = {"[tens0]","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	
	public static void main(String[] args)
	{
		int totalChars = 0;
		for (int number = 1; number <= 1000; number++)
		{
			totalChars += charsInNumber(number);
		}
		System.out.println(totalChars);
	}
	
	private static int charsInNumber(int number)
	{
		if (number > 9999)
		{
			//todo: increase this limit
			throw new IllegalArgumentException(
					"Cannot handle numbers larger than 9999");
		}
		
		int letterCount = 0;
		//DEBUG
		//String dbgStr = "";

		for (int currentPowerOfTen = 3; number > 0 && currentPowerOfTen >= 0;
				currentPowerOfTen--)
		{
			// handle "teen"s specially
			if (number < 20 && number >= 10)
			{
				letterCount += teens[number - 10];
				//DEBUG
				//if(DEBUG) dbgStr += dbgTeens[number - 10];
				// finished
				number = 0;
				// if this offends you, feel free to comment it out
				// saves a few arithmetic operations
				continue;
			}
			
			// get number to lookup length of word for using quotient
			// e.g. 4567 / 1000 = 4
			int powerTenCount = (number / powersOfTen[currentPowerOfTen]);
			// zero this column (xyz -> 0yz) by subtracting
			number -= (powerTenCount * powersOfTen[currentPowerOfTen]);
			// look up word from ones array (e.g. "one hundred"), except for
			// multiples of 10 - use tens array
			int [] lookupArray = (currentPowerOfTen == 1) ? tens : ones;
			// increment letter count with the length of this word, e.g. "six"
			letterCount += lookupArray[powerTenCount];
			
			if (powerTenCount > 0)
			{
				// add name of the power of ten, e.g. "thousand"
				letterCount += powerTensWordLength[currentPowerOfTen];
			}
			
			//DEBUG
			//if(DEBUG) dbgStr += (currentPowerOfTen == 1 ? 
			//		dbgTens[powerTenCount] : dbgOnes[powerTenCount])
			//				+ (powerTenCount > 0 ? 
			//						powersOfTen[currentPowerOfTen] : "");
			
			// note: uses boolean short-circuiting to avoid out of bounds
			// lookup for final condition when currentPowerTen == 0
			// (useAnd[0] is false -> powersTen[-1] is not looked up)
			// therefore, do not set useAnd[0] to true
			if
			(
				(
						// can only write "and" if a word is already written
						// word is only written if powerTenCount > 0
						powerTenCount > 0
				)
				&&
				(
						// if this number uses "and" at all
						// e.g. "fifty and *" is never seen
						useAnd[currentPowerOfTen]
							&&
							// there is a number left to stick on after it
							// e.g. "one" in "one hundred and one"
							number > 0
				)
				&&
				(
						// "one thousand, one hundred",
						// "one thousand and fifty"
						number < powersOfTen[currentPowerOfTen - 1]
								// hundreds exclusively always use "and"
								|| currentPowerOfTen == 2
				)
			)
			{
				// stick an "and" on the end
				// ("and").length == 3
				letterCount += 3;
				
				//DEBUG
				// if(DEBUG) dbgStr += "and";
			}
		}
		
		//System.out.print(dbgStr);
		return letterCount;
	}
}
