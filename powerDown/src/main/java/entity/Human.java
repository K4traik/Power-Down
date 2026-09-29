package entity;

import components.Position;

public class Human extends Entity{
	private int health;
	
	public Human(int health) {
		this.setHealth(health);
	}
	
	public void damaged() {
		health--;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void walkNorth() {
		move(new Position(getPosition().x, getPosition().y++));
	}
	public void walkSouth() {
		move(new Position(getPosition().x, getPosition().y--));
	}
	public void walkEast() {
		move(new Position(getPosition().x++, getPosition().y));
	}
	public void walkWest() {
		move(new Position(getPosition().x--, getPosition().y));
	}
}
