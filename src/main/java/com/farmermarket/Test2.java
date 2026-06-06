package com.farmermarket;

import java.util.stream.IntStream;

public class Test2 {
	public static void main(String[] args) {
		int[] nums1 = { 0, 1, 2 };
		int[] nums2 = { 0, 1, 2, 5 };

		System.out.println("Missing in nums1: " + findMissing(nums1));
		System.out.println("Missing in nums2: " + findMissing(nums2));

	}

	public static int findMissing(int[] nums) {
		int n = nums.length;
		int expectedSum = n * (n + 1) / 2;
		int actualSum = IntStream.of(nums).sum();
		return expectedSum - actualSum;
	}
	
	public static int findMissingNUmber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		int exspetedSum = n * (n + 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			sum = nums[i];
		}
		return exspetedSum - sum;

	}
}
