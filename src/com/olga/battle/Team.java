package com.olga.battle;

import java.util.ArrayList;
import java.util.List;

import com.olga.additional.Keyboard;
import com.olga.droids.SimpleDroid;
import com.olga.droids.SimpleBattleDroid;
import com.olga.droids.SimpleRepairDroid;
import com.olga.droids.SuperDroid;

public class Team {
	private Integer beginNumberOfTeamMembers;
	private Integer currentNumberOfTeamMembers;
	private ArrayList<SimpleDroid> teamList;
	private final Keyboard readerFromKeyboard;
	private String teamName;

	public SimpleDroid findFirstInjuredDroid() {
		for (SimpleDroid droid : teamList) {
			if (droid.getHealth() < droid.getMaxHealth()) {
				return droid;
			}
		}
		return null;
	}

	public Integer sumEnergy() {
		Integer sum = 0;
		for (SimpleDroid currentDroid : teamList) {
			sum += currentDroid.getEnergy();
		}
		return sum;
	}

	public void deleteTeamMember(SimpleDroid droidToDelete) {
		int indexOfDroidToDelete = teamList.indexOf(droidToDelete);
		teamList.remove(indexOfDroidToDelete);
	}

	public void fillInTeamList() {
		System.out.println("Team has " + beginNumberOfTeamMembers + " members.");
		System.out.println("Chois types of drids: 1- RepairDroid; 2- BattleDroid; 3- SuperDroid");
		
		SimpleDroid currentDroid = null;
		int i = 0;
		while (i < beginNumberOfTeamMembers) {
			Integer typeTeamMember = readerFromKeyboard
					.readIntegerFromKeyboard("Input the type of team member ¹ " + (i + 1));
			switch (typeTeamMember) {
			case 1:
				currentDroid = new SimpleRepairDroid();
				break;
			case 2:
				currentDroid = new SimpleBattleDroid();
				break;
			case 3:
				currentDroid = new SuperDroid();
				break;
			default:
				System.out.println("You enter wrong type of droid ¹ " + i + "Try again");
				break;
			}
			if (typeTeamMember == 1 || typeTeamMember == 2 || typeTeamMember == 3) {
				i++;
				teamList.add(currentDroid);
				currentDroid.setMyTeam(this);
			}

		}
	}

	/**
	 * @param numberOfTeamMembers
	 */
	public Team(Integer numberOfTeamMembers) { // Constructor with number of team's members
		setNumberOfTeamMembers(numberOfTeamMembers);
		setTeamList(new ArrayList<SimpleDroid>(numberOfTeamMembers));
		readerFromKeyboard = new Keyboard();
		String s = readerFromKeyboard.readStringFromKeyboard("Enter the name of team");
		setTeamName(s);
	}

	public Integer getBeginNumberOfTeamMembers() {
		return beginNumberOfTeamMembers;
	}

	public Integer getNumberOfTeamMembers() {
		return beginNumberOfTeamMembers;
	}

	public void setNumberOfTeamMembers(Integer beginNumberOfTeamMembers) {
		this.beginNumberOfTeamMembers = beginNumberOfTeamMembers;
	}

	public ArrayList<SimpleDroid> getTeamList() {
		return teamList;
	}

	public void setTeamList(ArrayList<SimpleDroid> teamList) {
		this.teamList = teamList;
	}

	public Integer getCurrentNumberOfTeamMembers() {
		return teamList.size();
	}

	public void setCurrentNumberOfTeamMembers(Integer currentNumberOfTeamMembers) {
		this.currentNumberOfTeamMembers = currentNumberOfTeamMembers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
