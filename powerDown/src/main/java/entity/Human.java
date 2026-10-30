package entity;

import components.Position;

public class Human extends Entity{
	private int health;
	
	public Human(int x, int y, int health) {
        super(x, y); 
        this.health = health;
    }

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
		p.y = p.y + 1;
		return p;
	}
	public Position walkSouth() {
		Position p = getPosition();
		p.y = p.y - 1;
		return p;
	}
	public Position walkEast() {
		Position p = getPosition();
		p.x = p.x + 1;
		return p;
	}
	public Position walkWest() {
		Position p = getPosition();
		p.x = p.x - 1;
		move(p);
		return p;
	}
}
