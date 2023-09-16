package basic_Programs_Using_Java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.poi.ss.formula.functions.Replace;

import com.google.common.base.Supplier;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

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

	static Predicate<Integer> primeNumber = (num) -> {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
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
			System.out.print(t1 + "   ");
			t3 = t1 + t2;
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

	public static void main(String[] args) {
		System.out.println(stringPalindrome.apply("madam"));
		System.out.println(primeNumber.test(7));
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

	}

}
