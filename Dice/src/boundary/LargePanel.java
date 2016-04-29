package boundary;

/**
 * The BattlePhase class demonstates a phase of a match, where the rollWinner
 * causes damage to the rollLoser.
 * 
 * @author Thien Duc Phung
 * @author Minh Loi
 * @author Daniel Enriquez
 * @author Brett Bauman
 * @author Tanner Siffren
 */

public class LargePanel extends GameObject {

	public static final int WIDTH = 468;
	public static final int HEIGHT = 346;
	
	public LargePanel(int positionX, int positionY){
		setPosition(positionX, positionY);
		setImageByPath("/big_panel.png");
	}
	
	
}
