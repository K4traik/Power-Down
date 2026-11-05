package map;

import java.util.ArrayList;
import components.Position;

public class Levels {
	private static Map level1 = new Map();
	private static Map level2 = new Map();
	private static Map level3 = new Map();
	
	private static void buildMaps() {
		ArrayList<Position> positions = new ArrayList<Position>();
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				positions.add(new Position(i, j));
			}
		}
		level1.setPositions(positions);
		level2.setPositions(positions);
		level3.setPositions(positions);
	}
	public static Map getMap(int i) {
		buildMaps();
		if(i == 3) {
			return level3;
		}else if(i == 2) {
			return level2;
		}else if(i == 1){
			return level1;
		}
		return level1;
	}
}
