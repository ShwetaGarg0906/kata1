package io.functionalclass;

public class StringCalculator {
	public int Add(String str) {
		int length = 0;
		if(str.equals("")) {
			return 0;
		}
		else {
			String[] numbers = str.split(",");
			length = numbers.length;
			if(length==1) {
				return Integer.parseInt(numbers[0]);
			}
			else if(length==2) {
				return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
			}
			else {
				return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]) +Integer.parseInt(numbers[2]);
			}
		}
	}
}
