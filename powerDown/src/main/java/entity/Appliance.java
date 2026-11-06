package entity;

import components.Position;

public abstract class Appliance extends Entity{
	protected boolean active;
	protected int facing;
	
	public Appliance(boolean active, int facing, Position position) {
		super(position);
        this.active = active;
        this.facing = facing;
    }
	
	public void logicMoved() {
		
	}
	
	public void leaveWires() {	
		
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void turnOff() {
		this.active = false;
	}
	
	public int getFacing() {
		return facing;
	}
	
	public void setFacing(int facing) {
		this.facing = facing;
	}
}