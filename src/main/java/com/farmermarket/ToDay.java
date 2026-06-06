package com.farmermarket;

import java.util.List;
import java.util.stream.Collectors;

public class ToDay {

	public static List<Integer> findSqureEvenNumber(List<Integer> numbers) {
		return numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
	}

	public static boolean findPolidrom(String input) {

		int left = 0;
		int right = input.length() - 1;

		while (left < right) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(ToDay.findPolidrom("madam"));
	}

}
