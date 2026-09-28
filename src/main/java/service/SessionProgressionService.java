package service;

public class SessionProgressionService {
	private SessionProgression partidaGuardada;

    public void saveGame(SessionProgression s) {
        this.partidaGuardada = s;
        System.out.println("Partida guardada con éxito en el nivel " + s.currentLevel);
    }

    public SessionProgression rachargeGame() {
        return this.partidaGuardada;
    }

    public void deleteGame() {
        this.partidaGuardada = null;
        System.out.println("Partida eliminada.");
    }
}
