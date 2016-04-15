package control;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import entity.Database;

/**
 * Junit test of ViewRankState class
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class ViewRankStateTest {

	@Test
	public void testViewRankState() {
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		
		// Test if a ViewRankState object is created
		ViewRankState viewRank = new ViewRankState(controller, scanner, database);
		assertNotNull(viewRank);
		
	}
	
	@Test
	public void testPrint() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String selectedOption = "" + ViewRankState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		
		ViewRankState viewRank = new ViewRankState(controller, scanner, database);
		viewRank.print();
		
		// Test if ranks are printed.
		assertNotEquals("", outContent.toString());
		
	}
	
	@Test
	public void testInvalidInput() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		// Mock inputs
		String selectedOption = "-1" + "\n"+ ViewRankState.EXIT;
		System.setIn(new ByteArrayInputStream(selectedOption.getBytes()));
		
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		
		ViewRankState viewRank = new ViewRankState(controller, scanner, database);
		viewRank.print();
		
		// Menu is printing
		assertNotEquals("", outContent.toString());

		// Exactly two inputs are scanned because the first one is invalid.
		assertFalse(scanner.hasNext());
	
	}
	
	

}
