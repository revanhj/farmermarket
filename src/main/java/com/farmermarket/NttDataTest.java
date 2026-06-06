package com.farmermarket;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NttDataTest {

	
	public static Map<Character, Long> findTheFrequncy(String input) {
	
		return input.replaceAll("\\s+", "").chars().mapToObj(c->(char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(e->e.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				
		
	}
	
	public static String alphabeticalOrder(String input) {
		return input.replaceAll("\\s+", "").chars().mapToObj(c->(char) c).distinct()
		.sorted()
		.map(String::valueOf).collect(Collectors.joining());
		
	}
	
	public static Optional<Character> findSecondRepeatedChar(String input) {
		return input.chars().mapToObj(c->(char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,  Collectors.counting()))
				.entrySet().stream()
				.filter(e->e.getValue() == 1)
				.map(Map.Entry::getKey).skip(2).findFirst();
	}
	
	public static void main(String[] args) {

		String input = " REVANA HAS INTERVIEW TODAY";
		
		System.out.println(NttDataTest.findTheFrequncy(input));
		System.out.println(NttDataTest.alphabeticalOrder(input));
		System.out.println(NttDataTest.findSecondRepeatedChar(input));

	}
}
