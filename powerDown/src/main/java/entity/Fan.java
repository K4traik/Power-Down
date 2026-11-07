package entity;

import java.util.ArrayList;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Fan extends Appliance implements Actionable{
	private ArrayList<Position> view;
	
	public Fan(boolean active, int facing, Position position) {
		super(active, facing, position);
	}
	@Override
	public void act(Level level, Human player) {
		
	}
	public void buildView(Level level) {
		for(Position p:level.getMap().getPositions()) {
			if(facing == 1) { //abajo
				if(p.getX() == position.getX() && p.getY() > position.getY()) {
					view.add(p);
				}
			}else if(facing == 2) { //izquierda
				if(p.getX() < position.getX() && p.getY() == position.getY()) {
					view.add(p);
				}
			}else if(facing == 3) { //arriba
				if(p.getX() == position.getX() && p.getY() > position.getY()) {
					view.add(p);
				}
			}else if(facing == 4) { //derecha
				if(p.getX() > position.getX() && p.getY() == position.getY()) {
					view.add(p);
				}
			}
		}
	}
}
