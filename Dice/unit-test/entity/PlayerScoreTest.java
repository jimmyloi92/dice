package entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Junit test of PlayerScore class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class PlayerScoreTest {

	@Test
	public void testPlayerScore() {
		// Test if a PlayerScore object is created sucessfully.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertNotNull(newPlayer);
	}

	@Test
	public void testGetUsername() {
		// Test if getUsername is correct.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals("guest", newPlayer.getUsername());
	}

	@Test
	public void testGetNumOfWins() {

		// Test if numOfWins is correct.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals(0, newPlayer.getNumOfWins());
	}

	@Test
	public void testGetNumOfLosses() {

		// Test if numOfLoss is correct.
		PlayerScore newPlayer = new PlayerScore("guest");
		assertEquals(0, newPlayer.getNumOfLosses());
	}

	@Test
	public void testGetDifference() {
		
		// Test if difference is calculated correctly.
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementWins();
		newPlayer.incrementWins();
		newPlayer.incrementLosses();
		assertEquals(1, newPlayer.getDifference());
	}

	@Test
	public void testIncrementWins() {
		
		// Test if numOfWins is incremented
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementWins();
		assertEquals(1, newPlayer.getNumOfWins());
	}

	@Test
	public void testIncrementLosses() {

		// Test if numOfLosses is incremented
		PlayerScore newPlayer = new PlayerScore("guest");
		newPlayer.incrementLosses();
		assertEquals(1, newPlayer.getNumOfLosses());
	}

}
