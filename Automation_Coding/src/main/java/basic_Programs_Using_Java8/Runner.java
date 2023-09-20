package basic_Programs_Using_Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Supplier;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class Runner {

	static Function<String, String> stringPalindrome = (input) -> {
		String reversedString = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reversedString += input.charAt(i);
		}
		if (input.equals(reversedString))
			return "Palindrome";

		return "Not Palindrome";
	};

	static Consumer<Integer> primeNumber = (num) -> {
		boolean check = false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				check = true;
		}
		if (check || num == 1) {
			System.out.println(num + " is Not Prime");
		} else {
			System.out.println(num + " is Prime");
		}
	};

	static BiConsumer<Integer, Integer> swapNumbersWithoutThirdVariable = (a, b) -> {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a + "," + b);
	};

	static Function<Integer, Integer> factorialOfNumber = (num) -> {
		int fact = 1;
		for (int i = num; i > 0; i--) {
			fact *= i;
		}
		return fact;
	};

	static Consumer<Integer> reverseNumberUsingClassicalWay = (num) -> {
		boolean check = false;
		if (String.valueOf(num).contains("0")) {
			check = true;
		}
		if (!check) {
			int reminder, reverse = 0, trueValue = num;
			while (num > 0) {
				reminder = num % 10;
				reverse = reverse * 10 + reminder;
				num /= 10;
			}
			System.out.println("Exact Value is : " + trueValue + ", Reversed value is : " + reverse);
		} else {
			String exactValue = String.valueOf(num);
			StringBuilder sb = new StringBuilder(exactValue);
			System.out.println("Exact Value is : " + exactValue + ", Reversed value is : " + sb.reverse());
		}
	};

	static Consumer<Integer> fibonacciSeries = (num) -> {
		int t1 = 0, t2 = 1, t3;
		System.out.print("Fibonacci Series : ");
		while (num > 0) {
			t3 = t1 + t2;
			System.out.print(t1 + "   ");
			t1 = t2;
			t2 = t3;
			num--;
		}
		System.out.println();
	};

	static Consumer<Integer> armstrongNumber = (num) -> {
		int reminder, arm = 0, exactValue = num;
		int noOfDigits = num.toString().length();
		System.out.println(noOfDigits);
		while (num > 0) {
			reminder = num % 10;
			arm += (Math.pow(reminder, noOfDigits));
			num /= 10;
		}
		if (exactValue == arm) {
			System.out.println("Armstrong Number");
		} else {
			System.out.println("Not Armstrong Number");
			System.out.println(exactValue + "," + arm);
		}

	};

	static Consumer<Integer> calucateNoOfDigits = (num) -> {
		if (num >= 0) {
			System.out.println(String.valueOf(num).length());
		} else {
			System.out.println(String.valueOf(num * -1).length());
		}
	};

	static Consumer<String> findNumberOfDuplicateWordsInString = (line) -> {
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		String words[] = line.split(" ");
		for (String word : words) {
			if (wordCount.containsKey(word.toLowerCase())) {
				wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase()) + 1);
			} else {
				wordCount.put(word.toLowerCase(), 1);
			}
		}
		System.out.println(wordCount); // To print entire map
		// To Print only duplicate value

		Set<String> wordsInString = wordCount.keySet();

		for (String word : wordsInString) {
			if (wordCount.get(word) > 1) {
				System.out.println(word + " : " + wordCount.get(word));
			}
		}

	};

	static Consumer<String> countNumberOfWordsInString = (line) -> {
		System.out.println(line.split(" ").length);
	};

	static Supplier<Integer> countNumberOfOccurencesOfGivenCharacterInStringWithoutLoop = () -> {
		String givenWord = "Sharath";
		char ch = 'h';
		int count = givenWord.length() - givenWord.replace(String.valueOf(ch), "").length();
		return count;
	};

	static Consumer<String> countOccurencesOfEachCharacterInString = (word) -> {
		Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
		for (char c : word.toLowerCase().toCharArray()) {
			if (characterCount.containsKey(c)) {
				characterCount.put(c, characterCount.get(c) + 1);
			} else {
				characterCount.put(c, 1);
			}
		}
		System.out.println(characterCount);
		// For Duplicate characters alone
		Set<Character> characters = characterCount.keySet();
		for (char c : characters) {
			if (characterCount.get(c) > 1) {
				System.out.println(c + " : " + characterCount.get(c));
			}
		}

	};

	static String recursiveMethod(String word1) {
		if (word1.isEmpty()) {
			return word1;
		} else {
			return recursiveMethod(word1.substring(1)) + word1.charAt(0);
		}
	}

	static void reverseNumberUsingRecursion(int num) {
		if (num < 10) {
			System.out.print(num);
		} else {
			System.out.print(num % 10);
			reverseNumberUsingRecursion(num / 10);
		}
	};

	static Consumer<Integer> reverseNumberUsingRecursionWithMethodReferenceOperator = Runner::reverseNumberUsingRecursion;

	static Function<String, String> removeWhiteSpacesWithReplace = (word) -> word.replaceAll("\\s", "");
	/* \\s is the regex used for removing all spaces in string */

	static Consumer<String> removeWhiteSpacesWithoutReplace = (word) -> {
		String wordAfterRemovingSpaces = "";
		for (char ch : word.trim().toCharArray()) {
			if (ch == ' ') {
				continue;
			} else {
				wordAfterRemovingSpaces += String.valueOf(ch);
			}
		}

		System.out.println(wordAfterRemovingSpaces);
	};

	static Consumer<Integer> floydsTriangle = (numberOfRows) -> {
		System.out.println();
		int number = 1;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}
	};

	static Runnable addTwoMatrices = () -> {

		System.out.println();
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int c[][] = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

	};

	static Runnable multiplyTwoMatrices = () -> {

		System.out.println();
		int a[][] = { { 3, 1, 1 }, { 8, 9, 4 }, { 2, 5, 6 } };
		int b[][] = { { 3, 5, 7 }, { 3, 1, 8 }, { 10, 5, 2 } };
		int c[][] = new int[a.length][b.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < a.length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	};

	static Runnable transposeOfMatrix = () -> {

		System.out.println();
		int a[][] = { { 3, 1, 1 }, { 8, 9, 4 }, { 2, 5, 6 } };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j][i] + " ");
			}
			System.out.println();
		}
	};

	static Consumer<List<Integer>> maximumandSecondMaximumNumberFromList = (list) -> {
		int max = 0;
		for (int i : list) {
			if (i > max) {
				max = i;
			}
		}
		System.out.println("Maximum value from list " + list + " is : " + max);

		int secondMax = 0;
		for (int i : list) {
			if (i < max && i > secondMax) {
				secondMax = i;
			}
		}

		System.out.println("Second maximum value from list " + list + " is : " + secondMax);
	};

	static BiPredicate<String, String> checkTwoStringsAreAnagram = (word1, word2) -> {
		if (word1.length() != word2.length()) {
			return false;
		} else {
			boolean check = true;
			for (char ch : word1.toCharArray()) {
				if (!word2.contains(String.valueOf(ch))) {
					check = false;
				}
			}
			return check;
		}
	};

	static Runnable checkArraysAreEqual = () -> {
		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 1, 1, 3, 4, 5 };

		// Using Inbuilt function
		System.out.println("Using Inbuilt Function : " + Arrays.equals(a, b));

		// Using classical way
		if (a.length != b.length) {
			System.out.println("Arrays are Not Equal");
		} else {
			boolean check = false;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					check = true;
				}
			}
			if (!check) {
				System.out.println("Arrays are Equal");
			} else {
				System.out.println("Arrays are Not Equal");
			}
		}

	};

	static BiConsumer<Integer, Integer> printAllPrimeNumbersInRange = (start, end) -> {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			numbers.add(i);
		}
		numbers.forEach(prime -> primeNumber.accept(prime));
	};

	static Runnable generateRandomNumber = () -> {
		// Approach 1
		Random rand = new Random();

		// it will return any random value from 0-9
		// 999 is last value , if you give 1000 it will return a random value from 0-999
		int random = rand.nextInt(10);
		System.out.println(random);

		// for generating double numbers
		double rand_double = rand.nextDouble();
		System.out.println(rand_double);

		// Approach 2 using math.random()

		System.out.println(Math.random());

		// Approach 3 using apache third party api

		// it will return a number with 5 digits , it will return in string format

		String randNum = RandomStringUtils.randomNumeric(5);
		System.out.println(randNum);

		// It will return a string with five alphabets
		System.out.println(RandomStringUtils.randomAlphabetic(5));
	};

	static Consumer<Integer[]> findDuplicateElementsInArray = (array) -> {
		// Approach 1
		/*
		 * for (int i = 0; i < array.length; i++) { for (int j = i + 1; j <
		 * array.length; j++) { if (array[i] == array[j]) {
		 * System.out.println("Duplicate found : " + array[i]); } } }
		 */
		// Approach 2
		HashSet<Integer> hs = new HashSet<Integer>();
		boolean check = true;
		for (int i : array) {
			if (hs.add(i) == false) {
				check = false;
				System.out.println("Duplicate found : " + i);
			}
		}

		if (check) {
			System.out.println("No Duplicate found!");
		}
	};

	static Runnable removeJunkOrSpecialCharactersInString = () -> {
		String s = "!@#$%^&*(Sharath Automation*(&";
		System.out.println(s.replaceAll("[^a-zA-Z0-9]", "")); // Here ^ is mainly used to remove special/junk characters
																// other than alphanumeric
	};

	static void findDuplicates() {
		String line = "Hi Hi Sharath, Welcome welcome";
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String i : line.toLowerCase().split(" ")) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		System.out.println(map);

		Set<String> set = map.keySet();
		for (String i : set) {
			if (map.get(i) > 1) {
				System.out.println(i);
			}
		}

	}

	static void findDuplicatesUsingArraySort() {
		String line = "Hi Sharath Hi Welcome welcome";
		String arr[] = line.toLowerCase().split(" ");
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals(arr[i + 1])) {
				System.out.println("Duplicate found : " + arr[i]);
			}
		}
	}

	static int factorialUsingRecursion(int num) {
		if (num < 1)
			return 1;
		else
			return num * factorialUsingRecursion(num - 1);
	}

	public static void main(String[] args) {

		System.out.println(stringPalindrome.apply("madam"));
		primeNumber.accept(7);
		swapNumbersWithoutThirdVariable.accept(1, 2);
		System.out.println(factorialOfNumber.apply(5));
		reverseNumberUsingClassicalWay.accept(1000090);
		fibonacciSeries.accept(10);
		armstrongNumber.accept(163);
		calucateNoOfDigits.accept(0);
		findNumberOfDuplicateWordsInString.accept("Eat Sleep Eat Repeat eat");
		countNumberOfWordsInString.accept("Eat Sleep Eat Repeat eat");
		System.out.println(countNumberOfOccurencesOfGivenCharacterInStringWithoutLoop.get());
		System.out.println("Using Recursion : " + recursiveMethod("Sharath"));
		countOccurencesOfEachCharacterInString.accept("Sharath");
		reverseNumberUsingRecursionWithMethodReferenceOperator.accept(1234567890);
		System.out.println();
		System.out.println(removeWhiteSpacesWithReplace.apply("S h a r a t h"));
		removeWhiteSpacesWithoutReplace.accept("S h a r a t h");
		floydsTriangle.accept(5);
		addTwoMatrices.run();
		multiplyTwoMatrices.run();
		transposeOfMatrix.run();
		maximumandSecondMaximumNumberFromList.accept(Arrays.asList(10, 12, 55, 33, 55, 55, 54));
		System.out.println("Anagram ?! : " + checkTwoStringsAreAnagram.test("listen", "silent"));
		checkArraysAreEqual.run();
		printAllPrimeNumbersInRange.accept(20, 40);
		generateRandomNumber.run();
		Integer a[] = { 1, 2, 3, 4, 5 };
		findDuplicateElementsInArray.accept(a);
		removeJunkOrSpecialCharactersInString.run();

		findDuplicates();
		findDuplicatesUsingArraySort();
		System.out.println(factorialUsingRecursion(5));
	}

}
