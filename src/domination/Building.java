package domination;

public class Building implements Comparable<Building> {
	private String name;
	private String faction;
	private boolean level;
	private boolean built;
	private int buildtime;
	private int dominationScore;
	private Building dependant;
	private int levelRequirement;
	private double score;
	private Troop buildTroop;
	private int buildTroopNum;

	public Building(String name, boolean level, int buildtime, int dominationScore, int levelRequirement, String faction) {
		super();
		this.name = name;
		this.faction = faction;
		this.level = level;
		this.built = false;
		this.buildtime = buildtime;
		this.dominationScore = dominationScore;
		this.dependant = null;
		this.levelRequirement = levelRequirement;
		this.score = 0;
		this.buildTroop = null;
		this.buildTroopNum = 0;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public String getFaction() {
		return faction;
	}

	public boolean isBuilt() {
		return built;
	}

	public int getBuildtime() {
		return buildtime;
	}
	
	public int getDominationScore() {
		return dominationScore;
	}

	public Building getDependant() {
		return dependant;
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

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Building [name=" + name + ", buildtime=" + buildtime
				+ ", dominationScore=" + dominationScore + ", score=" + score
				+ "]";
	}

	@Override
	public int compareTo(Building o) {
		if(o.score > this.score)
			return 1;
		if(o.score > this.score)
			return 0;
		return -1;
	}
}
