package interfaces;

import entity.Human;
import map.Level;

public interface Actionable {
	void act(Level level ,Human player);
}
