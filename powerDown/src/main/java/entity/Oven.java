package entity;

import components.Position;
import interfaces.Actionable;
import levelmanager.LevelManager;

public class Oven extends Appliance implements Actionable{
	public Oven(boolean active, int facing, LevelManager lM, Position position) {
		super(active, facing, lM, position);
	}
	@Override
	public void act() {
		
	}
}
