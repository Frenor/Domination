package domination;

public class Building {
	private boolean level; 
	private boolean built;
	private int buildtime; 
	private Building dependant;
	private int troopGen; 
	private int levelRequirement; 
	private int score; 
	private Troop buildTroop;
	private int buildTroopNum;
	
	public Building(boolean level, boolean built, int buildtime,
			Building dependant, int troopGen, int levelRequirement,
			Troop buildTroop, int buildTroopNum) {
		super();
		this.level = level;
		this.built = built;
		this.buildtime = buildtime;
		this.dependant = dependant;
		this.troopGen = troopGen;
		this.levelRequirement = levelRequirement;
		this.buildTroop = buildTroop;
		this.buildTroopNum = buildTroopNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isBuilt() {
		return built;
	}

	public int getBuildtime() {
		return buildtime;
	}

	public Building getDependant() {
		return dependant;
	}

	public int getTroopGen() {
		return troopGen;
	}

	public int getLevelRequirement() {
		return levelRequirement;
	}

	public Troop getBuildTroop() {
		return buildTroop;
	}

	public int getBuildTroopNum() {
		return buildTroopNum;
	}
	
	public boolean isLevel() {
		return level;
	}


}
