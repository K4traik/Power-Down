package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SessionMenu extends Application{

	public void mostrarSesiones(Stage ventana, Runnable volverMenu) {
		
		
    	Label title= new Label ("Menu de Sessiones");
        title.setFont(new Font("Arial", 36));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        
        Label Session1= new Label ("partida 1");
        Button btnLoad1 = createButton ("cargar");
        Button btnDelete = createButton ("eliminar");
        btnLoad1.setDisable(false);
        btnDelete.setDisable(false);
        
        HBox slot1 = new HBox(20, Session1, btnLoad1, btnDelete);
        slot1.setAlignment(Pos.CENTER);
        
        Label Session2= new Label ("partida 2");
        Button btnLoad2 = createButton ("cargar");
        Button btnDelete2 = createButton ("eliminar");
        
        btnLoad2.setDisable(false);
        btnDelete2.setDisable(false);
        
        HBox slot2 = new HBox(20, Session2, btnLoad2, btnDelete2);
        slot2.setAlignment(Pos.CENTER);

        Label Session3= new Label ("partida 3");
        Button btnLoad3 = createButton ("cargar");
        Button btnDelete3 = createButton ("eliminar");

        btnDelete3.setDisable(false);
        btnLoad3.setDisable(false);
        
        HBox slot3 = new HBox(20, Session3, btnLoad3, btnDelete3);
        slot3.setAlignment(Pos.CENTER);
        
        Button btnBack= createButton("volver al menú");
        
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
        
        String estiloBase = "-fx-background-color: #3a3d40; -fx-text-fill: white; -fx-background-radius: 8;";
        String estiloOscuro = "-fx-background-color: #282a2e; -fx-text-fill: white; -fx-background-radius: 8;"; 

        btn.setStyle(estiloBase);

        btn.setOnMouseEntered(e -> btn.setStyle(estiloOscuro));
        
        btn.setOnMouseExited(e -> btn.setStyle(estiloBase));
        
        return btn;

}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}}
