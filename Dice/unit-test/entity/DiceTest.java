package entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Junit test of Dice class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class DiceTest {

	@Test
	public void testDice() {
		
		// Test if a Dice object is created
		Dice dice = new Dice();
		assertNotNull(dice);
	}

	@Test
	public void testRoll() {
		
		Dice dice = new Dice();
		int number = dice.roll();
		
		// Test if a random number falls within the range.
		assertTrue(number >= 1 && number <= 6);
		
	}
	
	@Test
	public void testGetCurrent(){
		
		Dice dice = new Dice();
		dice.roll();
		
		int number = dice.getCurrent();
		
		// Test if a random number falls within the range.
		assertTrue(number >= 1 && number <= 6);
				
	}

}
