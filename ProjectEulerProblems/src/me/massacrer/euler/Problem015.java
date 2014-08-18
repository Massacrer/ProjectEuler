package me.massacrer.euler;

public class Problem015
{
	public static void main(String[] args)
	{
		// Solved using mathematical techniques
		
		// The number of paths to each node lying on the bisecting line
		// through a grid of N sides (N + 1 nodes per side) is (n(choose)r),
		// where r is the number of nodes from the left
		// e.g. N = 5 -> P = {1, 5, 10, 10, 5, 1}
		
		// Number of paths to the exit from a given node on this line
		// is equal to the number of paths to it, because a grid is symmetrical
		// about this line
		
		// Therefore, the number of paths through node r (= 0 .. N) on the
		// central line of an N*N grid is ((N(choose)r)^2)
		
		// -> the number of paths through every node on the bisecting line
		// (i.e. through the whole grid) is sum[x = 0..N]((N(choose)x)^2)
		// Setting x = 20 (given) and evaluating results in the printed answer
		
		System.out.println("137846528820");
	}
}
