package entity;

import components.Position;
import interfaces.Actionable;

public class Toaster extends Appliance implements Actionable{
	public Toaster(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	@Override
	public void act() {
		
	}
}
