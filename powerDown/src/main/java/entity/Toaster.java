package entity;

import interfaces.Actionable;

public class Toaster extends Appliance implements Actionable{
	public Toaster(boolean active, int facing) {
		super(active, facing);
	}
	@Override
	public void act() {
		
	}
}
