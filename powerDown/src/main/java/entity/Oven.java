package entity;

import java.util.ArrayList;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Oven extends Appliance implements Actionable{
	private ArrayList<Position> view;
	
	public Oven(boolean active, int facing, Position position) {
		super(active, facing, position);
		setView(new ArrayList<Position>());
	}
	@Override
	public void act(Level level, Human player) {
		if(getView() == null || getView().isEmpty()) {
			buildView(level);
		}
		fire(player);
	}
	public void fire(Human player) {
		for(Position p:view) {
			if(p.comparePosition(player.getPosition())) {
				player.damaged();
			}
		}
	}
	public void buildView(Level level) {
		if(facing == 1) { //abajo
			getView().add(new Position(position.getX()-1, position.getY()+1));
			getView().add(new Position(position.getX(), position.getY()+1));
			getView().add(new Position(position.getX()+1, position.getY()+1));
		}else if(facing == 2) { //izquierda
			getView().add(new Position(position.getX()-1, position.getY()+1));
			getView().add(new Position(position.getX()-1, position.getY()));
			getView().add(new Position(position.getX()-1, position.getY()-1));
		}else if(facing == 3) { //arriba
			getView().add(new Position(position.getX()-1, position.getY()-1));
			getView().add(new Position(position.getX(), position.getY()-1));
			getView().add(new Position(position.getX()+1, position.getY()-1));
		}else if(facing == 4) { //derecha
			getView().add(new Position(position.getX()+1, position.getY()+1));
			getView().add(new Position(position.getX()+1, position.getY()));
			getView().add(new Position(position.getX()+1, position.getY()-1));
		}
	}
	public ArrayList<Position> getView() {
		return view;
	}
	public void setView(ArrayList<Position> view) {
		this.view = view;
	}
}
