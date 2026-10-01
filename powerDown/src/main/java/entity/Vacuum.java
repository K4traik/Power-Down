package entity;

import interfaces.Actionable;
import levelmanager.LevelManager;

public class Vacuum extends Appliance implements Actionable{
	public Vacuum(boolean active, int facing, LevelManager lM) {
		super(active, facing, lM);
	}
	@Override
	public void act() {
		
	}
}