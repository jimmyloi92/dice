package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import boundary.Background;
import boundary.GameObject;
import boundary.RankingTable;
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
	private ArrayList<GameObject> objectList;
	private RankingTable rankingTable;
	private Background background;
	private int backState;
	
	/**
	 * Constructor - Prepare ranking menu, initialize controller, game objects and database
	 * 				
	 * @param controller
	 * @param scanner
	 * @param database
	 */
	public ViewRankState(GameController controller, ArrayList<GameObject> objectList, Database database){
		
		this.gameController = controller;
		this.database = database;
		this.objectList = objectList;
		this.background = new Background("ranking_background.png");
		
		this.backState = MENU_STATE;
	}
	
	/**
	 * render - Display each of the player's rankings (wins and losses)
	 */
	public void render(){

		objectList.add(background);
		
		rankingTable = new RankingTable();
				
		// Sort data by difference of wins and losses.
		database.sortByDifference();
		Vector<PlayerScore> data = database.getData();
		
		int size = data.size();
		
		if(size > 0){
		
			Iterator<PlayerScore> iterator =  data.iterator();
			
			rankingTable.drawHeader();
			int index = 0;
			while(iterator.hasNext() && index < 5){
				++index;
				
				PlayerScore player = iterator.next();
				int numOfWins = player.getNumOfWins();
				int numOfLosses = player.getNumOfLosses();
				int diff = numOfWins - numOfLosses;

				rankingTable.drawPlayerScore(index + ". " + player.getUsername(), numOfWins, numOfLosses, diff);
			}
			
		} else {
			rankingTable.drawNoRecords();
		}
		
		objectList.add(rankingTable);
	
	}
	
	/**
 	* setBackState sets the state of the previous state
	* 
	* @param state - The state to be set to the previous one
	**/
	public void setBackState(int state){
		backState = state;		
	}
	
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		int keycode = keyEvent.getKeyCode();
		if(keycode == KeyEvent.VK_ESCAPE){
			gameController.setState(backState);
		}

	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
	}
}
