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
		// para electrodomesticos q se muevan
	}
	public void leaveWires() {	
		// lo mismo que arriba
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	public void explode() {
		this.active = false;
	}
	public int getFacing() {
		return facing;
	}
	public void setFacing(int facing) {
		this.facing = facing;
	}
}