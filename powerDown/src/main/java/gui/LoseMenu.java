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

public class LoseMenu extends Application{
	private LevelManager lM;
	
	public LoseMenu(LevelManager lM) {
		this.setlM(lM);
	}
	
	public LoseMenu() {
		this.setlM(new LevelManager());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label title = new Label("PERDISTE!");
        title.setFont(new Font("Arial", 36));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        
        Button btnBack = createButton("Volver al menú");
        Button btnRetry = createButton("Reintentar");
        
        btnBack.setOnAction(_ -> {
        	new GameMenu(lM).start(primaryStage);
        });
        btnRetry.setOnAction(_ -> {
        	new GameLevel(lM).start(primaryStage);
        });
        
        VBox menu = new VBox(20);
        menu.setAlignment(Pos.CENTER);
        menu.getChildren().addAll(title, btnBack, btnRetry);

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
    	btn.setOnMouseEntered(_ -> btn.setStyle(
    			"-fx-background-color: #5fcde4; " +
    					"-fx-text-fill: black; " +
    					"-fx-background-radius: 8;"
    			));
    	btn.setOnMouseExited(_ -> btn.setStyle(
    			"-fx-background-color: #639bff; " +
    					"-fx-text-fill: black; " +
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