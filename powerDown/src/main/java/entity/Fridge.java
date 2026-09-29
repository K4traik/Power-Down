package entity;

import interfaces.Actionable;

public class Fridge extends Appliance implements Actionable{
	public Fridge(boolean active, int facing) {
		super(active, facing);
	}
	@Override
	public void act() {
		
	}
}
