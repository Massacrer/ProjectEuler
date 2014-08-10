package me.massacrer.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem011
{
	// size of the grid
	private static final int GRIDSIZE = 20;
	// how many numbers to multiply
	private static final int NUMBERS = 4;
	// grid to store numbers
	private static int[][] grid;
	// Largest product found - result
	private static int maxProduct = 0;
	// reference for largest product
	private static String reference;
	
	public static void main(String[] args)
	{
		loadGrid();
		
		// get products going in all directions
		
		// right
		traverseGrid(1, 0);
		// down
		traverseGrid(0, 1);
		// down-right
		traverseGrid(1, 1);
		// up-right
		traverseGrid(1, -1);
		
		System.out.println(maxProduct);
	}
	
	private static void loadGrid()
	{
		grid = new int[GRIDSIZE][GRIDSIZE];
		File in = new File("Problem11_grid.txt");
		try (BufferedReader br =
				new BufferedReader(new InputStreamReader(
						new FileInputStream(in))))
		{
			// line of the grid
			int line = 0;
			String currentLine = "";
			while ((currentLine = br.readLine()) != null)
			{
				// handle individual line
				String[] numbers = currentLine.split(" ");
				for (int column = 0; column < numbers.length; column++)
				{
					grid[line][column] = Integer.parseInt(numbers[column]);
				}
				line++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Goes through the grid, getting the products obtained by starting at each
	 * position in turn using the specified offset
	 * 
	 * @param offsetX
	 * @param offsetY
	 * @return
	 */
	private static void traverseGrid(int offsetX, int offsetY)
	{
		int initialX = initialOffset(offsetX);
		int initialY = initialOffset(offsetY);
		
		for (int x = initialX; x < maxOffset(initialX); x++)
		{
			for (int y = initialY; y < maxOffset(initialY); y++)
			{
				getProduct(x, y, offsetX, offsetY);
			}
		}
	}
	
	private static int initialOffset(int offset)
	{
		return offset >= 0 ? 0 : NUMBERS - 1;
	}
	
	private static int maxOffset(int offset)
	{
		return offset + GRIDSIZE - NUMBERS;
	}
	
	/**
	 * Gets the product of 4 numbers in a given direction in the grid
	 * 
	 * @param startx
	 *            x coordinate to start at
	 * @param starty
	 *            y coordinate to start at
	 * @param offx
	 *            direction to move - x
	 * @param offy
	 *            direction to move - y
	 * @return the product
	 */
	private static void getProduct(int startx, int starty, int offx, int offy)
	{
		int number = 1;
		System.out.print("testing @ " + startx + "," + starty + " off " + offx
				+ "," + offy + ": ");
		for (int i = 0; i < 4; i++)
		{
			int numberInGrid = grid[startx + (offx * i)][starty + (offy * i)];
			number *= numberInGrid;
			System.out.print(numberInGrid + " ");
		}
		
		System.out.println("= " + number);
		
		testNewProduct(number);
	}
	
	private static void testNewProduct(int product)
	{
		if (product > maxProduct)
		{
			maxProduct = product;
		}
	}
}
