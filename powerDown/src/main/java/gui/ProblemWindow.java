package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProblemWindow extends Application {
	private String title;
	private String text;
	
	public ProblemWindow(String title, String text) {
		setTitle(title);
		setText(text);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label realTitle = new Label(title);
		realTitle.setFont(new Font("Arial", 24));
		realTitle.setStyle("-fx-font-weight: bold;");
		
		Button btnAccept = createButton("Aceptar");
		
		btnAccept.setOnAction(e -> primaryStage.close());
		
		Label realText = new Label(text);
		realText.setFont(new Font("Arial", 11));
		
		SVGPath warningIcon = createWarningIcon(1.0);
		
		VBox window = new VBox(5);
		window.setAlignment(Pos.CENTER);
		window.getChildren().addAll(realTitle, warningIcon, btnAccept);
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
	
	public SVGPath createWarningIcon(double scale) {
	    SVGPath icon = new SVGPath();
	    icon.setContent("M1 21h22L12 2 1 21zm12-3h-2v-2h2v2zm0-4h-2v-4h2v4z");
	    icon.setFill(Color.GOLD);
	    icon.setStroke(Color.BLACK);
	    icon.setStrokeWidth(0.8);
	    
	    icon.setScaleX(scale);
	    icon.setScaleY(scale);
	    return icon;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}