package entity;

import interfaces.Actionable;

public class Fan extends Appliance implements Actionable{
	public Fan(boolean active, int facing) {
		super(active, facing);
	}
	@Override
	public void act() {
		
	}
}
