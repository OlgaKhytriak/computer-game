package com.olga.droidsgame.io;

import com.olga.droidsgame.battle.Team;
import com.olga.droidsgame.droids.SimpleDroid;

public class TeamInfoDisplayer { /// +++
	private DriodInfoDisplayer driodInfoDisplayer;

	public TeamInfoDisplayer() {
		driodInfoDisplayer = new DriodInfoDisplayer();
	}

	public void printInfoForTeamFill(Team team) {
		System.out.println("Team" + team.getTeamName() + " has" + team.getBeginNumberOfTeamMembers() + " members.");
		System.out.println(
				"Chois types of drids: 1- RepairDroid; 2- BattleDroid; 3- SuperDroid; 4- ChargingDroid; 5 - DefenderBattleDroid");
	}

	public void printTeamList(Team team) {
		if (team.getTeamList().isEmpty()) {
			System.out.println("The team is empty");
		}
		System.out.println(team.getTeamName());
		int i = 0;
		for (SimpleDroid currentDroid : team.getTeamList()) {
			i++;
			driodInfoDisplayer.printAllInformation(currentDroid);
		}
		System.out.println("  ");
	}

}
