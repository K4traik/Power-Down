package entity;

import components.Position;

public class Human extends Entity{
	private int health;
	private boolean frozen;
	
	public Human(Position position, int health) {
		super(position);
        this.health = health;
        setFrozen(false);
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
	
	public Position walkNorth() {
		Position p = getPosition();
		Position np = new Position(p.getX(), p.getY()-1);
		return np;
	}
	public Position walkSouth() {
		Position p = getPosition();
		Position np = new Position(p.getX(), p.getY()+1);
		return np;
	}
	public Position walkEast() {
		Position p = getPosition();
		Position np = new Position(p.getX()+1, p.getY());
		return np;
	}
	public Position walkWest() {
		Position p = getPosition();
		Position np = new Position(p.getX()-1, p.getY());
		return np;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
}
