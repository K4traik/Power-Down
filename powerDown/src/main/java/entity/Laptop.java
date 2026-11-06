package entity;

import components.Position;
import interfaces.Actionable;

public class Laptop extends Appliance implements Actionable{
	public Laptop(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	@Override
	public void act() {
		
	}
}
