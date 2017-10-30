package com.epam.lab.task2.io;

import org.apache.log4j.Logger;

import com.epam.lab.task2.StartGame;
import com.epam.lab.task2.battle.Team;
import com.epam.lab.task2.droids.SimpleDroid;

public class TeamInfoDisplayer { 
	private DriodInfoDisplayer driodInfoDisplayer;
	private static final Logger LOG = Logger.getLogger(TeamInfoDisplayer.class);
	public TeamInfoDisplayer() {
		driodInfoDisplayer = new DriodInfoDisplayer();
	}

	public void printInfoForTeamFill(Team team) {
		LOG.info(String.format("Team [ %s ] has [%s] members.", team.getTeamName(),team.getBeginNumberOfTeamMembers()));
		LOG.info("Choice types of droids:");
		LOG.info(" (1) - RepairDroid; (2) - BattleDroid; (3) - SuperDroid;    (4) - ChargingDroid; (5) - DefenderBattleDroid");
		LOG.info(" (6) - Droideka;    (7) - SuperDoctor; (8) - DefenderRepairDroid; (9) - SuperPowerfullDroid; (10) - BattleLazerDroid");
	}

	public void printTeamList(Team team) {
		if (team.getTeamList().isEmpty()) {
			LOG.info(String.format("The team [ %s ] is empty", team.getTeamName()));
		}
		LOG.info(String.format("[ %s ]",team.getTeamName()) );
		int i = 0;
		for (SimpleDroid currentDroid : team.getTeamList()) {
			i++;
			driodInfoDisplayer.printAllInformation(currentDroid);
		}
	}

}
