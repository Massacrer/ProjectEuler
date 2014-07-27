package me.massacrer.euler;

import java.util.HashMap;
import java.util.Stack;

public class Problem005 {

	public static void main(String[] args) {
		HashMap<Long, Integer> map = new HashMap<>();
		long l = 1;
		for (int i = 1; i <= 20; i++) {
			HashMap<Long, Integer> innerMap = new HashMap<>();
			Stack<Long> factors;
			System.out.println(factors = Problem003.trialDiv3((long) i));
			for (long f : factors) {
				if (!innerMap.containsKey(f)) {
					innerMap.put(f, 0);
				}
				int thing = innerMap.get(f);
				innerMap.put(f, ++thing);
			}
			System.out.println(innerMap);
			for (long k : innerMap.keySet()) {
				int value = innerMap.get(k);
				if (!map.containsKey(k)) {
					map.put(k, 0);
				}
				if (value > map.get(k)) {
					map.put(k, value);
				}
			}
		}
		System.out.println(map);
		int finalProduct = 1;
		for (long k : map.keySet()) {
			for (int j = 0; j < map.get(k); j++) {
				finalProduct *= k;
			}
		}
		System.out.println("Result: " + finalProduct);
	}
}
