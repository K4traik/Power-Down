package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import levelmanager.LevelManager;

public class GameMenu extends Application {
	private LevelManager lM = new LevelManager();
	
	public GameMenu() {
		lM = new LevelManager();
	}
	public GameMenu(LevelManager lM) {
		setLevelManager(lM);
	}
	
    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("POWER DOWN");
        title.setFont(new Font("Arial", 36));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        
        Button btnPlay = createButton("Jugar");
        Button btnSaves = createButton("Sesiones");
        Button btnLeave = createButton("Salir");

        btnPlay.setOnAction(e -> {
            new GameLevel(lM).start(primaryStage);
        });

        btnSaves.setOnAction(e -> {
            System.out.println("Abriendo menú de sesiones...");
            new SessionMenu().mostrarSesiones(primaryStage, () -> {});
        });

        btnLeave.setOnAction(e -> primaryStage.close());

        VBox menu = new VBox(20);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(title, btnPlay, btnSaves, btnLeave);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #222034;");
        root.getChildren().add(menu);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("PowerDown");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button btn = new Button(text);
        btn.setPrefWidth(200);
        btn.setPrefHeight(40);
        btn.setFont(new Font("Roboto", 16));
        btn.setStyle(
            "-fx-background-color: #5b6ee1; " +
            "-fx-text-fill: black; " +
            "-fx-background-radius: 8;"
        );

        btn.setOnMouseEntered(e -> btn.setStyle(
            "-fx-background-color: #5fcde4; " +
            "-fx-text-fill: black; " +
            "-fx-background-radius: 8;"
        ));
        
        btn.setOnMouseExited(e -> btn.setStyle(
            "-fx-background-color: #639bff; " +
            "-fx-text-fill: black; " +
            "-fx-background-radius: 8;"
        ));

        return btn;
    }
    
	public LevelManager getLevelManager() {
		return lM;
	}
	public void setLevelManager(LevelManager lM) {
		this.lM = lM;
	}
}