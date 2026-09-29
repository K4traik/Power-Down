package model;

public class SessionProgression {
	public int id;
    private int currentLevel;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id=id;
    }
    
    public int getCurrentLevel() {
        return currentLevel;
    }
    
    public void setCurrentLevel(int CurrentLevel) {
        this.currentLevel=CurrentLevel;
    }
    
	public void save(SessionProgression s) {
	}

	public void racharge(SessionProgression s) {
	}

	public void delete(SessionProgression s) {
	}

	public SessionProgression[] getall() {
		// TODO Auto-generated method stub
		return null;
	}
}
