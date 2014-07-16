package me.massacrer.euler;

public class Problem4 {
	private int base = 999;

	public static void main(String[] args) {
		new Problem4();
	}

	private Problem4() {
		for (int i = 600; i < 999; i++) {
			System.out.println(i);
			for (int j = 600; j < 999; j++) {
				int product = i * j;
				if (isPalindrome(product)) {
					System.out.println(i + ":" + j + ":" + product);
				}
			}
		}
	}

	private boolean isPalindrome(int number) {
		String chars = Integer.toString(number);
		int end = chars.length() - 1;
		for (int i = 0; i < end; i++) {
			if (chars.charAt(i) != chars.charAt(end - i)) {
				return false;
			}
		}
		return true;
	}

	private static int makePalindrome(int base) {
		char[] pal = new char[6];
		return base * 1000;
	}

}
