package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SessionMenu {

	public void mostrarSesiones(Stage ventana, Runnable volverMenu) {

    	Label title= new Label ("Menu de Sessiones");
        title.setFont(new Font("Arial", 36));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        
        Label Session1= new Label ("partida 1");
        Button btnLoad1 = createButton ("cargar");   
        btnLoad1.setDisable(true);
        
        HBox slot1 = new HBox(20, Session1, btnLoad1);
        slot1.setAlignment(Pos.CENTER);
        
        Label Session2= new Label ("partida 2");
        Button btnLoad2 = createButton ("cargar");   
        btnLoad2.setDisable(true);
        
        HBox slot2 = new HBox(20, Session2, btnLoad1);
        slot2.setAlignment(Pos.CENTER);

        Label Session3= new Label ("partida 3");
        Button btnLoad3 = createButton ("cargar");   
        btnLoad3.setDisable(true);
        
        HBox slot3 = new HBox(20, Session3, btnLoad3);
        slot3.setAlignment(Pos.CENTER);
        
        Button btnBack= createButton("volver");
        
        btnBack.setOnAction(e -> {
            System.out.println("Volviendo al menú");
            volverMenu.run();
        });
        
        VBox menu = new VBox(25);

        menu.setAlignment(Pos.CENTER);

        menu.getChildren().addAll(
            title,
            slot1,
            slot2,
            slot3,
            btnBack
        );

        menu.setStyle("-fx-background-color: #1e1e24;");
        
        Scene scene = new Scene(menu, 800, 600);

        ventana.setTitle("PowerDown - Sesiones");
        ventana.setScene(scene);
	}

    private Button createButton (String text) {

        Button btn = new Button(text);

        btn.setPrefWidth(120);
        btn.setPrefHeight(35);
        btn.setFont(new Font("Arial", 14));

        btn.setStyle(
            "-fx-background-color: #3a3d40; " +
            "-fx-text-fill: white; " +
            "-fx-background-radius: 8;"
        );
        
        return btn;

}}
