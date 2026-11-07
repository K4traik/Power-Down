package entity;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Vacuum extends Appliance implements Actionable{
	public Vacuum(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	@Override
	public void act(Level level, Human player) {
		
	}
}