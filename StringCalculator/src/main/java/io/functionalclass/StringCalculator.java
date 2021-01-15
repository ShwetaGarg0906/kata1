package io.functionalclass;

import java.util.regex.Pattern;

public class StringCalculator {
	private int countCalled;
	
	public StringCalculator() {
		countCalled = 0;	
	}
	
	public int getCountCalled() {
		return countCalled;
	}
	
	public void displayCounter() {
		System.out.println(getCountCalled());
	}
	
	public int Add(String str) {
		countCalled++;
		displayCounter();
		int length = 0,sum=0,num=0;
		String numString;
		String[] numbers;
		StringBuilder sb = new StringBuilder();
		if(str.equals("")) {
			return 0;
		}
		else {
			//convert to numbers array
			if(str.startsWith("//")) {
				String delimiter = str.substring(2,3);
//				System.out.println("delimiter is "+delimiter);
				numString = str.substring(4);
//				System.out.println("string is "+numString);
				numbers = numString.split(Pattern.quote(delimiter)); 
			}
			else {
				numbers = str.split("\\r?\n|,");
			}
			
			//performing the addition operation
			length = numbers.length;
			for(String s : numbers){
				num = Integer.parseInt(s);
				if(num<0) {
					sb.append(num+",");
				}
				else if(num<=1000){
					sum += num;	
				}
 			}
			if(!sb.toString().equals("")) {
				throw new IllegalArgumentException(sb.toString()+ " are not allowed " );
			}
			
			return sum;
		}
	}
}
