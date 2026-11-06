package levelmanager;

import entity.Appliance;
import entity.Human;
import entity.Wires;
import exceptions.IdOutOfBoundsException;
import exceptions.InactiveSessionException;
import exceptions.InvalidInputException;
import exceptions.InvalidPositionException;
import exceptions.SessionNotFoundException;
import interfaces.Actionable;
import map.Levels;
import map.Level;
import service.SessionProgressionService;

import java.util.Scanner;

import components.Position;

public class LevelManager{
	private int currentLevel;
	private Human player;
	private Level level;
	private int turn;
	private SessionProgressionService sessionsDB;
	
	public LevelManager() {
		sessionsDB = new SessionProgressionService();
		sessionsDB.initializeSaves();
		updateCurrentLevel(1);
	}
	
	public void start() {
		player = new Human(new Position(0, 0), 5);
		updateLevel();
		turn = 0;
	}
	
	public void nextTurn(int input) throws InvalidInputException, InvalidPositionException{
		playerAct(input);
		turn++;
	}
	
	public void nextLevel() {
		if(currentLevel<3) {
			currentLevel++;
			start();
		}else {
			System.out.println("Juego completado!");
		}
	}
	public void playerAct(int input) throws InvalidInputException, InvalidPositionException {
		Position nextPos;
		switch(input) {
		case 1:
			nextPos = player.walkNorth();
			break;
		case 2:
			nextPos = player.walkEast();
			break;
		case 3:
			nextPos = player.walkSouth();
			break;
		case 4:
			nextPos = player.walkWest();
			break;
		default:
			throw new InvalidInputException("El valor ingresado no corresponde a ninguna dirección.");
		}
		if (checkPositionMap(nextPos)) {
			throw new InvalidPositionException("El jugador intentó moverse a una pared.");
		} 
		Wires wire = checkPositionWires(nextPos);
		if (wire != null) {
			wire.steppedOn();
		} 
		if (checkPositionAppliances(nextPos)) {
			throw new InvalidPositionException("El jugador intentó moverse a un electrodoméstico.");
		}
		player.move(nextPos);
	}
	public void appliancesAct() {
		for(Appliance a:level.getAppliances()	) {
			if(a instanceof Actionable) {
				((Actionable) a).act();
			}
		}
	}
	
	public boolean checkPositionMap(Position p) {
		boolean flag = false;
		for(Position np:level.getMap().getPositions()) {
			if(np == p) {
				flag = true;
			}
		}
		return flag;
	}
	
	public Wires checkPositionWires(Position p) {
		for(Wires w:level.getWires()) {
			if(w.getPosition() == p) {
				return w;
			}
		}
		return null;
	}
	
	public boolean checkPositionAppliances(Position p) {
		boolean flag = false;
		for(Appliance a:level.getAppliances()) {
			if(a.getPosition() == p) {
				flag = true;
			}
		}
		return flag;
	}
	public void updateCurrentLevel(int choosenSave) {
		try {
			setCurrentLevel(sessionsDB.getSession(1).getCurrentLevel());
		}catch(IdOutOfBoundsException ex) {
			ex.printStackTrace();
		}catch(SessionNotFoundException ex) {
			ex.printStackTrace();
		}catch(InactiveSessionException ex) {
			ex.printStackTrace();
		}
	}
	public void updateLevel() {
		setLevel(Levels.getLevel(currentLevel));
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public Human getPlayer() {
		return player;
	}
	
	public void setPlayer(Human player) {
		this.player = player;
	}
	public int getTurn() {
		return turn;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
