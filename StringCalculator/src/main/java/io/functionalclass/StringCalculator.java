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
		String numString,delimiter;
		String[] numbers;
		StringBuilder sb = new StringBuilder();
		StringBuilder regex = new StringBuilder();
		regex.append("\\r?");
		
		//empty string
		if(str.equals("")) {
			return 0;
		}
		else {
			//splitting string to string array here....
			if(str.startsWith("//")) {
				if(str.substring(2,3).equals("[")) {
					int startIndex =3, lastIndex = str.indexOf(']');
					
					//get all the delimiters here ....
					while(lastIndex!=-1) {
						delimiter = str.substring(startIndex,lastIndex) ;
						regex.append(Pattern.quote(delimiter)+ "|");
						startIndex = lastIndex+2;
						lastIndex = str.indexOf(']', startIndex);
					}
					
					//remove extra pipe(|)  
					regex.replace(regex.length()-1,regex.length() , "");
					numString = str.substring(str.lastIndexOf(']')+2);
				}
				//one delimiter of variable length
				else {
					delimiter = str.substring(2,3);	
					numString = str.substring(4);
					regex.append(Pattern.quote(delimiter));
				}
				numbers = numString.split(regex.toString()); 
			}
			else {
				//handles test cases of up to 3 steps 
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
