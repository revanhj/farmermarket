package com.farmermarket;

public class CountPairsWithSum {

	public static int countPairsWithSum(int[] arr, int k) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 70, 6, 8, 3, 2, 2, 2, 8 };
		int k = 8;

		System.out.println(countPairsWithSum(arr, k));
	}
}
