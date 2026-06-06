package com.farmermarket.test;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        List<Integer> sequence = findLongestConsecutive(nums);

        System.out.println("Longest consecutive sequence: " + sequence);
        System.out.println("Length: " + sequence.size());
    }

	public static List<Integer> findLongestConsecutive(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		return set.stream().filter(num -> !set.contains(num - 1)).map(num -> {
			List<Integer> seq = new ArrayList<>();
			int current = num;
			while (set.contains(current)) {
				seq.add(current);
				current++;
			}
			return seq;
		}).max(Comparator.comparingInt(List::size)).orElse(Collections.emptyList());
	}
}

