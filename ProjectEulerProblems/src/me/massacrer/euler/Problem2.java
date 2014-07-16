package me.massacrer.euler;

public class Problem2 {

	public static void main(String[] args) {
		int a = 1, b = 2, fib = 2, sum = 0;
		do {
			System.out.print(fib);
			if (fib % 2 == 0) {
				sum += fib;
				System.out.println(": true, sum now " + sum);
		 	} else {
		 		System.out.println(": false");
		 	}
		
			fib = a + b;
			a = b;
			b = fib;

		} while (fib < 4_000_000);
		System.out.println(sum);
	}
}
