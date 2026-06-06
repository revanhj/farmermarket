package com.farmermarket.string.programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static Character findCompression(String input) {
		Map<Character, Integer> characterCountMap = new LinkedHashMap<>();
		for (char ch : input.toCharArray()) {
			characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return '\0';
	}

	public static void main(String[] args) {
		String input = "aaabbytrgg";
		System.out.println(findCompression(input));
	}
}
