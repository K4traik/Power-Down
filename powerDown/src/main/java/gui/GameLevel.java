package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import levelmanager.LevelManager;

public class GameLevel extends Application{
	private LevelManager lM;
	
	public GameLevel(LevelManager lM) {
		this.setlM(lM);
	}
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println("hola");
	}
	
	public LevelManager getlM() {
		return lM;
	}
	public void setlM(LevelManager lM) {
		this.lM = lM;
	}
}