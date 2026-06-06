package com.farmermarket.string.programs;

/*✅ Core String Manipulation Programs (Java)
🔤 Basic Operations
Reverse a string
Check if string is palindrome
Count vowels and consonants
Remove all whitespaces
Find length of string (without using .length())
Compare two strings without using equals()
🔁 Character-Level Analysis
Count occurrences of each character
Find first non-repeated character
Find first repeated character
Remove duplicate characters
Check if two strings are anagrams
Check if string contains only digits
Swap two strings without third variable
Capitalize each word in a sentence
🔍 Word-Level Manipulation
Reverse words in a sentence
Count number of words in sentence
Find longest and shortest word in a sentence
Count number of words with length N
Sort words alphabetically
Print words that start with a vowel
🔢 Pattern-Based Logic
Check if string contains only alphabets
Count uppercase and lowercase characters
Check if a string is a pangram (contains all 26 letters)
Replace character in string (without using replace())
Split string without using split()
Extract numbers from a string
🧠 Advanced / Logical
Find all permutations of a string
Print all substrings of a string
Longest common prefix from list of strings
Check if one string is a rotation of another
Compress a string (e.g., aaabb → a3b2)
Remove consecutive duplicate characters
Frequency-based sorting of characters
Check if string is made of repeated substrings
Implement your own trim(), substring(), equals()

☕ Java 8 Specific
Use Stream to find frequency of each word
Filter list of strings (e.g., startsWith, contains, length > n)
Group strings by length using streams
Count distinct characters using streams
Sort characters in string using streams

Capzemini Interview Quetions with Answers
1)  Write a program to find the least occurring character in a string.
2)  Write code to group employees by salary.
3)  Write code to find the second largest element in an array
4   Write code to print the unique elements from an array.
5)  Write code Given a list of employees with their ratings, how can you sort the employees based on their ratings using the Java 8 Streaming API?
6)  Write code Missing number
7)  Write codeSecond highest number
8)  Write codeDuplicates with streams*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThirdHighestSalary {
    
	public static Optional<Employee> findThirdHighestSalry(List<Employee> employeeList) {
		return employeeList.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary))
				.skip(1)
				.findFirst();
	}
	
	public static Optional<Entry<Character, Long>> findThirdHighestCharcter(String input) {
		return input.chars().mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.sorted(Entry.<Character, Long>comparingByValue(Comparator.reverseOrder())
				.thenComparing(Entry.comparingByKey()))
				.skip(1)
				.findFirst();
	}
    
	public static String removeDuplicateChars(String input) {
		return input
				.chars()
				.mapToObj(ch -> (char) ch)
				.distinct()
				.map(String::valueOf)
				.collect(Collectors.joining());
	}
	
	public static Optional<Character> firstRepeatedChar(String input) {
		Set<Character> seen = new HashSet<>();
		return input.chars().sorted()
				.mapToObj(ch->(char)ch).filter(x->!seen.add(x))
				.findFirst();
	}
    
	public static String capitalizeWords(String sentence) {
	    return Arrays.stream(sentence.trim().split("\\s+"))
	        .map(w -> w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase())
	        .collect(Collectors.joining(" "));
	}
    
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("ABc", 10000));
		employeeList.add(new Employee("BCA", 20000));
		employeeList.add(new Employee("CBA", 30000));
		employeeList.add(new Employee("CAB", 40000));
		
		System.out.println(ThirdHighestSalary.findThirdHighestSalry(employeeList));
		System.out.println(ThirdHighestSalary.findThirdHighestCharcter("aabbcccddddd"));
		System.out.println(ThirdHighestSalary.removeDuplicateChars("aabbcccddddd"));
		System.out.println(ThirdHighestSalary.firstRepeatedChar("bcdddddaa"));
		System.out.println(ThirdHighestSalary.capitalizeWords("bcd dd dd aa"));
	}
}
