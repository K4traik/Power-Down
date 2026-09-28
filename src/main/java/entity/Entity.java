package entity;

public abstract class Entity {
	protected Position position;
	
	public void move (Position p) {
		this.position=p;
	}
}
