package components;

public class Position{
	private int x;
	private int y;

	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public boolean comparePosition(Position p) {
		boolean flag = false;
		if(p.getX() == this.getX() && p.getY() == this.getY()) {
			flag = true;
		}
		return flag;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
