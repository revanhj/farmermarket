package com.farmermarket;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsJava8 {
	public static void main(String[] args) {
		String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };

		List<List<String>> groupedAnagrams = Arrays.stream(words)
				.collect(Collectors.groupingBy(word -> {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		})).values().stream().collect(Collectors.toList());

		System.out.println(groupedAnagrams);
	}
}
