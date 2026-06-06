package com.farmermarket.string.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetChecker {

	public static boolean containsAllAlphabets(String input) {
		if (input == null)
			return false;
		long distinctAlphabetCount = input.toLowerCase()
				.chars().
				filter(Character::isLetter)
				.mapToObj(c -> (char) c)
				.collect(Collectors.toSet()).size();

		return distinctAlphabetCount == 26;
	}

	public static String findDistincCharacet(String input) {
		return input.chars()
		.mapToObj(x -> String.valueOf((char) x))
		.distinct()
		.collect(Collectors.joining());

	}

	public static List<Integer> findGreaterThan(int[] array, int threshold) {
		return Arrays.stream(array)
				.filter(n -> n > threshold)
				.boxed()
				.collect(Collectors.toList());
	}

	String input = "a1b2c3d4";

	long digits = input.chars().filter(Character::isDigit).sum();

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 20 };
		System.out.println(containsAllAlphabets("The quick brown fox jumps over a lazy dog")); // true
		System.out.println(findDistincCharacet("Hello World")); // false

		System.out.println(AlphabetChecker.findGreaterThan(arr, 10));
	}
}
