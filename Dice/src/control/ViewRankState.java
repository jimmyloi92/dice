package control;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import entity.Database;
import entity.PlayerScore;

/**
 * ViewRankState -  Allows the user to view their ranking as well as the other players
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */
public class ViewRankState extends State{
	
	private GameController gameController;
	private Database database;
	
	private String[] menuList; 
	private int menuLength;
	
	public static final int BACK_TO_MAIN_MENU = 0;
	public static final int EXIT = 1;
	
	/**
	 * Constructor - Prepare ranking menu, initialize controller, scanner and database
	 * 				objects 
	 * 
	 * @param controller
	 * @param scanner
	 * @param database
	 */
	public ViewRankState(GameController controller, Database database){
		
		this.gameController = controller;
		this.database = database;
		
		menuLength = 2;
		menuList = new String[menuLength];
		menuList[BACK_TO_MAIN_MENU] = "Back to main menu";
		menuList[EXIT] = "Exit";
		
	}
	
	/**
	 * print - Display each of the player's rankings (wins and losses)
	 */
	public void print(){

		// Sort data by difference of wins and losses.
		database.sortByDifference();
		Vector<PlayerScore> data = database.getData();
		
		int size = data.size();
		
		if(size > 0){
		
			Iterator<PlayerScore> iterator =  data.iterator();
			System.out.println("Viewing ranks of players in order of DIFF.");
			
			System.out.printf("%-25s%-10s%-10s%-10s\n", "Username", "Wins", "Losses", "DIFF");
			System.out.println("-----------------------------------------------------------------------------");
			
			while(iterator.hasNext()){
				PlayerScore player = iterator.next();
				int numOfWins = player.getNumOfWins();
				int numOfLosses = player.getNumOfLosses();
				int diff = numOfWins - numOfLosses;
				System.out.printf("%-25s%-10s%-10s%-10s\n", player.getUsername(), numOfWins, numOfLosses, diff);
				
			}
			
		} else {
			System.out.println("No records in database.");
		}
				
		System.out.println();
		printMenu();
	
	}
	
	/**
	 * printMenu - Print all menu options.
	 */
	private void printMenu(){
	
	
					
	}
	
	/**
	 * route - Route user input to main menu or exit
	 * 
	 * @param selectedOption
	 */
	private void route(int selectedOption){
		
		switch (selectedOption){
		
			case BACK_TO_MAIN_MENU:
				// Begin to render menuState.
				try {
					gameController.setState(State.MENU_STATE);
					gameController.renderCurrentState();
					break;					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			case EXIT:
				gameController.exitGame();
				break;
				
			default:
				System.out.println("Invalid Input. Please try again.");
				print();
				break;
		}
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}
}