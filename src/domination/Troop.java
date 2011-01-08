package domination;

public class Troop {
	private String name;
	private int power;
	private int cost;
	private double profit;
	private int xp;
	
	public Troop(String name, int power, int cost, double profit, int xp) {
		super();
		this.name = name;
		this.power = power;
		this.cost = cost;
		this.profit = profit;
		this.xp = xp;
	}
	
	public double getProfit() {
		return this.profit;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getXp() {
		return xp;
	}

	public int getCost() {
		return cost;
	}
	
}
