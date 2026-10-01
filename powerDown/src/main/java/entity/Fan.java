package entity;

import interfaces.Actionable;
import levelmanager.LevelManager;

public class Fan extends Appliance implements Actionable{
	public Fan(boolean active, int facing, LevelManager lM) {
		super(active, facing, lM);
	}
	@Override
	public void act() {
		
	}
}
