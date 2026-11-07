package entity;

import java.util.ArrayList;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Fridge extends Appliance implements Actionable{
	private int stage;
	private ArrayList<Position> view;
	
	public Fridge(boolean active, int facing, Position position) {
		super(active, facing, position);
		setStage(0);
		setView(new ArrayList<Position>());
	}
	@Override
	public void act(Level level, Human player) {
		if(getView() == null || getView().isEmpty()) {
			buildView(level);
		}
		if(stage<2) {
			stage++;
		}else {
			stage = 0;
			froze(player);
		}
	}
	public void froze(Human player) {
		for(Position p:view) {
			if(p.comparePosition(player.getPosition())) {
				player.setFrozen(true);
			}
		}
	}
	public void buildView(Level level) {
		if(facing == 1) { //abajo
			view.add(new Position(position.getX()-1, position.getY()+1));
			view.add(new Position(position.getX(), position.getY()+1));
			view.add(new Position(position.getX()+1, position.getY()+1));
		}else if(facing == 2) { //izquierda
			view.add(new Position(position.getX()-1, position.getY()+1));
			view.add(new Position(position.getX()-1, position.getY()));
			view.add(new Position(position.getX()-1, position.getY()-1));
		}else if(facing == 3) { //arriba
			view.add(new Position(position.getX()-1, position.getY()-1));
			view.add(new Position(position.getX(), position.getY()-1));
			view.add(new Position(position.getX()+1, position.getY()-1));
		}else if(facing == 4) { //derecha
			view.add(new Position(position.getX()+1, position.getY()+1));
			view.add(new Position(position.getX()+1, position.getY()));
			view.add(new Position(position.getX()+1, position.getY()-1));
		}
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public ArrayList<Position> getView() {
		return view;
	}
	public void setView(ArrayList<Position> view) {
		this.view = view;
	}
}
