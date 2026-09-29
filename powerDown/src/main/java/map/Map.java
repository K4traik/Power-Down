package map;

import components.Position;
import java.util.ArrayList;

public class Map {
	private ArrayList<Position> positions;
	
	public Map() {
		positions = new ArrayList<Position>();
	}
	
	public boolean isPositionAvailable(Position position) {
        for(Position p:positions) {
        	if(p==position) {
        		return true;
        	}
        }
        return false;
    }
	public ArrayList<Position> getPositions() {
		return positions;
	}
	public void setPositions(ArrayList<Position> positions) {
		this.positions = positions;
	}
}
