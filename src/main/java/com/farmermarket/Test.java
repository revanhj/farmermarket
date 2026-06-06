package com.farmermarket;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    // 1) Find frequency of only duplicate characters
    public static Map<String, Long> frequencyOfOnlyDuplicateChar(String input) {
        return Arrays.stream(input.replaceAll("\\s+", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // 2) Arrange in alphabetical order and remove duplicates
    public static String removeDuplicatesAndSort(String input) {
        return Arrays.stream(input.replaceAll("\\s+", "").split(""))
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }

    // 3) Find the second non-repeating character
    public static Optional<Map.Entry<String, Long>> secondNonRepeated(String input) {
        return Arrays.stream(input.replaceAll("\\s+", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .skip(1) // skip the first non-repeated
                .findFirst();
    }

    public static void main(String[] args) {
        String input = "REVANASIDDAPPA JEEVANAGI INTERVIEW TODAY";

        System.out.println("Duplicate characters frequency: " + frequencyOfOnlyDuplicateChar(input));
        System.out.println("Sorted unique characters: " + removeDuplicatesAndSort(input));
        secondNonRepeated(input)
                .ifPresent(e -> System.out.println("Second non-repeated char: " + e.getKey()));
    }
}
