package com.farmermarket.string.programs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

	public static Integer findMajorityElement(int[] arr) {

		int n = arr.length/2;
		return Arrays.stream(arr)
				.boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(data->data.getValue() > n)
				.map(Map.Entry::getKey)
				.findFirst().get();
	}

	public static int findMostFrequentElement(int[] arr) {
		return Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
		
	}

	public static Character findMostFrequentCharacter(String input) {
		return input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
		
	}

	public static Integer secondLargest(int[] arr) {
		return Arrays.stream(arr)
				.distinct()
				.boxed()
				.sorted(Collections.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };

		String input = "Revanasiddappa";
		System.out.println(MajorityElement.secondLargest(arr));
	}
}
