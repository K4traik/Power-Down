package entity;

import interfaces.Actionable;
import levelmanager.LevelManager;

public class Toaster extends Appliance implements Actionable{
	public Toaster(boolean active, int facing, LevelManager lM) {
		super(active, facing, lM);
	}
	@Override
	public void act() {
		
	}
}
