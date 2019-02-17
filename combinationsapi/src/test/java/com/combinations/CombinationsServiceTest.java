package com.combinations;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.combinations.service.CombinationsService;

@RunWith(MockitoJUnitRunner.class)
public class CombinationsServiceTest {

	String inputValue="1234567890";
	@InjectMocks
	CombinationsService combinationsService;
	@Test
	public void isInputNull() {
		assertNotEquals("Input is empty or null ",false, combinationsService.validateNull(inputValue));
	}
	@Test
	public void isInputHavingCharacter() {
		assertNotEquals("Input is not a number!!! ",false, combinationsService.validateNumber(inputValue));		
	}
	
	@Test
	public void isInputHavingOtherThan7or10characters() {
		assertNotEquals("Input is neither 7 digit nor 10 digit ",false, combinationsService.validateNumberLegnth(inputValue));		
	}
	@Test
	public void isOutputJson() {
		assertNotEquals("Result is not a json", null, combinationsService.letterCombinations(inputValue));		
	}
}
