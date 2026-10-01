package levelmanager;

import entity.Appliance;
import entity.Human;
import entity.Wires;
import exceptions.InvalidInputException;
import exceptions.InvalidPositionException;
import interfaces.Actionable;
import map.Map;
import java.util.ArrayList;
import java.util.Scanner;

import components.Position;

public class LevelManager{
	private int currentLevel;
	private Map map;
	private Human player;
	private ArrayList<Wires> wires;
	private ArrayList<Appliance> appliances;
	private int turn;
	
	public LevelManager() {
		map = new Map();
	}
	
	public void start() {
		turn = 0;
		player.setHealth(5);
		while(turn<=100 && !appliances.isEmpty() && player.getHealth()>0) {
			nextTurn();
		}
		if(player.getHealth()==0) {
			start();
		}else {
			nextLevel();
		}
	}
	public void nextTurn(){
		System.out.println("Elige una dirección para moverte: ");
		System.out.println("1. Norte.\n2. Este.\n3. Sur.\n4. Oeste.\n5. No moverse.");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		try {
			playerAct(input);
		}catch(InvalidInputException ex) {
			System.out.println(ex.getMessage());
		}catch(InvalidPositionException ex) {
			System.out.println(ex.getMessage());
		}
		appliancesAct();
		sc.close();
		turn++;
	}
	public void nextLevel() {
		if(currentLevel<5) {
			currentLevel++;
			start();
		}else {
			System.out.println("Juego completado!");
		}
	}
	public void playerAct(int input) throws InvalidInputException, InvalidPositionException{
		switch(input) {
		case 1:
			if(checkPositionMap(player.walkNorth())) {
				throw new InvalidPositionException("El jugador intentó moverse a una pared.");
			}
			if(checkPositionWires(player.walkNorth()) != null) {
				checkPositionWires(player.walkNorth()).steppedOn();
			}
			if(checkPositionAppliances(player.walkNorth())) {
				throw new InvalidPositionException("El jugador intentó moverse a un electrodómestico.");
			}
			break;
		case 2:
			if(checkPositionMap(player.walkEast())) {
				throw new InvalidPositionException("El jugador intentó moverse a una pared.");
			}
			if(checkPositionWires(player.walkEast()) != null) {
				checkPositionWires(player.walkEast()).steppedOn();
			}
			if(checkPositionAppliances(player.walkEast())) {
				throw new InvalidPositionException("El jugador intentó moverse a un electrodómestico.");
			}
			break;
		case 3:
			if(checkPositionMap(player.walkSouth())) {
				throw new InvalidPositionException("El jugador intentó moverse a una pared.");
			}
			if(checkPositionWires(player.walkSouth()) != null) {
				checkPositionWires(player.walkSouth()).steppedOn();
			}
			if(checkPositionAppliances(player.walkSouth())) {
				throw new InvalidPositionException("El jugador intentó moverse a un electrodómestico.");
			}
			break;
		case 4:
			if(checkPositionMap(player.walkWest())) {
				throw new InvalidPositionException("El jugador intentó moverse a una pared.");
			}
			if(checkPositionWires(player.walkWest()) != null) {
				checkPositionWires(player.walkWest()).steppedOn();
			}
			if(checkPositionAppliances(player.walkWest())) {
				throw new InvalidPositionException("El jugador intentó moverse a un electrodómestico.");
			}
			break;
		case 5:
			
			break;
		default:
			throw new InvalidInputException("El valor ingresado no corresponde a ninguna dirección.");
		}
	}
	public void appliancesAct() {
		for(Appliance a:appliances) {
			if(a instanceof Actionable) {
				((Actionable) a).act();
			}
		}
	}
	public boolean checkPositionMap(Position p) {
		boolean flag = false;
		for(Position np:map.getPositions()) {
			if(np == p) {
				flag = true;
			}
		}
		return flag;
	}
	public Wires checkPositionWires(Position p) {
		for(Wires w:wires) {
			if(w.getPosition() == p) {
				return w;
			}
		}
		return null;
	}
	public boolean checkPositionAppliances(Position p) {
		boolean flag = false;
		for(Appliance a:appliances) {
			if(a.getPosition() == p) {
				flag = true;
			}
		}
		return flag;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Human getPlayer() {
		return player;
	}
	public void setPlayer(Human player) {
		this.player = player;
	}
	public ArrayList<Wires> getWires() {
		return wires;
	}
	public void addWires(Wires w) {
		wires.add(w);
	}
	public ArrayList<Appliance> getAppliances() {
		return appliances;
	}
	public void addAppliances(Appliance a) {
		appliances.add(a);
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
}
