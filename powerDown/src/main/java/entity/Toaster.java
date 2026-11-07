package entity;

import java.util.ArrayList;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Toaster extends Appliance implements Actionable{
	private boolean targeting;
	private ArrayList<Position> view;
	
	public Toaster(boolean active, int facing, Position position) {
		super(active, facing, position);
		setTargeting(false);
		setView(new ArrayList<Position>());
	}
	@Override
	public void act(Level level, Human player) {
		if(view == null || view.isEmpty()) {
			buildView(level);
		}
		if(isTargeting()) {
			shoot(player);
			setTargeting(false);
		}else {
			checkPlayerOnFrontColumns(player);
		}
	}
	public void shoot(Human player) {
		for(Position p:view) {
			if(p.comparePosition(player.getPosition())) {
				player.damaged();
			}
		}
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
				if(p.getX() == position.getX() && p.getY() < position.getY()) {
					view.add(p);
				}
			}else if(facing == 4) { //derecha
				if(p.getX() > position.getX() && p.getY() == position.getY()) {
					view.add(p);
				}
			}
		}
	}
	public void checkPlayerOnFrontColumns(Human player) {
		for(Position p:view) {
			if(p.comparePosition(player.getPosition())) {
				setTargeting(true);
			}
		}
	}
	public boolean isTargeting() {
		return targeting;
	}
	public void setTargeting(boolean targeting) {
		this.targeting = targeting;
	}
	public ArrayList<Position> getView() {
		return view;
	}
	public void setView(ArrayList<Position> view) {
		this.view = view;
	}
}
