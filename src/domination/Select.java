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
		String input = "Sylvan";
		for (int i = buildings.length - 1; i >= 0; i--) {
			if(!buildings[i].getFaction().equalsIgnoreCase(input)) {
				this.buildings = (Building[]) ArrayUtils.remove(buildings, i);
			}
		}
		makeSort();
	}

	public void makeSort() {
		this.sortedBuildings = this.buildings;
		Arrays.sort(this.sortedBuildings);
	}

	public int getLevel() {
		int count = 0;
		for (int i = 0; i < buildings.length; i++) {
			if(buildings[i].isBuilt() == true) {
				count++;
			}
		}
		return count;
	}

	public boolean canBuild(Building building) {
		if (!building.isBuilt()){
			if (getLevel() >= building.getLevelRequirement()){
				if (building.getDependant() == null)
					return true;
				else if (building.getDependant().isBuilt())
					return true;
			}
		}
		return false;
	}

	public String[] selectPath() {
		selectFaction();
		int i = 0;
		String[] result = null;
		while(getLevel() < sortedBuildings.length) {
			Building current = sortedBuildings[i];
			if(canBuild(current)) {
				current.setBuilt(true);
				result = (String[]) ArrayUtils.add(result, current.getName());
				i = 0;
			}
			else {
				i++;
			}
		}
		return result;
	}
}
