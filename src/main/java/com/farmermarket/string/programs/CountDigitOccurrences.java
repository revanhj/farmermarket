package com.farmermarket.string.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDigitOccurrences {

	public static Map<Integer, Long> countDigitOccurrence(int input) {

		return String.valueOf(input).chars().mapToObj(x -> x - '0')
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}

	public static List<String> namesGetDuplicateNames(List<String> nameList) {
		return nameList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().filter(item -> item.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println(CountDigitOccurrences.countDigitOccurrence(555534567));
		List<String> names = Arrays.asList("apple", "banana", "orange", "apple", "banana", "grapes");
		System.out.println(CountDigitOccurrences.namesGetDuplicateNames(names));
	}
}
