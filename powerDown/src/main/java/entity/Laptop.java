package entity;

import interfaces.Actionable;
import levelmanager.LevelManager;

public class Laptop extends Appliance implements Actionable{
	public Laptop(boolean active, int facing, LevelManager lM) {
		super(active, facing, lM);
	}
	@Override
	public void act() {
		
	}
}
