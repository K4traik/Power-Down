package entity;

import interfaces.Actionable;

public class Vacuum extends Appliance implements Actionable{
	public Vacuum(boolean active, int facing) {
		super(active, facing);
	}
	@Override
	public void act() {
		
	}
}