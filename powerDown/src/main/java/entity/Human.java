package entity;

public class Human extends Entity{
	private int health;
	
	public Human(int health) {
		this.health=health;
	}
	
	public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

   public void damage() {
        this.health = this.health - 10;
}
}