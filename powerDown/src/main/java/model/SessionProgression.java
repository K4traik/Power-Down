package model;

public class SessionProgression {
	private int id;
	private int currentLevel;
	private boolean active;
	
	public SessionProgression(int id, int currentLevel) {
		this.setId(id);
		this.setCurrentLevel(currentLevel);
		this.setActive(true);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
