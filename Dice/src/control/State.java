package control;

import java.util.Scanner;

public abstract class State {

	protected Scanner scanner;

	public static final int MENU_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int VIEW_RANK_STATE = 2;
	public static final int MATCH_END_MENU_STATE = 3; // Menu displayed when a match ended
	
	public abstract void print();
	
	public Scanner getScanner(){
		return scanner;		
	}
	
}
