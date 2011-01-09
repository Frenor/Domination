package domination;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang.ArrayUtils;

public class Main {
	private static Building[] buildings;
	//	private Troop[] troops;

	public static void setScore() {
		for (int i = 0; i < buildings.length; i++) {
			Building current = buildings[i];
			double bt = current.getBuildtime();
			if(bt == 0)
				bt = 1;
			double timescore = (current.getDominationScore() / bt)*10;
			//double troopscore = current.getBuildTroop().getProfit() * current.getBuildTroopNum();
			current.setScore(timescore);
		}
	}

	public static String[][] readIn() {
		String current = "";
		String[][] lines = new String[0][];
		try {
			FileReader fr = new FileReader("src/domination/input.txt");
			BufferedReader br = new BufferedReader(fr);
			while((current = br.readLine()) != null) {
				String[] line = current.split(";");
				for (int i = 0; i < line.length; i++) {
					if(line[i].equalsIgnoreCase("")){
						line[i] = "0";
					}
				}
				lines = (String[][]) ArrayUtils.add(lines, line);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return lines;
	}

	public static void parseInput() {
		String[][] lines = readIn();
		buildings = new Building[lines.length];
		for (int i = 0; i < lines.length; i++) {
			buildings[i] = new Building(lines[i][0], intToBool(Integer.parseInt(lines[i][11])), timeConversion(lines[i][10]), Integer.parseInt(lines[i][14]), Integer.parseInt(lines[i][12]), lines[i][1]);
		}
		for (int i = 0; i < buildings.length; i++) {
			Building building = buildings[i];
			String name = lines[i][13];
			if(name.equalsIgnoreCase("0")) {
				building.setDependant(null);
			}
			else {
				building.setDependant(findBuilding(name));
			}
		}
	}
	
	public static String removeInt(String input) {
		if (input == null) {
			return null;
		}
		StringBuffer strBuff = new StringBuffer();
		for (int i = 0; i < input.length() ; i++) {
			char c = input.charAt(i);
			if (Character.isLetter(c)) {
				strBuff.append(c);
			}
		}
		return strBuff.toString();
	}
	public static String removeChar(String input) {  
		if (input == null) {
			return null;
		}
		StringBuffer strBuff = new StringBuffer();
		for (int i = 0; i < input.length() ; i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				strBuff.append(c);
			}
		}
		return strBuff.toString();
	}

	public static int timeConversion(String oldTime) {
		int sum = 0;
		if(!oldTime.equalsIgnoreCase("0")) {
			String[] temp = oldTime.split(" ");
			String[][] splitTime = new String[temp.length][2];
			for (int i = 0; i < splitTime.length; i++) {
				splitTime[i][0] = removeChar(temp[i]);
				splitTime[i][1] = removeInt(temp[i]);
			}
			for (int i = 0; i < splitTime.length; i++) {
				for (int j = 0; j < splitTime[i].length - 1; j++) {
					if(splitTime[i][j+1].equals("d")) {
						sum += Integer.parseInt(splitTime[i][j].trim()) * 24*60;
					}
					else if(splitTime[i][j+1].equals("h")) {
						sum += Integer.parseInt(splitTime[i][j].trim()) * 60;
					}
					else if(splitTime[i][j+1].equals("min")) {
						sum += Integer.parseInt(splitTime[i][j].trim());
					}
				}
			}
		}
		return sum;
	}
	
	public static Building findBuilding(String name) {
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i].getName().equalsIgnoreCase(name)) {
				return buildings[i];
			}
		}
		return null;
	}

	public static boolean intToBool(int input) {
		return (input == 1) ? true : false;
	}
	
	public static void main(String[] args) {
		parseInput();
		setScore();
		Select select = new Select(buildings);
		String[] path = select.selectPath();
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
		}
	}
}
