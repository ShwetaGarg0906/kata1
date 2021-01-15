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
	@DisplayName("seventh Step - getCalledCount()")
	void testAdd() {
		assertAll(
				()-> assertEquals(0,stringCalculator.Add("")),
				()-> assertEquals(1,stringCalculator.Add("1")),
				()-> assertEquals(3,stringCalculator.Add("1,2")),
				()-> assertEquals(10,stringCalculator.Add("1,2,3,4,,")),
				()-> assertEquals(6,stringCalculator.Add("//.\n1.2.3..")),
				()-> assertEquals(6,stringCalculator.Add("//.\n1.-2.3.-5."))	
			 );
	}
}
