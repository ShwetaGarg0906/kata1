package io.functionalclass;

import java.util.regex.Pattern;

public class StringCalculator {
	public int Add(String str) {
		int length = 0,sum=0;
		String numString;
		String[] numbers;
		if(str.equals("")) {
			return 0;
		}
		else {
			//convert to numbers array
			if(str.startsWith("//")) {
				String delimiter = str.substring(2,3);
				numString = str.substring(4);
				numbers = numString.split(Pattern.quote(delimiter)); 
			}
			else {
				numbers = str.split("\\r?\n|,");
			}
			
			//performing the addition operation
			length = numbers.length;
			for(String s : numbers){
				sum += Integer.parseInt(s);
 			}
			return sum;
		}
	}
}
