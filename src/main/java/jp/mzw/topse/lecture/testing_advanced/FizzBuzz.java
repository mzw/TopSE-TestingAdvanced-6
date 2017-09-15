package jp.mzw.topse.lecture.testing_advanced;

public class FizzBuzz {

	public static void print(final int input) {
		if (input % 3 == 0 && input % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (input % 3 == 0) {
			System.out.println("Fizz");
		} else if (input % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(new Integer(input).toString());
		}
	}

}
