package entity;

public class Wires extends Entity{
	private Appliance appliance;
	
	public Wires(Appliance appliance) {
		setAppliance(appliance);
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