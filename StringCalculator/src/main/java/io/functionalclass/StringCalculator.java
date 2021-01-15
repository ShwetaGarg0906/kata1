package io.functionalclass;

public class StringCalculator {
	public int Add(String str) {
		int length = 0,sum=0;
		if(str.equals("")) {
			return 0;
		}
		else {
			String[] numbers = str.split("\\r?\n|,");
			length = numbers.length;
			for(String s : numbers){
				sum += Integer.parseInt(s);
 			}
			return sum;
		}
	}
}
