package basic_Programs_Using_Java8;

import java.util.function.Consumer;

public class PyramidProblems {

	static Consumer<Integer> oddRows = (num) -> {
		int k = 1;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
			k += 2;
		}
	};

	public static void main(String[] args) {
		oddRows.accept(5);
	}
}
