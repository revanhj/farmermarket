package com.farmermarket.string.programs;

import java.util.HashMap;
import java.util.Map;

public class CountCharactersOccurences {

	public static Map<Character, Integer> findCompression(String input) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String input = "aaabbytrgg";
		System.out.println(findCompression(input));
	}
}
