package levelmanager;

import entity.Human;
import entity.Wires;
import interfaces.Actionable;
import map.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelManager{
	private int currentLevel;
	private Map map;
	private Human player;
	private ArrayList<Wires> wires;
	private ArrayList<Actionable> actionables;
	private int turn;
	
	public LevelManager() {
		map = new Map();
	}
	
	public void start() {
		turn = 0;
		player.setHealth(5);
		while(turn<=100 && !actionables.isEmpty()) {
			nextTurn();
		}
		nextLevel();
	}
	public void nextTurn() {
		turn++;
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch(input) {
		case 1:
			player.walkNorth();
			break;
		case 2:
			player.walkEast();
			break;
		case 3:
			player.walkSouth();
			break;
		case 4:
			player.walkWest();
			break;
		}
	}
	public void nextLevel() {
		currentLevel++;
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
	public void setWires(ArrayList<Wires> wires) {
		this.wires = wires;
	}
	public ArrayList<Actionable> getActionables() {
		return actionables;
	}
	public void setActionables(ArrayList<Actionable> actionables) {
		this.actionables = actionables;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
}
