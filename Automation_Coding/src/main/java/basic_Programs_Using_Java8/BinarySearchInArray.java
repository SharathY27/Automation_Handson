package basic_Programs_Using_Java8;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class BinarySearchInArray {

	// For Binary Search Array should be in sorted order

	static BiConsumer<int[], Integer> sortingUsingInbuiltBinarySearch = (arr, num) -> {
		System.out.println(Arrays.binarySearch(arr, num));
		// It will return the index of num value if found
	};

	static BiConsumer<int[], Integer> sortingUsingBinarySearchLogic = (arr, num) -> {
		int lowerBound = 0;
		int upperBound = arr.length;
		boolean flag = false;
		while (lowerBound < upperBound) {
			int middle = (lowerBound + upperBound) / 2;
			if (arr[middle] == num) {
				System.out.println("Element Found at index : " + middle);
				flag = true;
				break;
			}
			if (arr[middle] < num) {
				lowerBound = middle + 1;
			}
			if (arr[middle] > num) {
				upperBound = middle - 1;
			}
			// Imagine array is standing upright and think of lowerbound and upperbound
		}

		if (flag == false) {
			System.out.println("Element Not Found!");
		}
	};

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		sortingUsingBinarySearchLogic.accept(arr, 50);
		sortingUsingInbuiltBinarySearch.accept(arr, 3);
	}

}
