package entity;

public abstract class Appliance extends Entity{
	protected boolean active;
	protected int facing;
	
	public Appliance (boolean active, int facing) {
		this.active=active;
		this.facing=facing;
	}
	
	public void logicMoved() {
		
	}
	public void leaveWires() {	
		
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