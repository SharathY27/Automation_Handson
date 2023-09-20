package basic_Programs_Using_Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class ArraySorting {

	static Consumer<List<Integer>> sortingListClassicalWay = (list) -> {
		int temp;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) { // > for ascending ; < for descending
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		System.out.println(list);
	};

	// This is Bubble Sort
	static Consumer<Integer[]> sortingArrayClassicalWay = (arr) -> {
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) { // > for ascending ; < for descending
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.print(Arrays.toString(arr));

	};

	// Using Inbuilt functions

	static Consumer<Integer[]> parallelSortInbuiltFunction = (arr) -> {
		System.out.println("Array before sorting : " + Arrays.toString(arr));
		Arrays.parallelSort(arr);
		System.out.println("Array after sorting : " + Arrays.toString(arr));
	};

	static Consumer<Integer[]> sortInbuiltFunction = (arr) -> {
		System.out.println("Array before sorting : " + Arrays.toString(arr));
		Arrays.parallelSort(arr);
		System.out.println("Array after sorting : " + Arrays.toString(arr));
	};

	static Consumer<Integer[]> reverseSortInbuiltFunction = (arr) -> {
		System.out.println("Array before sorting : " + Arrays.toString(arr));
		Arrays.parallelSort(arr, Collections.reverseOrder());
		System.out.println("Array after sorting : " + Arrays.toString(arr));
	};

	public static void main(String[] args) {
		sortingListClassicalWay.accept(Arrays.asList(9, 4, 8, 5, 6, 3, 2, 22));
		sortingArrayClassicalWay.accept(new Integer[] { 9, 4, 8, 5, 6, 3, 2, 22 });
		parallelSortInbuiltFunction.accept(new Integer[] { 9, 4, 8, 5, 6, 3, 2, 22 });
		sortInbuiltFunction.accept(new Integer[] { 9, 4, 8, 5, 6, 3, 2, 22 });
		reverseSortInbuiltFunction.accept(new Integer[] { 9, 4, 8, 5, 6, 3, 2, 22 });

	}

}
