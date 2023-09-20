package basic_Programs_Using_Java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class TwoSumProblem {

	// This approach time complexity is O(n*n)

	static BiPredicate<Integer[], Integer> twoSumUsingBruteForce = (arr, target) -> {
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					flag = true;
					System.out.println("Two Sum for target " + target + " is : " + i + "," + j);
					break;
				}
			}
			if (flag == true) {
				return true;
			}
		}

		if (flag == false) {
			System.out.println("No match found!");
		}
		return false;
	};

	static BiFunction<Integer[], Integer, String> twoSumUsingMap = (arr, target) -> {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(target - arr[i])) {
				return "Two Sum for target " + target + " is : " + map.get(target - arr[i]) + "," + i ;
			} else {
				System.out.println(i);
				map.put(arr[i], i);
			}

		}
		return "NO Match Found!";
	};

	public static void main(String[] args) {
		Integer[] arr = { 5, 1, 3, 4 };
		twoSumUsingBruteForce.test(arr, 9);
		System.out.println(twoSumUsingMap.apply(arr, 9));
	}

}
