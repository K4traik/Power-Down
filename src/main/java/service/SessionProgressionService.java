package service;

import model.SessionProgression;

public class SessionProgressionService {
	
	private SessionProgression saveGame;

    public void saveGame(SessionProgression s) {
        this.saveGame = s;
    }

    public SessionProgression rachargeGame() {
        return this.saveGame;
    }

    public void deleteGame() {
        this.saveGame = null;
    }
}