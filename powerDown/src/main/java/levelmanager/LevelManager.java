package levelmanager;

import entity.Appliance;
import entity.Human;
import entity.Wires;
import exceptions.IdOutOfBoundsException;
import exceptions.InactiveSessionException;
import exceptions.SessionNotFoundException;
import interfaces.Actionable;
import map.Levels;
import map.Level;
import service.SessionProgressionService;

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
		player = new Human(new Position(0, 0), 1);
		updateLevel();
		turn = 0;
	}
	public boolean checkWin() {
		boolean flag = true;
		for(Appliance a:level.getAppliances()) {
			if(a.isActive()) {
				flag = false;
			}
		}
		return flag;
	}
	public boolean checkLose() {
		boolean flag = false;
		if(player.getHealth()<=0) {
			flag = true;
		}
		if(turn >= 100) {
			flag = true;
		}
		return flag;
	}
	public void nextTurn() {
		turn++;
		appliancesAct();
	}
	public void guardarNivelActual(int idSession) {
        try {
            sessionsDB.getSession(idSession).setCurrentLevel(this.currentLevel);
            System.out.println("Progreso guardado en la sesión " + idSession + " (Nivel " + this.currentLevel + ")");
        } catch (IdOutOfBoundsException | SessionNotFoundException | InactiveSessionException ex) {
            ex.printStackTrace();
        }
    }
	public void nextLevel() {
		if(currentLevel<3) {
			currentLevel++;
		}
	}
	public void playerAct(int input){
		if(!player.isFrozen()) {
			Position nextPos = null;
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
			}
			if(nextPos!=null) {
				if (!checkPositionMap(nextPos)) {
					System.out.println("muro");
					player.move(player.getPosition());
				}else if (checkPositionAppliances(nextPos)) {
					System.out.println("appliance");
					player.move(player.getPosition());
				}else {
					Wires wire = checkPositionWires(nextPos);
					if(wire != null) {
						if(wire.getAppliance().isActive()) {
							level.addExplosion(wire.getAppliance().getPosition());
							wire.steppedOn();
						}
					}
					player.move(nextPos);
					nextTurn();
				}
			}
		}else {
			nextTurn();
			player.setFrozen(false);
		}
	}
	public void appliancesAct() {
		for(Appliance a:level.getAppliances()	) {
			if(a.isActive()) {
				if(a instanceof Actionable) {
					((Actionable) a).act(level, player);
				}
			}
		}
	}
	
	public boolean checkPositionMap(Position p) {
		return level.getMap().isPositionAvailable(p);
	}
	
	public Wires checkPositionWires(Position p) {
		for(Wires w:level.getWires()) {
			if(w.getPosition().comparePosition(p)) {
				return w;
			}
		}
		return null;
	}
	
	public boolean checkPositionAppliances(Position p) {
		boolean flag = false;
		for(Appliance a:level.getAppliances()) {
			if(a.getPosition().comparePosition(p)) {
				flag = true;
			}
		}
		return flag;
	}
	public void updateCurrentLevel(int choosenSave) {
		try {
			setCurrentLevel(sessionsDB.getSession(choosenSave).getCurrentLevel());
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
