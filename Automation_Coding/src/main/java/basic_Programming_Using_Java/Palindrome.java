package basic_Programming_Using_Java;

import java.util.function.Consumer;

public class Palindrome {
	
	
	public static void swappingTwoIntegers(boolean withoutTempvariable) {
		int x=1,y=2,z;
		if(!withoutTempvariable) {
		z=x;
		x=y;
		y=z;
		}
		else {
			x=x+y;
			y=x-y;
			x=x-y;
			
		}
		System.out.println(x + " , " + y);
	}
	
	
	// Using reverse function
	public static void palindrome() {
		StringBuffer word = new StringBuffer("madam");
		if(word.reverse()==word) {
			System.out.println("Palindrome");
		}
	}
	
	// Without using reverse function
	
	public static void palindrome_without_reverse_function() {
		Consumer<String> palindrome = (word)-> {
			String reverseWord="";
			for(int i=word.length()-1;i>=0;i--) {
				System.out.println(word.charAt(i));
				reverseWord = reverseWord + String.valueOf(word.charAt(i));
			}
			System.out.println(reverseWord);
		};
		palindrome.accept("madam");
	}
	
	public static void main(String[] args) {
//		palindrome();
//		palindrome_without_reverse_function();
		swappingTwoIntegers(true);
	}

}
