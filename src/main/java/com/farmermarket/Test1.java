package com.farmermarket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {

	public static List<String> findAllUniqueSubstrings(String input) {
		return IntStream.
				range(0, input.length()).boxed()
				.flatMap(i -> IntStream.range(i + 1, input.length() + 1)
			    .mapToObj(j -> input.substring(i, j)))
				.distinct()
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		String input = "abcabc";
		List<String> substrings = findAllUniqueSubstrings(input);
		System.out.println("Total unique substrings: " + substrings.size());
		System.out.println(substrings);
	}
}
