package map;

import java.util.ArrayList;
import components.Position;
import entity.Appliance;
import entity.Fan;
import entity.Fridge;
import entity.Oven;
import entity.Toaster;
import entity.Wires;

public class Levels {
	public static Level firstLevel() {
		Map map = basicGrid();
		ArrayList<Appliance> appliances = new ArrayList<Appliance>();
		ArrayList<Wires> wires = new ArrayList<Wires>();
		
		Fan fan1 = new Fan(true, 3, new Position(4, 8));
		Oven oven1 = new Oven(true, 2, new Position(5, 1));
		
		Wires wire1fan1 = new Wires(new Position(4, 8), fan1, 1, 1);
		Wires wire2fan1 = new Wires(new Position(4, 9), fan1, 3, 1);
		Wires wire1oven1 = new Wires(new Position(5, 1), oven1, 1, 2);
		Wires wire2oven1 = new Wires(new Position(6, 1), oven1, 3, 2);
		Wires wire3oven1 = new Wires(new Position(7, 1), oven1, 3, 2);
		Wires wire4oven1 = new Wires(new Position(8, 1), oven1, 3, 2);
		Wires wire5oven1 = new Wires(new Position(9, 1), oven1, 3, 2);
		
		appliances.add(fan1);
		appliances.add(oven1);
		
		wires.add(wire5oven1);
		wires.add(wire4oven1);
		wires.add(wire3oven1);
		wires.add(wire2oven1);
		wires.add(wire1oven1);
		wires.add(wire2fan1);
		wires.add(wire1fan1);
		
		return new Level(map, wires, appliances, new ArrayList<Position>());
	}
	public static Level secondLevel() {
		Map map = basicGrid();
		ArrayList<Appliance> appliances = new ArrayList<Appliance>();
		ArrayList<Wires> wires = new ArrayList<Wires>();
		
		Toaster toaster1 = new Toaster(true, 3, new Position(1, 9));
		Toaster toaster2 = new Toaster(true, 1, new Position(2, 0));
		Fridge fridge1 = new Fridge(true, 2, new Position(3, 2));
		
		Wires wire1toaster1 = new Wires(new Position(1, 9), toaster1, 1, 4);
		Wires wire2toaster1 = new Wires(new Position(2, 9), toaster1, 2, 1);
		Wires wire1toaster2 = new Wires(new Position(2, 0), toaster2, 1, 4);
		Wires wire2toaster2 = new Wires(new Position(3, 0), toaster2, 2, 2);
		Wires wire1fridge1 = new Wires(new Position(3, 2), fridge1, 1, 4);
		Wires wire2fridge1 = new Wires(new Position(4, 2), fridge1, 3, 4);
		Wires wire3fridge1 = new Wires(new Position(5, 2), fridge1, 3, 4);
		Wires wire4fridge1 = new Wires(new Position(6, 2), fridge1, 3, 4);
		Wires wire5fridge1 = new Wires(new Position(7, 2), fridge1, 3, 4);
		Wires wire6fridge1 = new Wires(new Position(8, 2), fridge1, 3, 4);
		Wires wire7fridge1 = new Wires(new Position(9, 2), fridge1, 3, 4);
		
		wires.add(wire7fridge1);
		wires.add(wire6fridge1);
		wires.add(wire5fridge1);
		wires.add(wire4fridge1);
		wires.add(wire3fridge1);
		wires.add(wire2fridge1);
		wires.add(wire1fridge1);
		wires.add(wire2toaster2);
		wires.add(wire1toaster2);
		wires.add(wire2toaster1);
		wires.add(wire1toaster1);
		
		appliances.add(fridge1);
		appliances.add(toaster2);
		appliances.add(toaster1);
		
		return new Level(map, wires, appliances, new ArrayList<Position>());
	}
	public static Level thirdLevel() {
		Map map = basicGrid();
		ArrayList<Appliance> appliances = new ArrayList<Appliance>();
		ArrayList<Wires> wires = new ArrayList<Wires>();
		
		Fan fan1 = new Fan(true, 3, new Position(4, 8));
		Fridge fridge1 = new Fridge(true, 2, new Position(6, 9));
		Oven oven1 = new Oven(true, 3, new Position(1, 3));
		Toaster toaster1 = new Toaster(true, 2, new Position(9, 1));
		
		Wires wire1fan1 = new Wires(new Position(4, 8), fan1, 1, 1);
		Wires wire2fan1 = new Wires(new Position(4, 9), fan1, 3, 1);
		Wires wire1fridge1 = new Wires(new Position(6, 9), fridge1, 1, 4);
		Wires wire2fridge1 = new Wires(new Position(7, 9), fridge1, 2, 1);
		Wires wire1oven1 = new Wires(new Position(1, 3), oven1, 1, 1);
		Wires wire2oven1 = new Wires(new Position(0, 3), oven1, 3, 2);
		Wires wire1toaster1 = new Wires(new Position(9, 1), toaster1, 1, 1);
		Wires wire2toaster1 = new Wires(new Position(9, 2), toaster1, 2, 3);
		
		wires.add(wire2toaster1);
		wires.add(wire1toaster1);
		wires.add(wire2oven1);
		wires.add(wire1oven1);
		wires.add(wire2fridge1);
		wires.add(wire1fridge1);
		wires.add(wire2fan1);
		wires.add(wire1fan1);
		
		appliances.add(toaster1);
		appliances.add(oven1);
		appliances.add(fridge1);
		appliances.add(fan1);
		
		return new Level(map, wires, appliances, new ArrayList<Position>());
	}
	public static Map basicGrid() {
		Map map = new Map();
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				map.addPosition(new Position(j, i));
			}
		}
		return map;
	}
	public static Level getLevel(int i) {
		if(i == 3) {
			return thirdLevel();
		}else if(i == 2) {
			return secondLevel();
		}else if(i == 1){
			return firstLevel();
		}
		return firstLevel();
	}
}
