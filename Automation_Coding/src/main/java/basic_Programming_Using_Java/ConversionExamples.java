package basic_Programming_Using_Java;

public class ConversionExamples {

	public static void stringToDouble(String x) {
		System.out.println(Double.parseDouble(x));
	}
	
	public static void stringToInteger(String x) {
		System.out.println(Integer.parseInt(x));
	}
	
	public static void main(String[] args) {
		stringToDouble("1234.54367");
		stringToInteger("12.6543"); // Number Format Exception
		stringToInteger("1243"); // Number Format Exception
	}
	
}
