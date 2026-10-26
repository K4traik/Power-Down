package entity;

import components.Position;
import interfaces.Actionable;
import levelmanager.LevelManager;

public class Fan extends Appliance implements Actionable{
	
	public Fan(boolean active, int facing, LevelManager lM, Position position) {
		super(active, facing, lM, position);
	}
	
	@Override
	public void act() {
		
	}
}
