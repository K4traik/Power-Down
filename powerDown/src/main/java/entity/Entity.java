package entity;

import components.Position;

public abstract class Entity extends Position{
	
    public Entity() {
        super(0, 0); 
    }
    
    public Entity(int x, int y) {
        super(x, y);
    }
    
    public Entity(Position position) {
        super(position.getX(), position.getY()); 
    }
    
    public void move(Position position) {
        setX(position.getX());
        setY(position.getY());
    }
    
    public Position getPosition() {
        return new Position(getX(), getY());
    }   
}
