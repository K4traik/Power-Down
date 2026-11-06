package entity;

import components.Position;

public class Wires extends Entity{
	private Appliance appliance;
	
	public Wires(int x, int y, Appliance appliance) {
		super(x,y);
		this.appliance = appliance;
	}
	
	public Wires(Position position, Appliance appliance) {
        super(position); 
        this.appliance = appliance;
    }
	
	public void steppedOn() {
		getAppliance().turnOff();
	}
	
	public Appliance getAppliance() {
		return appliance;
	}
	
	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}
	
}