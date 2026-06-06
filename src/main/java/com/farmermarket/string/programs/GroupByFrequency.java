package com.farmermarket.string.programs;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByFrequency {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 2, 4, 3, 5, 1, 3 };

		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : arr) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		Map<Integer, List<Integer>> groupByFreq = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();

			groupByFreq.computeIfAbsent(freq, k -> new ArrayList<>()).add(num);
		}

		System.out.println("SummerizingInt :" + SummerizingInt());
	}

	public static IntSummaryStatistics SummerizingInt() {
		List<Integer> inputList = Arrays.asList(3, 1, 2, 2, 4, 3, 5, 1, 3);
		IntSummaryStatistics summarizingInt = inputList.stream().collect(Collectors.summarizingInt(Integer::intValue));
		return summarizingInt;
	}
}
