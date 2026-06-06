package com.farmermarket.string.programs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctCharacters {

	static String findDuplicateCharacters(String input) {
		Set<Character> seen = new HashSet<>();
		Set<Character> duplicate = new HashSet<>();
		input.chars().mapToObj(c -> (char) c).forEach(put -> {
			if (!seen.add(put)) {
				duplicate.add(put);
			}
		});
		return duplicate.stream().map(String::valueOf).collect(Collectors.joining());
	}

	public static Set<Character> findDistinct(String input) {
		return input.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedHashSet::new));

	}

	public static void main(String[] args) {
		System.out.println(DistinctCharacters.findDistinct("revanasiddappa"));
	}
}