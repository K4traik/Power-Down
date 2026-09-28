package entity;

import components.Position;

public abstract class Entity {
	protected Position position;
	
	public void move (Position p) {
		this.position=p;
	}
}
