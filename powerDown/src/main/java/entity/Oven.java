package entity;

import interfaces.Actionable;

public class Oven extends Appliance implements Actionable{
	public Oven(boolean active, int facing) {
		super(active, facing);
	}
	@Override
	public void act() {
		
	}
}
