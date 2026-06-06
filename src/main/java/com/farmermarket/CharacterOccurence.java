package com.farmermarket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurence {

	public static Map<Character, Long> findOcurence(String input) {
		return input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static String findMinAndMaxWord(String sentence) {
		String[] words = sentence.split("\\s+");
		return Arrays.stream(words).max(Comparator.comparing(String::length)).orElse("No Result");
	}

	public static String findMinAndMinWord(String sentence) {
		String[] words = sentence.split("\\s+");
		return Arrays.stream(words).min(Comparator.comparing(String::length)).orElse("No Result");
	}

	public static Map<String, Long> findOcurenceEachWord(String sentence) {
		String[] words = sentence.split("\\s+");
		return Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static String mostRepeatedWord(String sentence) {
		String[] words = sentence.split("\\s+");
		return Arrays
				.stream(words)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey).get();
		
	}
	
	public static Map.Entry<Character, Long> findOccurrence(String input) {
	    return input.chars()
	            .mapToObj(c -> (char) c)
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	            .entrySet()
	            .stream()
	            .max(Map.Entry.comparingByValue()).get();
	}


	public static void main(String[] args) {
		System.out.println(CharacterOccurence.findOcurence("aaabbbbccccaaaabbbbcccc"));
		System.out.println(
				CharacterOccurence.findMinAndMaxWord("yhortest1 Find longest and shortest2 word in a sentenceq"));
		System.out.println(
				CharacterOccurence.findMinAndMinWord("yhortest1 Find longest and shortest2 word in a sentenceq"));
		System.out.println(CharacterOccurence
				.findOcurenceEachWord("yhortest1 Find d longest d and d shortest2 word in a sentenceq"));
		System.out.println(CharacterOccurence
				.mostRepeatedWord("yhortest1 Find k k k longest d and d shortest2 word  in in in in a sentenceq"));
		System.out.println(CharacterOccurence.findOccurrence("aaabbbbcccccaaaaabbbbcccc"));

	}
}
