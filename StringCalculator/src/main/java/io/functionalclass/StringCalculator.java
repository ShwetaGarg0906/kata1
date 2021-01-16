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
		int sum=0,num=0;
		int i=0,noOfDel=0;
		String numString,delimiter;
		String[] numbers;
		StringBuilder sb = new StringBuilder();
		StringBuilder regex = new StringBuilder();
		regex.append("\\r?");
		
		//if string is empty return 0
		if(str.equals("")) {
			System.out.println("empty string..");
			return 0;
		}
		else {
			//splitting string to string array here....
			if(str.startsWith("//")) {
				//logic to fetch all the delimiters
				if(str.substring(2,3).equals("[")) {
					//no of delimiters
					i=2;
					while(i!=-1) {
						noOfDel++;
						i = str.indexOf('[', i+1);
					}
					
					System.out.println("no of delimiters are "+ noOfDel);
					
					//if noOfDelim more than 1 with each delimiter of length 1
					if(noOfDel>1) {
						int index = str.indexOf(']');
						//filter all the delimiters
						while(index!=-1) {
							regex.append(Pattern.quote(str.substring(index-1, index))+"|");
							//next possible position where ] could be found 
							index = str.indexOf(']', index+1); 
						}
						//remove extra pipe(|)  
						regex.replace(regex.length()-1,regex.length() , "");
						index = str.lastIndexOf(']');
						numString = str.substring(index+2);
					}
					//when there is only delimiter with length greater than 1 in []
					else {
						int lastIndex = str.indexOf(']');
						delimiter = str.substring(3,lastIndex);
						regex.append(Pattern.quote(delimiter));
						numString = str.substring(lastIndex+2);	
					}
				}  
				// one delimiter of size 1
				else {
					delimiter = str.substring(2,3);	
					regex.append(Pattern.quote(delimiter));
					numString = str.substring(4);
				}
				numbers = numString.split(regex.toString()); 
			}
			//handles test cases of up to 3 steps 
			else {
				numbers = str.split("\\r?\n|,");
			}
			
			//performing the addition operation
			for(String s : numbers){
				System.out.println(s);
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
