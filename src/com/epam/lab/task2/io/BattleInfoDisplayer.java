package com.epam.lab.task2.io;

import org.apache.log4j.Logger;

import com.epam.lab.task2.battle.Battle;
import com.epam.lab.task2.battle.Team;

public class BattleInfoDisplayer {
	private static final Logger LOG = Logger.getLogger(BattleInfoDisplayer.class);
	private TeamInfoDisplayer teamInfo;
	private Battle battle;

	public BattleInfoDisplayer(Battle battle) {
		setBattle(battle);
		teamInfo = new TeamInfoDisplayer();
	}

	
	public void displayBouthTeamsInformation() {
		teamInfo.printTeamList(battle.getTeam1());
		teamInfo.printTeamList(battle.getTeam2());
	}

	public void displayTurnInformation() {
		Integer turn = battle.getTurn();
		LOG.info(String.format(" --- TURN ----- � %s", turn));
		displayBouthTeamsInformation();
	}
	public void displayNoEnergy() {
		LOG.info("Teams have no energy to fight or charge");
		LOG.info("Current information about teams:");
		displayBouthTeamsInformation();
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public void dispalayVinnerInfo(Team team1) {
			LOG.info(String.format("Team -- [ %s ] -- !!  VIN !! the game",team1.getTeamName()));
		
			
	}

	public void dispalayDeadHaetInfo() {
		LOG.info("!!!   Dead heat  !!!");
		
		
	}

}
