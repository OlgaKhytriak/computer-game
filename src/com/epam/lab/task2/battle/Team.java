package com.epam.lab.task2.battle;

import java.util.ArrayList;

import com.epam.lab.task2.droids.BattleDroid;
import com.epam.lab.task2.droids.ChargeEnergyDroid;
import com.epam.lab.task2.droids.SimpleChargeEnergyDroid;
import com.epam.lab.task2.droids.SimpleDroid;
import com.epam.lab.task2.io.Keyboard;

public class Team {
	private Integer beginNumberOfTeamMembers;
	private ArrayList<SimpleDroid> teamList;
	private final Keyboard readerFromKeyboard;
	private String teamName;
	private final TeamListFiller teamListFiller;

	/**
	 * Constructor with number of team's members
	 * 
	 * @param numberOfTeamMembers
	 */
	public Team(Integer numberOfTeamMembers) {
		setNumberOfTeamMembers(numberOfTeamMembers);
		setTeamList(new ArrayList<SimpleDroid>(numberOfTeamMembers));
		readerFromKeyboard = new Keyboard();
		String s = readerFromKeyboard.readStringFromKeyboard("Enter the name of team");
		setTeamName(s);
		teamListFiller = new TeamListFiller();
		teamListFiller.fill(this);

	}

	/**
	 * Find the first injured (current health points < max potential heals points)
	 * droin in the team.
	 * 
	 * @return {@link SimpleDroid} the first injured droid in the team ; Return
	 *         <b>null</b> if there is no injured droids in the team
	 */
	public SimpleDroid findFirstInjuredDroid() {
		for (SimpleDroid droid : teamList) {
			if (droid.getHealth() < droid.getMaxHealth()) {
				return droid;
			}
		}
		return null;
	}

	public SimpleDroid findFirstDischargedDroid() {
		for (SimpleDroid droid : teamList) {
			if (droid.getEnergy() < droid.getMaxEnergy()) {
				return droid;
			}
		}
		return null;
	}
	public boolean isBattleDroidTeam() {
		for (SimpleDroid droid : teamList) {
			if (droid instanceof BattleDroid) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return The {@link Integer} sum of energy of all droids in the current team
	 */
	public Integer sumEnergy() {
		Integer sum = 0;
		for (SimpleDroid currentDroid : teamList) {
			sum += currentDroid.getEnergy();
		}
		return sum;
	}

	public Integer sumBattleAndChargeTeamEnergy() {
		Integer sum = 0;
		for (SimpleDroid currentDroid : teamList) {
			if ((currentDroid instanceof BattleDroid) || (currentDroid instanceof ChargeEnergyDroid))
				sum += currentDroid.getEnergy();
		}
		return sum;
	}

	public void deleteTeamMember(SimpleDroid droidToDelete) {
		int indexOfDroidToDelete = teamList.indexOf(droidToDelete);
		teamList.remove(indexOfDroidToDelete);
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
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
