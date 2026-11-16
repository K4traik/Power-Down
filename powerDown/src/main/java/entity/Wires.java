package entity;

import components.Position;

public class Wires extends Entity{
	private Appliance appliance;
	private int variation;
	private int facing;
	
	public Wires(Position position, Appliance appliance, int variation, int facing) {
		super(position);
        setAppliance(appliance);
        setVariation(variation);
        setFacing(facing);
        
    }
	
	public void steppedOn() {
		getAppliance().explode();
	}
	public Appliance getAppliance() {
		return appliance;
	}
	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}
	public int getVariation() {
		return variation;
	}
	public void setVariation(int variation) {
		this.variation = variation;
	}
	public int getFacing() {
		return facing;
	}
	public void setFacing(int facing) {
		this.facing = facing;
	}
}