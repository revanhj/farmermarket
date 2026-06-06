package com.farmermarket.string.programs;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseStringUsingStream {

	public static String reverseString(String input) {
		return IntStream.range(0, input.length()).mapToObj(i -> input.charAt(input.length() - 1 - i))
				.map(String::valueOf).collect(Collectors.joining());
	}

	public static void main(String[] args) {
		String input = "Java";
		String reversed = reverseString(input);
		System.out.println("Reversed: " + reversed);
	}
}
