package basic_Programming_Using_Java;

import java.util.function.Consumer;

public class FibonacciSeries {

	public static void fibonacci(int number) {
		Consumer<Integer> series = (num) -> {
			int t1 = 0, t2 = 0, t3 = 1;
			for (int i = 0; i < num; i++) {
				t1 = t2;
				t2 = t3;
				t3 = t1 + t2;
				System.out.println(t1);
			}
		};

		series.accept(number);
	}

	public static int recursion(int count) {
		if(count==0)
			return 0;
		if(count==2||count==1)
			return 1;
		return recursion(count-1)+recursion(count-2);
	}
	public static void main(String[] args) {

		// Here we are going to print the number from 1 to 20 in fibonacci series

//		FibonacciSeries.fibonacci(10);
		for(int i=0;i<10;i++)
			System.out.println(recursion(i));
		
		
		

	}

}
