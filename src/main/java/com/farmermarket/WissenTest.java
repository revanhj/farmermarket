package com.farmermarket;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WissenTest {

	public static int findNonRepeatedCharacter(String input) {

		Map<Character, Long> map = input.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return -1;

	}
	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("Revan", 1);
		map.put("Revan", 1);
		
		System.out.println(map);
	}
}
