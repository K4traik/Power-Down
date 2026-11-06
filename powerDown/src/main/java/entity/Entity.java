package entity;

import components.Position;

public abstract class Entity{
	protected Position position;
	
	public Entity(Position position) {
		move(position);
	}
	
	public void move (Position position) {
		this.position = position;
	}
	public Position getPosition() {
		return position;
	}
}
