package entity;

import interfaces.Actionable;

public class Laptop extends Appliance implements Actionable{
	public Laptop(boolean active, int facing) {
		super(active, facing);
	}
	@Override
	public void act() {
		
	}
}
