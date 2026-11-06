package entity;

import components.Position;
import interfaces.Actionable;

public class Fan extends Appliance implements Actionable{
	
	public Fan(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	
	@Override
	public void act() {
		
	}
}
