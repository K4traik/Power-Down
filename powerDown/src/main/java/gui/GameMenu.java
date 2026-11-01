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
	
    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("POWER DOWN");
        title.setFont(new Font("Arial", 36));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        
        Button btnPlay = createButton("Jugar");
        Button btnSaves = createButton("Sesiones");
        Button btnLeave = createButton("Salir");

        btnPlay.setOnAction(e -> {
            System.out.println("Iniciando partida...");
        });

        btnSaves.setOnAction(e -> {
            System.out.println("Abriendo menú de sesiones...");
            SessionMenu sessions = new SessionMenu();
            sessions.mostrarSesiones(primaryStage, () -> {
            });
        });

        btnLeave.setOnAction(e -> primaryStage.close());

        VBox menu = new VBox(20);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(title, btnPlay, btnSaves, btnLeave);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #1e1e24;");
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
        btn.setFont(new Font("Arial", 16));
        btn.setStyle(
            "-fx-background-color: #3a3d40; " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 8;"
        );

        btn.setOnMouseEntered(e -> btn.setStyle(
            "-fx-background-color: #575a5e; " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 8;"
        ));
        
        btn.setOnMouseExited(e -> btn.setStyle(
            "-fx-background-color: #3a3d40; " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 8;"
        ));

        return btn;
    }
}