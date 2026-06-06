package com.farmermarket.string.programs;

import java.util.HashMap;
import java.util.Map;

public class Compression {

	public static String findCompression(String input) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append(entry.getValue());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "aabbytrgg";
		System.out.println(findCompression(input));
	}
}
