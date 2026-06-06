package com.farmermarket.string.programs;

import java.util.HashMap;
import java.util.Map;

public class SumofUniqueElements {

	public static int SumofUniqueElement(int[] rr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : rr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int sum = 0;
		for (int num : map.keySet()) {
			if (map.get(num) == 1) {
				sum += num;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 2, 2, 6, 4 };
		System.out.println(SumofUniqueElements.SumofUniqueElement(arr));
	}
}
