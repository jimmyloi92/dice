package control;

import java.awt.event.KeyEvent;

public interface Listenable {
	public void onKeyPressed(KeyEvent keyEvent);
	public void onKeyReleased(KeyEvent keyEvent);
	public void onKeyTyped(KeyEvent keyEvent);
}