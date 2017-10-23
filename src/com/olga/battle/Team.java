package com.olga.battle;

import java.util.ArrayList;
import java.util.List;

import com.olga.droids.Droid;
import com.olga.droids.SimpleBattleDroid;
import com.olga.droids.SimpleRepairDroid;
import com.olga.droids.SuperDroid;

public class Team {
	private Integer beginNumberOfTeamMembers;
	private Integer currentNumberOfTeamMembers;
	private ArrayList<Droid> teamList;
	private final Keyboard readerFromKeyboard;

	public Droid findFirstInjuredDroid() {
		//boolean weFound = false;
		for (int i = 0; i < teamList.size(); i++) {
			if (teamList.get(i).getHealth()<teamList.get(i).getMaxHealth()) {
				//weFound = true;
				return teamList.get(i);
			}

		}
		return null;
	}

	public Integer sumEnergy() {
		Integer sum = 0;
		for (Droid currentDroid : teamList) {
			sum += currentDroid.getEnergy();
		}
		// System.out.println("Sum energy="+sum);
		return sum;
	}

	public void printTeamList(String s) {
		System.out.print(s);
		if (getTeamList().isEmpty()) {
			System.out.println("The team is empty");
		}
		int i = 0;
		for (Droid currentDroid : teamList) {
			i++;
			System.out.print("[" + i + "] " + currentDroid.getDroidType() + " (health=" + currentDroid.getHealth()
					+ "; energy=" + currentDroid.getEnergy() + ").  ");
		}
		System.out.println("  ");
	}

	public void deleteElement(Droid DroidToDelete) {
		int indexOfDroidToDelete = teamList.indexOf(DroidToDelete);
		teamList.remove(indexOfDroidToDelete);
	}

	public void fillInTeamList() {
		System.out.println("Team has " + beginNumberOfTeamMembers + " members");
		System.out.println("Chois types of drids: 1- RepairDroid; 2- BattleDroid; 3- SuperDroid");
		Droid currentDroid = null;
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
	Team(Integer numberOfTeamMembers) { // Constructor with number of team's members
		setNumberOfTeamMembers(numberOfTeamMembers);
		setTeamList(new ArrayList<Droid>(numberOfTeamMembers));
		readerFromKeyboard = new Keyboard();
	}

	public Integer getNumberOfTeamMembers() {
		return beginNumberOfTeamMembers;
	}

	public void setNumberOfTeamMembers(Integer beginNumberOfTeamMembers) {
		this.beginNumberOfTeamMembers = beginNumberOfTeamMembers;
	}

	public ArrayList<Droid> getTeamList() {
		return teamList;
	}

	public void setTeamList(ArrayList<Droid> teamList) {
		this.teamList = teamList;
	}

	public Integer getCurrentNumberOfTeamMembers() {
		return teamList.size();
	}

	public void setCurrentNumberOfTeamMembers(Integer currentNumberOfTeamMembers) {
		this.currentNumberOfTeamMembers = currentNumberOfTeamMembers;
	}
}
