package entity;

import interfaces.Actionable;
import levelmanager.LevelManager;

public class Oven extends Appliance implements Actionable{
	public Oven(boolean active, int facing, LevelManager lM) {
		super(active, facing, lM);
	}
	@Override
	public void act() {
		
	}
}
