package com.farmermarket.string.programs;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramCheck {
	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return s1.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.equals(s2.chars().mapToObj(c -> (char) c)
			    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("listen", "silent")); // true
	}
}
