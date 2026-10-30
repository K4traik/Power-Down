package entity;

import components.Position;
import levelmanager.LevelManager;

public abstract class Appliance extends Entity{
	protected boolean active;
	protected int facing;
	protected LevelManager lM; //el levelManager en el que existen
	
	public Appliance (int x, int y, boolean active, int facing, LevelManager lM) {
		super(x, y); 
		this.active=active;
		this.facing=facing;
		this.lM = lM;
	}
	
	public Appliance(boolean active, int facing, LevelManager lM, Position position) {
        super(position); 
        this.active = active;
        this.facing = facing;
        this.lM = lM;
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