package entity;

import components.Position;

public abstract class Entity {
	protected Position position;
	
	public void move (Position position) {
		this.position = position;
	}
	public Position getPosition() {
		return position;
	}
}
