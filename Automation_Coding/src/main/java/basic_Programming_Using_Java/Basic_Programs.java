package basic_Programming_Using_Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;

public class Basic_Programs {

	public static void reverseStringUsingStringBuilder(String check) {
		Function<String, String> reverse = (word) -> {
			return new StringBuilder(word).reverse().toString();
		};

		System.out.println(reverse.apply(check));
	}

	public static void reverseStringUsingLoop(String word) {
		String reversed = "";
		for (Character ch : word.toCharArray()) {
			reversed = ch + reversed;
		}
		System.out.println(reversed);
	}

	public static String reverseStringUsingSubstring(String word) {
		if (word.isEmpty()) {
			return word;
		}
		return reverseStringUsingSubstring(word.substring(1)) + word.charAt(0);
	}

	public static boolean checkDuplicate(String word) {
		Set<Character> check = new HashSet<>();
		for (Character ch : word.toCharArray()) {
			check.add(ch);
		}
		if (word.length() == check.size())
			return false;
		return true;
	}

	public static void findUniqueValuesInMap() {
		Map<String, Integer> employee = new HashMap<String, Integer>();
		employee.put("Sharath", 23);
		employee.put("Mani", 21);
		Map<String, Integer> students = new HashMap<String, Integer>();
		students.put("Sharath", 23);
		students.put("Vinoth", 23);

		System.out.println("This is one method : " + employee.values().stream().distinct().count());

		Set<Integer> set = new HashSet<Integer>();
		set.addAll(employee.values());
		System.out.println(set);

	}

	public static void sortingStringInAlphabeticalOrder(String word) {
		char[] ch = word.toLowerCase().toCharArray();
		Arrays.sort(ch);
		System.out.println("One method of Sorting : " + new String(ch));

		char ch2[] = word.toLowerCase().toCharArray();
		char temp;
		for (int i = 0; i < ch2.length; i++) {
			int j = i + 1;
			while (j < ch2.length) {
				if (ch2[i] > ch2[j]) {
					temp = ch2[i];
					ch2[i] = ch2[j];
					ch2[j] = temp;
				}
				j += 1;
			}
		}

		System.out.println("Other method of Sorting : " + new String(ch2));

	}

	public static void findDuplicateUsingMap(String words) {
		Consumer<String> check = (word) -> {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (char c : word.toCharArray()) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}

			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() > 1) {
					System.out.println(entry.getKey() + " , " + entry.getValue());
				}
			}

		};

		check.accept(words);
	}

	public static void reverseNumberUsingClassicalWay(int num) {

		int rem, rev = 0;
		while (num != 0) {
			rem = num % 10;
			rev = rev * 10 + rem;
			num /= 10;
		}

		System.out.println(rev);

	}

	public static void reverseUsingStack(String word) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : word.toCharArray()) {
			stack.push(c);
		}
		String rev = "";
		System.out.println(stack);
		while (!stack.isEmpty())
			rev += stack.pop();

		System.out.println(stack);
		System.out.println("Reversed : " + rev);
	}

	public static void swapTwoNumbers() {
		int n1 = 10, n2 = 15;

		n1 = n1 + n2;
		n2 = n1 - n2;
		n1 = n1 - n2;

		System.out.println(n1 + " , " + n2);
		int temp;

		temp = n1;
		n1 = n2;
		n2 = temp;

		System.out.println(n1 + " , " + n2);
	}

//	public static void 

	public static void main(String[] args) {
//		reverseString("adam");
//		reverseStringUsingLoop("adam");
//		System.out.println(reverseStringUsingSubstring("adams"));
//		System.out.println(checkDuplicate("ada"));
//		System.out.println(checkDuplicate("adqwer"));
//		findUniqueValuesInMap();
//		findDuplicateUsingMap("Sharath");
//		sortingStringInAlphabeticalOrder("edcba");
//		reverseNumberUsingClassicalWay(1234567);
//		reverseUsingStack("Sharath Kumar");
//		swapTwoNumbers();
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Sharath");
		map.put(2, "Shankar");
		map.put(3, "Shankar");
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(1, "Sharath1");
		map2.put(4, "Shankar2");
		map2.put(3, "Shankar");

		/*
		 * Set<Integer> set1 = map.keySet(); for (Integer a : map2.keySet()) { if
		 * (set1.contains(a)) { System.out.println("Unique values are " + a); }
		 * System.out.println("no"); }
		 */
//		int count = new HashSet<>(map.keySet()).size();
		for (Integer val : map2.keySet()) {
			
			if(map.containsKey(val)) {
				System.out.println(map.get(val));
			}
		}
		
		

	}

}
