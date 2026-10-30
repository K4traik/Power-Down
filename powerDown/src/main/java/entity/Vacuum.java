package entity;

import components.Position;
import interfaces.Actionable;
import levelmanager.LevelManager;

public class Vacuum extends Appliance implements Actionable{
	public Vacuum(boolean active, int facing, LevelManager lM, Position position) {
		super(active, facing, lM, position);
	}
	@Override
	public void act() {
		
	}
}