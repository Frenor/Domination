package domination;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

public class Select {
	private Building[] buildings;
	private Building[] sortedBuildings;
	
	public Select(Building[] buildings) {
		this.buildings = buildings;
		this.sortedBuildings = buildings;
		makeSort();
	}
	
	public void selectFaction() {
		String input = "Academy";
		for (int i = 0; i < buildings.length; i++) {
			if(!buildings[i].getFaction().equalsIgnoreCase(input)) {
				ArrayUtils.remove(buildings, i);
			}
		}
		makeSort();
	}
	
	public void makeSort() {
		this.sortedBuildings = this.buildings;
		Arrays.sort(this.sortedBuildings);
	}
	
	public int getLevel() {
		for (int i = 0; i < buildings.length; i++) {
			
		}
	}
}
