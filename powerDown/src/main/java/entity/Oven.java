package entity;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Oven extends Appliance implements Actionable{
	public Oven(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	@Override
	public void act(Level level, Human player) {
		
	}
}
