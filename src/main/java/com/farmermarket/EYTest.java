package com.farmermarket;

import java.util.Arrays;
import java.util.Comparator;

public class EYTest {
	
	 //,Print the second highest element of a Array using java 8
	
	public static int secondHighestNumber(int [] arr) {
		return Arrays
				.stream(arr)
				.boxed()
				.sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	}
	
	//Given an array – int[] arr = {1,2,4,0,-8,-5}.
	
	
	public static void targetSum(int[] arr) {
		int targetValue = 3;
	
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (sum == targetValue) {
					System.out.println(arr[i] +" " +arr[j]);
				}
			}
		}
	}
	
public static void main(String[] args) {
	
	int [] arr = {1,2,4,0,-8,-5};
	
	System.out.println(EYTest.secondHighestNumber(arr));
	EYTest.targetSum(arr);
}
}
