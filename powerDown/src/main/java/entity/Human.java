package entity;

import components.Position;

public class Human extends Entity{
	private int health;
	
	public Human(Position position, int health) {
		super(position);
        this.health = health;
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
}
