package gui;

import components.Position;
import entity.Appliance;
import entity.Fan;
import entity.Fridge;
import entity.Laptop;
import entity.Oven;
import entity.Toaster;
import entity.Vacuum;
import entity.Wires;
import javafx.animation.AnimationTimer;
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
	private Image[] explosion = new Image[6];
	private Image toastSprite;
	private Image fireSprite;
	private Image frozenSprite;
	private Image iceSprite;
	private Image windSprite;
	
	private int explosionFrame = 0;
	private long lastExplosionUpdate = 0;
	private boolean isExploding = false;
	
	public GameLevel(LevelManager lM) {
		this.setlM(lM);
	}
	
	public GameLevel() {
		this.setlM(new LevelManager());
	}
	
	public void drawMap(GraphicsContext gc) {
		for(Position p:lM.getLevel().getMap().getPositions()) {
			gc.drawImage(floorTile, p.getX()*32, p.getY()*32);
		}
	}
	public void drawAppliances(GraphicsContext gc) {
		for(Appliance a:lM.getLevel().getAppliances()) {
			if(a.isActive()) {
				if(a instanceof Fan) {
					gc.drawImage(fanSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Oven) {
					gc.drawImage(ovenSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Fridge) {
					gc.drawImage(fridgeSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Vacuum) {
					gc.drawImage(vacuumSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Laptop) {
					gc.drawImage(laptopSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Toaster) {
				gc.drawImage(toasterSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}
			}
		}
	}
	public void drawWires(GraphicsContext gc) {
		for(Wires w:lM.getLevel().getWires()) {
			if(w.getVariation() == 3) {
				gc.drawImage(wireSprite3, w.getPosition().getX()*32, w.getPosition().getY()*32);
			}else if(w.getVariation() == 2) {
				gc.drawImage(wireSprite2, w.getPosition().getX()*32, w.getPosition().getY()*32);
			}else if(w.getVariation() == 1) {
				gc.drawImage(wireSprite1, w.getPosition().getX()*32, w.getPosition().getY()*32);
			}
		}
	}
	public void drawPlayer(GraphicsContext gc) {
		gc.drawImage(playerSprite, lM.getPlayer().getPosition().getX()*32, lM.getPlayer().getPosition().getY()*32);
	}
	public void drawExplosions(GraphicsContext gc) {
		if (isExploding && lM.getLevel().getExplosions() != null) {
			for (Position p : lM.getLevel().getExplosions()) {
				gc.drawImage(explosion[explosionFrame], p.getX() * 32, p.getY() * 32);
			}
		}
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
            explosion[0] = new Image(getClass().getResourceAsStream("/explosion1.png"));
            explosion[1] = new Image(getClass().getResourceAsStream("/explosion2.png"));
            explosion[2] = new Image(getClass().getResourceAsStream("/explosion3.png"));
            explosion[3] = new Image(getClass().getResourceAsStream("/explosion4.png"));
            explosion[4] = new Image(getClass().getResourceAsStream("/explosion5.png"));
            explosion[5] = new Image(getClass().getResourceAsStream("/explosion6.png"));
            toastSprite = new Image(getClass().getResourceAsStream("/toast.png"));
            fireSprite = new Image(getClass().getResourceAsStream("/fire.png"));
            frozenSprite = new Image(getClass().getResourceAsStream("/frozen.png"));
            iceSprite = new Image(getClass().getResourceAsStream("/ice.png"));
            windSprite = new Image(getClass().getResourceAsStream("/wind.png"));
        }catch (Exception e) {
            System.out.println("Error al cargar las imágenes desde resources: " + e.getMessage());
        }
		lM.start();
		
		Button btnGoBack = createButton("Volver");
		
		btnGoBack.setOnAction(e -> {
            new GameMenu().start(primaryStage);
        });
		
		Canvas canvas = new Canvas(10*32, 10 *32);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawMap(gc);
		drawWires(gc);
		drawAppliances(gc);
		drawPlayer(gc);
		
		AnimationTimer gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (isExploding && (now - lastExplosionUpdate >= 120_000_000L)) {
					explosionFrame++;
					lastExplosionUpdate = now;
					if (explosionFrame >= explosion.length) {
						explosionFrame = 0;
						isExploding = false;
						
						if (lM.getLevel().getExplosions() != null) {
		                    lM.getLevel().getExplosions().clear();
		                    
		                    if(lM.checkWin()) {
		                    	try {
									new WinMenu(lM).start(primaryStage);
								} catch (Exception e) {
									e.printStackTrace();
								} 
		                    }
		                }
					}
					
					gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
					drawMap(gc);
					drawWires(gc);
					drawAppliances(gc);
					drawPlayer(gc);
					drawExplosions(gc);
				}
			}
		};
		gameLoop.start();
		
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
        
        scene.setOnKeyPressed(e -> {
        	if (isExploding) {
                return; 
            }
            boolean moved = false;
            
            switch(e.getCode()) {
            case W:
            	lM.playerAct(1);
            	moved = true;
            	break;
           	case D:
           		lM.playerAct(2);
           		moved = true;
           		break;
           	case S:
           		lM.playerAct(3);
           		moved = true;
           		break;
           	case A:
           		lM.playerAct(4);
           		moved = true;
           		break;
           	case ESCAPE:
			default:
				break;
            }
            	
           	if (moved) {
           		if (lM.getLevel().getExplosions() != null && !lM.getLevel().getExplosions().isEmpty()) {
           			isExploding = true;
           			explosionFrame = 0;
           			lastExplosionUpdate = System.nanoTime();
           		}else {
           			if(lM.checkLose()) {
                		try {
    						new LoseMenu(lM).start(primaryStage);
    					} catch (Exception e1) {
    						e1.printStackTrace();
    					}
                	}
           		}
           		
           		gc.clearRect(0, 0, 320, 320);
           		drawMap(gc);
           		drawWires(gc);
           		drawAppliances(gc);
            	drawPlayer(gc);
            	drawExplosions(gc);
            	
            	System.out.println("Turno actual: " + lM.getTurn());
            }
        });
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