package me.massacrer.euler;

import java.util.LinkedList;

public class Problem001
{
	static LinkedList<Integer> numbers = new LinkedList<Integer>();
	
	public static void main(String[] args)
	{
		addToList(3);
		addToList(5);
		int sum = 0;
		for (int i : numbers)
		{
			sum += i;
		}
		System.out.println(sum);
	}
	
	private static void addToList(int i)
	{
		for (int j = i; j < 1000; j += i)
		{
			if (!numbers.contains(j))
			{
				numbers.add(j);
			}
		}
	}
}
