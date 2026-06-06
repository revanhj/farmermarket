package com.farmermarket;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArrays {

	public static int[] mergeAndSortUnique(int[] a, int[] b) {
		return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
	}

	public static void main(String[] args) {
		int[] a = { 4, 2, 5, 1 };
		int[] b = { 8, 1, 9, 5 };

		int[] result = mergeAndSortUnique(a, b);

		System.out.println(Arrays.toString(result));
	}
}
