package com.farmermarket.string.programs;

import java.util.Arrays;
import java.util.Comparator;

//Find the word that has the second highest length
public class YoutubePrograms {

	public static String secondHighestLength(String input) {
	    return Arrays.stream(input.split("\\s+"))
	        .sorted(Comparator.comparingInt(String::length).reversed())
	        .distinct() // Optional: ignore duplicate words of same length
	        .skip(1) // skip the longest
	        .findFirst()
	        .orElse(null); // or throw exception / return "Not Found"
	}

	
	public static void main(String[] args) {
		System.out.println(YoutubePrograms.secondHighestLength("hb sds mkkk"));
	}
}
