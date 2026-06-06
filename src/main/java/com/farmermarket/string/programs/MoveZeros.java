package com.farmermarket.string.programs;

public class MoveZeros {
	public static void moveZerosToEnd(int[] arr) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index++] = arr[i];
			}
		}
		while (index < arr.length) {
			arr[index++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 12 };
		moveZerosToEnd(arr);

		System.out.print("Output: ");
		for (int n : arr)
			System.out.print(n + " ");
	}
}
