package gui;

import components.Position;
import entity.Appliance;
import entity.Fan;
import entity.Fridge;
import entity.Laptop;
import entity.Oven;
import entity.Toaster;
import entity.Vacuum;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import levelmanager.LevelManager;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameLevel extends Application{
	private LevelManager lM;
	private Image floorTile;
	private Image wireSprite1;
	private Image wireSprite2;
	private Image wireSprite3;
	private Image playerSprite;
	private Image fanSprite;
	private Image ovenSprite;
	private Image fridgeSprite;
	private Image vacuumSprite;
	private Image laptopSprite;
	private Image toasterSprite;
	private Image explosion1;
	private Image explosion2;
	private Image explosion3;
	private Image explosion4;
	private Image explosion5;
	private Image explosion6;
	private Image toastSprite;
	private Image fireSprite;
	private Image frozenSprite;
	private Image iceSprite;
	private Image windSprite;
	
	public GameLevel(LevelManager lM) {
		this.setlM(lM);
	}
	
	public GameLevel() {
		this.setlM(new LevelManager());
	}
	
	public void drawMap(GraphicsContext gc) {
		for(Position p:lM.getLevel().getMap().getPositions()) {
			gc.drawImage(floorTile, p.x*32, p.y*32);
		}
	}
	public void drawAppliances(GraphicsContext gc) {
		for(Appliance a:lM.getLevel().getAppliances()) {
			if(a instanceof Fan) {
				gc.drawImage(fanSprite, a.getPosition().x*32, a.getPosition().y*32);
			}else if(a instanceof Oven) {
				gc.drawImage(ovenSprite, a.getPosition().x*32, a.getPosition().y*32);
			}else if(a instanceof Fridge) {
				gc.drawImage(fridgeSprite, a.getPosition().x*32, a.getPosition().y*32);
			}else if(a instanceof Vacuum) {
				gc.drawImage(vacuumSprite, a.getPosition().x*32, a.getPosition().y*32);
			}else if(a instanceof Laptop) {
				gc.drawImage(laptopSprite, a.getPosition().x*32, a.getPosition().y*32);
			}else if(a instanceof Toaster) {
				gc.drawImage(toasterSprite, a.getPosition().x*32, a.getPosition().y*32);
			}
		}
	}
	public void drawWires() {
		
	}
	public void drawPlayer() {
		
	}
	@Override
	public void start(Stage primaryStage) {
		try {
            floorTile = new Image(getClass().getResourceAsStream("/tile1.png"));
            wireSprite1 = new Image(getClass().getResourceAsStream("/wire.png"));
            wireSprite2 = new Image(getClass().getResourceAsStream("/wire2.png"));
            wireSprite3 = new Image(getClass().getResourceAsStream("/wire3.png"));
            playerSprite = new Image(getClass().getResourceAsStream("/puerro_boy.png"));
            fanSprite = new Image(getClass().getResourceAsStream("/fan.png"));
            ovenSprite = new Image(getClass().getResourceAsStream("/oven.png"));
            fridgeSprite = new Image(getClass().getResourceAsStream("/fridge.png"));
            vacuumSprite = new Image(getClass().getResourceAsStream("/vacuum.png"));
            laptopSprite = new Image(getClass().getResourceAsStream("/laptop.png"));
            toasterSprite = new Image(getClass().getResourceAsStream("/toaster.png"));
            explosion1 = new Image(getClass().getResourceAsStream("/explosion1.png"));
            explosion2 = new Image(getClass().getResourceAsStream("/explosion2.png"));
            explosion3 = new Image(getClass().getResourceAsStream("/explosion3.png"));
            explosion4 = new Image(getClass().getResourceAsStream("/explosion4.png"));
            explosion5 = new Image(getClass().getResourceAsStream("/explosion5.png"));
            explosion6 = new Image(getClass().getResourceAsStream("/explosion6.png"));
            toastSprite = new Image(getClass().getResourceAsStream("/toast.png"));
            fireSprite = new Image(getClass().getResourceAsStream("/fire.png"));
            frozenSprite = new Image(getClass().getResourceAsStream("/frozen.png"));
            iceSprite = new Image(getClass().getResourceAsStream("/ice.png"));
            windSprite = new Image(getClass().getResourceAsStream("/wind.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar las imágenes desde resources: " + e.getMessage());
        }
		
		Button btnGoBack = createButton("Volver");
		
		btnGoBack.setOnAction(e -> {
            new GameMenu().start(primaryStage);
        });
		
		Canvas canvas = new Canvas(10*32, 10 *32);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawMap(gc);
		drawAppliances(gc);
		
		VBox menu = new VBox(20);
        menu.setAlignment(Pos.BOTTOM_CENTER);
        menu.getChildren().add(btnGoBack);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #222034;");
        root.getChildren().addAll(canvas, menu);

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

	public LevelManager getlM() {
		return lM;
	}
	public void setlM(LevelManager lM) {
		this.lM = lM;
	}
}