package map;

import java.util.ArrayList;

import components.Position;
import entity.Appliance;
import entity.Wires;

public class Level {
	private Map map;
	private ArrayList<Wires> wires;
	private ArrayList<Appliance> appliances;
	private ArrayList<Position> explosions;
	
	public Level(Map map, ArrayList<Wires> wires, ArrayList<Appliance> appliances, ArrayList<Position> explosions) {
		setMap(map);
		setWires(wires);
		setAppliances(appliances);
		setExplosions(explosions);
	}
	
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public ArrayList<Wires> getWires() {
		return wires;
	}
	public void setWires(ArrayList<Wires> wires) {
		this.wires = wires;
	}
	public void addWires(Wires wires) {
		this.wires.add(wires);
	}
	public ArrayList<Appliance> getAppliances() {
		return appliances;
	}
	public void setAppliances(ArrayList<Appliance> appliances) {
		this.appliances = appliances;
	}
	public void addAppliance(Appliance appliance) {
		appliances.add(appliance);
	}
	public ArrayList<Position> getExplosions() {
		return explosions;
	}
	public void setExplosions(ArrayList<Position> explosions) {
		this.explosions = explosions;
	}
	public void addExplosion(Position e) {
		explosions.add(e);
	}
}
