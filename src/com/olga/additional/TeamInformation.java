package com.olga.additional;

import com.olga.battle.Team;
import com.olga.droids.SimpleDroid;

public class TeamInformation {
	private Team team;
	private SimpleDroid droid;

	public TeamInformation(Team team) {
		setTeam(team);
	}
	
	public void printInfoForTeamFill() {
		System.out.println("Team"+team.getTeamName()+" has" + team.getBeginNumberOfTeamMembers() + " members.");
		System.out.println("Chois types of drids: 1- RepairDroid; 2- BattleDroid; 3- SuperDroid");

	}
	
	public void printTeamList() {
		if (team.getTeamList().isEmpty()) {
			System.out.println("The team is empty");
		}
		System.out.println(team.getTeamName());
		int i = 0;
		for (SimpleDroid currentDroid : team.getTeamList()) {
			i++;
			System.out.print("[" + i + "] " + currentDroid.getDroidType() + " (health=" + currentDroid.getHealth()
					+ "; energy=" + currentDroid.getEnergy() + ").  ");
		}
		System.out.println("  ");
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
