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
	@DisplayName("Adds upto three numbers")
	void testAdd() {
		assertAll(
				()-> assertEquals(0,stringCalculator.Add("")),
				()-> assertEquals(1,stringCalculator.Add("1")),
				()-> assertEquals(3,stringCalculator.Add("1,2"))
			 );
	}

}
