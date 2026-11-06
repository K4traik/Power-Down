package entity;

import components.Position;
import interfaces.Actionable;

public class Fridge extends Appliance implements Actionable{
	public Fridge(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	
	@Override
	public void act() {
		
	}
}
