package entity;

import java.util.ArrayList;

import components.Position;
import interfaces.Actionable;
import map.Level;

public class Fan extends Appliance implements Actionable{
	private ArrayList<Position> view;
	private Position pushLimit;
	
	public Fan(boolean active, int facing, Position position) {
		super(active, facing, position);
		setView(new ArrayList<Position>());
	}
	@Override
	public void act(Level level, Human player) {
		if(getView() == null || getView().isEmpty()) {
			buildView(level);
		}
		checkPlayerOnFrontColumns(player);
	}
	public void pushPlayer(Human player) {
		player.move(getPushLimit());
	}
	public void buildView(Level level) {
		int yLimit = position.getY();
		int xLimit = position.getX();
		for(Position p:level.getMap().getPositions()) {
			if(facing == 1) { //abajo
				if(p.getX() == position.getX() && p.getY() > position.getY()) {
					getView().add(p);
					if(p.getY() > yLimit) {
						yLimit = p.getY();
					}
				}
				setPushLimit(new Position(position.getX(), yLimit));
			}else if(facing == 2) { //izquierda
				if(p.getX() < position.getX() && p.getY() == position.getY()) {
					getView().add(p);
					if(p.getX() < xLimit) {
						xLimit = p.getX();
					}
				}
				setPushLimit(new Position(xLimit, position.getY()));
			}else if(facing == 3) { //arriba
				if(p.getX() == position.getX() && p.getY() < position.getY()) {
					getView().add(p);
					if(p.getY() < yLimit) {
						yLimit = p.getY();
					}
				}
				setPushLimit(new Position(position.getX(), yLimit));
			}else if(facing == 4) { //derecha
				if(p.getX() > position.getX() && p.getY() == position.getY()) {
					getView().add(p);
					if(p.getX() > xLimit) {
						xLimit = p.getX();
					}
				}
				setPushLimit(new Position(xLimit, position.getY()));
			}
		}
	}
	public void checkPlayerOnFrontColumns(Human player) {
		for(Position p:getView()) {
			if(p.comparePosition(player.getPosition())) {
				pushPlayer(player);
			}
		}
	}
	public ArrayList<Position> getView() {
		return view;
	}
	public void setView(ArrayList<Position> view) {
		this.view = view;
	}
	public Position getPushLimit() {
		return pushLimit;
	}
	public void setPushLimit(Position pushLimit) {
		this.pushLimit = pushLimit;
	}
}
