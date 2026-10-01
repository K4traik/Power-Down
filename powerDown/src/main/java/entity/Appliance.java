package entity;

import levelmanager.LevelManager;

public abstract class Appliance extends Entity{
	protected boolean active;
	protected int facing;
	protected LevelManager lM; //el levelManager en el que existen
	
	public Appliance (boolean active, int facing, LevelManager lM) {
		this.setActive(active);
		this.setFacing(facing);
		this.lM = lM;
	}
	
	public void logicMoved() {
		
	}
	public void leaveWires() {	
		
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