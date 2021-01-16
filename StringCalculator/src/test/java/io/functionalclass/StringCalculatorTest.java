package io.functionalclass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	StringCalculator stringCalculator;
	
	@BeforeEach
	public void init() {
		stringCalculator = new StringCalculator();
	}
	
	@Test
	@DisplayName("eleventh Step - more than one  delimiter")
	void testAdd() {
		assertAll(
				()-> assertEquals(0,stringCalculator.Add(""),"test case 1 failed"),
				()-> assertEquals(1,stringCalculator.Add("1"),"test case 2 failed"),
				()-> assertEquals(3,stringCalculator.Add("1,2"),"test case 3 failed"),
				()-> assertEquals(10,stringCalculator.Add("1,2,3,4,,"),"test case 4 failed"),
				()-> assertEquals(6,stringCalculator.Add("//.\n1.2.3.."),"test case 5 failed"),
//				()-> assertEquals(6,stringCalculator.Add("//.\n1.-2.3.-5.")),
				()-> assertEquals(10,stringCalculator.Add("//*\n1*2*3*4*1001*1111"),"test case 6 failed"),
				()-> assertEquals(10,stringCalculator.Add("//[**]\n1**2**3**4**1001**1111"),"test case 7 failed"),
				()-> assertEquals(10,stringCalculator.Add("//[*][-]\n1*2*3*4*1001-1111"),"test case 8 failed")
			 );
	}
}
