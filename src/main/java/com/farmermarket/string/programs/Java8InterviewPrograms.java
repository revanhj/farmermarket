package com.farmermarket.string.programs;

//Java 8 Interview Programs

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8InterviewPrograms {

 // 1. Frequency of characters in a string
 public static Map<Character, Long> charFrequency(String input) {
     return input.chars()
         .mapToObj(c -> (char) c)
         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 }

 // 2. First non-repeating character
 public static Character firstNonRepeatingChar(String input) {
     return input.chars().mapToObj(c -> (char) c)
         .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
         .entrySet().stream().filter(e -> e.getValue() == 1)
         .map(Map.Entry::getKey).findFirst().orElse(null);
 }

 // 3. Reverse a string using streams
 public static String reverseString(String input) {
     return Arrays.stream(input.split(""))
         .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
             Collections.reverse(list);
             return String.join("", list);
         }));
 }

 // 4. Count vowels in a string
 public static long countVowels(String input) {
     return input.toLowerCase().chars()
         .filter(c -> "aeiou".indexOf(c) >= 0)
         .count();
 }

 // 5. Palindrome check using Java 8
 public static boolean isPalindrome(String input) {
     return new StringBuilder(input).reverse().toString().equalsIgnoreCase(input);
 }

 // 6. Remove duplicates from a list
 public static List<String> removeDuplicates(List<String> list) {
     return list.stream().distinct().collect(Collectors.toList());
 }

 // 7. Find even numbers from a list
 public static List<Integer> findEvens(List<Integer> list) {
     return list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
 }

 // 8. Sort list of strings by length
 public static List<String> sortByLength(List<String> list) {
     return list.stream()
    		 .sorted(Comparator.comparingInt(String::length))
    		 .collect(Collectors.toList());
 }

 // 9. Second highest number in list
 public static Optional<Integer> secondHighest(List<Integer> list) {
     return list.stream().distinct()
    		 .sorted(Comparator.reverseOrder())
    		 .skip(1).findFirst();
 }

//9. Second highest number in list
	public static Optional<Integer> secondHighestGivenIntArray(int[] input) {
		return Arrays.stream(input).boxed()
				.distinct().sorted(Comparator.reverseOrder())
				.skip(1).findFirst();
	}

 // 10. Join list of strings
 public static String joinStrings(List<String> list) {
     return list.stream().collect(Collectors.joining(", "));
 }

 // 11. Group strings by length
 public static Map<Integer, List<String>> groupByLength(List<String> list) {
     return list.stream().collect(Collectors.groupingBy(String::length));
 }

 // 12. Frequency of words in list
 public static Map<String, Long> wordFrequency(List<String> words) {
     return words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 }

 // 13. Count word occurrence in a sentence
 public static Map<String, Long> countWords(String sentence) {
     return Arrays.stream(sentence.toLowerCase().split("\\W+")).filter(w -> !w.isEmpty())
         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 }

 // 14. Top N frequent elements
 public static List<String> topNFrequent(List<String> list, int n) {
     return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
         .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
         .limit(n).map(Map.Entry::getKey).collect(Collectors.toList());
 }

 // 15. Merge two maps
 public static <K, V> Map<K, V> mergeMaps(Map<K, V> m1, Map<K, V> m2) {
     return Stream.of(m1, m2).flatMap(map -> map.entrySet().stream())
         .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2));
 }

 // 16. Use Optional to avoid nulls
 public static Optional<String> getOptional(String input) {
     return Optional.ofNullable(input);
 }

 // 17. Provide default using Optional
 public static String defaultIfNull(String input) {
     return Optional.ofNullable(input).orElse("default");
 }

 // 18. Transform value with Optional
 public static Integer transformWithOptional(String input) {
     return Optional.ofNullable(input).map(String::length).orElse(0);
 }

 // 19. Chaining Optionals
 public static String chainingOptionals(Optional<String> opt) {
     return opt.flatMap(s -> Optional.of(s.toUpperCase())).orElse("EMPTY");
 }

 // 20. Method reference example
 public static List<String> toUpperCaseList(List<String> list) {
     return list.stream().map(String::toUpperCase).collect(Collectors.toList());
 }

 // 21. Constructor reference
 interface StringCreator {
     String create(String s);
 }

 public static String useConstructorRef(String input) {
     StringCreator creator = String::new;
     return creator.create(input);
 }

 // 22. Static method reference
 public static void printStaticRef(List<Integer> list) {
     list.forEach(Java8InterviewPrograms::printInt);
 }

 public static void printInt(Integer i) {
     System.out.println(i);
 }

 // 23. Current date and time using Java 8
 public static LocalDateTime getCurrentDateTime() {
     return LocalDateTime.now();
 }

 // 24. Add days to current date
 public static LocalDate addDays(int days) {
     return LocalDate.now().plusDays(days);
 }

 // 25. Get day of week/month
 public static DayOfWeek getDayOfWeek(LocalDate date) {
     return date.getDayOfWeek();
 }

 // 26. Flatten list of lists
 public static List<Integer> flattenList(List<List<Integer>> nestedList) {
     return nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
 }

 // 27. Partition list into even and odd
 public static Map<Boolean, List<Integer>> partitionEvenOdd(List<Integer> numbers) {
     return numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
 }

 // 28. Filter map by values
 public static Map<String, Integer> filterMap(Map<String, Integer> map, int threshold) {
     return map.entrySet().stream().filter(e -> e.getValue() > threshold)
         .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
 }

 // 29. Find max salary from employee list
 public static Optional<Employee> findMaxSalary(List<Employee> employees) {
     return employees.stream().max(Comparator.comparing(Employee::getSalary));
 }

 // 30. Sum of integers
 public static int sum(List<Integer> list) {
     return list.stream().reduce(0, Integer::sum);
 }

  // 31. Read file lines using streams
  public static List<String> readFileLines(String path) throws IOException {
      return Files.lines(Paths.get(path)).collect(Collectors.toList());
  }

  // 32. Count lines in file
  public static long countLinesInFile(String path) throws IOException {
      return Files.lines(Paths.get(path)).count();
  }

  // 33. Filter lines with specific word
  public static List<String> filterLinesWithWord(String path, String word) throws IOException {
      return Files.lines(Paths.get(path))
          .filter(line -> line.contains(word))
          .collect(Collectors.toList());
  }

  // 34. Sort employees by salary
  public static List<Employee> sortBySalary(List<Employee> employees) {
      return employees.stream()
          .sorted(Comparator.comparing(Employee::getSalary))
          .collect(Collectors.toList());
  }

  // 35. Filter employee by department
  public static List<Employee> filterByDepartment(List<Employee> employees, String dept) {
      return employees.stream()
          .filter(e -> e.getName().toLowerCase().contains(dept.toLowerCase()))
          .collect(Collectors.toList());
  }

  // 36. Convert list to map
  public static Map<String, Integer> listToMap(List<Employee> employees) {
      return employees.stream()
          .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
  }

  // 37. Find duplicate employees by name
  public static Set<String> findDuplicateNames(List<Employee> employees) {
      return employees.stream()
          .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
          .entrySet().stream()
          .filter(e -> e.getValue() > 1)
          .map(Map.Entry::getKey)
          .collect(Collectors.toSet());
  }

  // 38. Find highest paid employee
  public static Optional<Employee> highestPaid(List<Employee> employees) {
      return employees.stream().max(Comparator.comparing(Employee::getSalary));
  }

  // 39. Parallel stream example
  public static int parallelSum(List<Integer> list) {
      return list.parallelStream().reduce(0, Integer::sum);
  }

  // 40. Reduce example to calculate product
  public static int product(List<Integer> list) {
      return list.stream().reduce(1, (a, b) -> a * b);
  }

  // 41. Map keys to list of values
  public static Map<String, List<String>> groupByInitial(List<String> words) {
      return words.stream()
          .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
  }

  // 42. Zip two lists into a map
  public static <K, V> Map<K, V> zipLists(List<K> keys, List<V> values) {
      return IntStream.range(0, Math.min(keys.size(), values.size()))
          .boxed()
          .collect(Collectors.toMap(keys::get, values::get));
  }

  // 43. Find intersection of two lists
  public static <T> List<T> intersection(List<T> list1, List<T> list2) {
      return list1.stream().filter(list2::contains).collect(Collectors.toList());
  }

  // 44. Remove nulls from list
  public static <T> List<T> removeNulls(List<T> list) {
      return list.stream().filter(Objects::nonNull).collect(Collectors.toList());
  }

  // 45. Count occurrence of each digit
  public static Map<Character, Long> digitFrequency(String input) {
      return input.chars()
          .filter(Character::isDigit)
          .mapToObj(c -> (char) c)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  // 46. Reverse each word in sentence
  public static String reverseEachWord(String sentence) {
      return Arrays.stream(sentence.split(" "))
          .map(word -> new StringBuilder(word).reverse().toString())
          .collect(Collectors.joining(" "));
  }

  // 47. Print n Fibonacci numbers using stream
  public static List<Integer> fibonacci(int n) {
      return Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
          .limit(n)
          .map(f -> f[0])
          .collect(Collectors.toList());
  }

  // 48. Filter strings that start with vowel
  public static List<String> filterStartsWithVowel(List<String> list) {
      return list.stream()
          .filter(s -> s.matches("(?i)^[aeiou].*"))
          .collect(Collectors.toList());
  }

  // 49. Convert list to comma-separated string
  public static String commaSeparated(List<String> list) {
      return String.join(", ", list);
  }

  // 50. Convert Map to List of keys/values
  public static <K, V> List<K> mapKeys(Map<K, V> map) {
      return new ArrayList<>(map.keySet());
  }

  public static <K, V> List<V> mapValues(Map<K, V> map) {
      return new ArrayList<>(map.values());
  }

  // 51. Find prime numbers using streams
  public static List<Integer> findPrimes(int max) {
      return IntStream.rangeClosed(2, max)
          .filter(n -> IntStream.rangeClosed(2, (int)Math.sqrt(n)).allMatch(i -> n % i != 0))
          .boxed()
          .collect(Collectors.toList());
  }

  // 52. Sorting a Map by values
  public static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(Map<K, V> map) {
      return map.entrySet().stream()
          .sorted(Map.Entry.comparingByValue())
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap::new));
  }

 public static void main(String[] args) throws IOException {
     System.out.println(charFrequency("banana"));
     System.out.println(firstNonRepeatingChar("stress"));
     System.out.println(reverseString("Java8"));
     System.out.println(countVowels("Java Interview"));
     System.out.println(isPalindrome("madam"));
 }

 // Dummy Employee class for example #29
 static class Employee {
     private String name;
     private int salary;

     public Employee(String name, int salary) {
         this.name = name;
         this.salary = salary;
     }

     public String getName() { return name; }
     public int getSalary() { return salary; }

     @Override
     public String toString() {
         return name + ": " + salary;
     }
 }
}
