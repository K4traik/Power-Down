package entity;

import interfaces.Actionable;
import levelmanager.LevelManager;

public class Fridge extends Appliance implements Actionable{
	public Fridge(boolean active, int facing, LevelManager lM) {
		super(active, facing, lM);
	}
	@Override
	public void act() {
		
	}
}
