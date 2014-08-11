package me.massacrer.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem013
{
	public static void main(String[] args)
	{
		String[] strings = readFromFile();
		
		BigInteger count = BigInteger.valueOf(0);
		for (String string : strings)
		{	
			count = count.add(new BigInteger(string));
		}
		System.out.println(count.toString().substring(0, 10));
	}
	
	private static String[] readFromFile()
	{
		String[] strings = new String[100];
		try (BufferedReader br =
				new BufferedReader(new InputStreamReader(new FileInputStream(
						new File("Problem013_numbers.txt")))))
		{
			for (int index = 0; index < 100; index++)
			{
				strings[index] = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return strings;
	}
}
