package control;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import boundary.GameObject;
import boundary.PlayerObject;
import entity.Player;

public class Turn implements Listenable {
	
	private Player player1;
	private Player player2;
	
	private PlayerObject player1Object;
	private PlayerObject player2Object;
	private ArrayList<GameObject> objectList;
	private Phase phaseList[];
	private int currentPhase;
	private boolean turnCompleted;
	
	public Turn(Player player1, Player player2, ArrayList<GameObject> objectList){
		
		this.player1 = player1;
		this.player2 = player2;
		this.objectList = objectList;
		
		try {
			this.player1Object = new PlayerObject(1);
			this.player2Object = new PlayerObject(2);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		phaseList = new Phase[Phase.LENGTH];
		phaseList[Phase.SELECT_MOVE_PHASE] = new SelectMovePhase(player1, player2, player1Object, player2Object, objectList);
		phaseList[Phase.ROLL_DICE_PHASE] = new RollDicePhase(player1, player2, player1Object, player2Object, objectList);
		phaseList[Phase.BATTLE_PHASE] = new BattlePhase(player1, player2, player1Object, player2Object, objectList);
		
		// The initial phase is SelectMovePhase.
		this.currentPhase = Phase.SELECT_MOVE_PHASE;
		this.turnCompleted = false;
		
	}
	
	public void render(){
	
		if(phaseList[currentPhase].isCompleted()){
			if(hasNextPhase()){
				renderNextPhase();
			} else {
				setTurnCompleted();
			}
		} else {
			phaseList[currentPhase].render();
		}
		
	}
		
	private boolean hasNextPhase(){
		boolean hasNext;
		if(currentPhase >= Phase.LENGTH - 1){
			hasNext = false; 
		} else {
			hasNext = true;
		}
		return hasNext;
	}
	
	private void renderNextPhase(){
		if(hasNextPhase() == true){
			++currentPhase;
			phaseList[currentPhase].render();
		}
	}
	
	public boolean isTurnCompleted(){
		return turnCompleted;
	}
	private void setTurnCompleted(){
		turnCompleted = true;
	}
	
	@Override
	public void onKeyPressed(KeyEvent keyEvent) {
	
	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent) {
		phaseList[currentPhase].onKeyReleased(keyEvent);
	}

	@Override
	public void onKeyTyped(KeyEvent keyEvent) {
		
	}
	
}
