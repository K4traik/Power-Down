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
	private Image[] shortWire = new Image[4];
	private Image[] longWire = new Image[4];
	private Image[] curvedWire = new Image[4];
	private Image playerSprite;
	private Image[] fanSprite = new Image[4];
	private Image[] ovenSprite = new Image[4];
	private Image[] fridgeSprite = new Image[4];
	private Image vacuumSprite;
	private Image laptopSprite;
	private Image[] toasterSprite = new Image[4];
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
					gc.drawImage(fanSprite[a.getFacing()-1], a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Oven) {
					gc.drawImage(ovenSprite[a.getFacing()-1], a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Fridge) {
					gc.drawImage(fridgeSprite[a.getFacing()-1], a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Vacuum) {
					gc.drawImage(vacuumSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Laptop) {
					gc.drawImage(laptopSprite, a.getPosition().getX()*32, a.getPosition().getY()*32);
				}else if(a instanceof Toaster) {
				gc.drawImage(toasterSprite[a.getFacing()-1], a.getPosition().getX()*32, a.getPosition().getY()*32);
				}
			}
		}
	}
	public void drawWires(GraphicsContext gc) {
		for(Wires w:lM.getLevel().getWires()) {
			if(w.getVariation() == 3) {
				gc.drawImage(longWire[w.getFacing()-1], w.getPosition().getX()*32, w.getPosition().getY()*32);
			}else if(w.getVariation() == 2) {
				gc.drawImage(curvedWire[w.getFacing()-1], w.getPosition().getX()*32, w.getPosition().getY()*32);
			}else if(w.getVariation() == 1) {
				gc.drawImage(shortWire[w.getFacing()-1], w.getPosition().getX()*32, w.getPosition().getY()*32);
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
	private Image cargarImagen(String path) {
	    var stream = getClass().getResourceAsStream(path);
	    if (stream == null) {
	        System.out.println("❌ NO SE ENCONTRÓ EL ARCHIVO: " + path);
	    }
	    return new Image(stream);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
		    floorTile = cargarImagen("/tile1.png");
		    playerSprite = cargarImagen("/puerro_boy.png");
		    vacuumSprite = cargarImagen("/vacuum.png");
		    laptopSprite = cargarImagen("/laptop.png");
		    
		    for(int i = 0; i < 6; i++) {
		        explosion[i] = cargarImagen("/explosion" + (i + 1) + ".png");
		    }
		    
		    toastSprite = cargarImagen("/toast.png");
		    fireSprite = cargarImagen("/fire.png");
		    frozenSprite = cargarImagen("/frozen.png");
		    iceSprite = cargarImagen("/ice.png");
		    windSprite = cargarImagen("/wind.png");
		    
		    longWire[0] = cargarImagen("/wires/longwire1.png");
		    longWire[1] = cargarImagen("/wires/longwire2.png");
		    
		    for(int i = 0; i < 4; i++) {
		        // ¡OJO ACÁ! Si tus archivos empiezan en 1 (ej: shortwire1.png), 
		        // usar 'i' tirará error cuando i = 0 porque buscará "shortwire0.png".
		        shortWire[i] = cargarImagen("/wires/shortwire" + (i + 1) + ".png");
		        curvedWire[i] = cargarImagen("/wires/curvedwire" + (i + 1) + ".png");
		        toasterSprite[i] = cargarImagen("/toaster/toaster" + (i + 1) + ".png");
		        ovenSprite[i] = cargarImagen("/oven/oven" + (i + 1) + ".png");
		        fanSprite[i] = cargarImagen("/fan/fan" + (i + 1) + ".png"); // ¿Estaba dentro de una carpeta /fan/?
		        fridgeSprite[i] = cargarImagen("/fridge/fridge" + (i + 1) + ".png");
		    }
		} catch (Exception e) {
		    System.out.println("Error al cargar una imagen: " + e.getMessage());
		    e.printStackTrace(); // Esto te mostrará la línea exacta donde falló
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