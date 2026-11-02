package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import levelmanager.LevelManager;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameLevel extends Application{
	private LevelManager lM;
	
	public GameLevel(LevelManager lM) {
		this.setlM(lM);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Button btnGoBack = createButton("Volver");
		
		btnGoBack.setOnAction(e -> {
            new GameMenu().start(primaryStage);
        });
		
		VBox menu = new VBox(20);
        menu.setAlignment(Pos.BOTTOM_CENTER);
        menu.getChildren().add(btnGoBack);

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

	public LevelManager getlM() {
		return lM;
	}
	public void setlM(LevelManager lM) {
		this.lM = lM;
	}
}