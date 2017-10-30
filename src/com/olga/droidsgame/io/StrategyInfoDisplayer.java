package com.olga.droidsgame.io;

import org.apache.log4j.Logger;

import com.olga.droidsgame.battle.Battle;
import com.olga.droidsgame.battle.Team;
import com.olga.droidsgame.battle.TeamListFiller;

public class StrategyInfoDisplayer {
	private final Keyboard readerFromKeyboard;
	private static final Logger LOG = Logger.getLogger(StrategyInfoDisplayer.class);
	private Battle battle;

	public StrategyInfoDisplayer(Battle battle) {
		readerFromKeyboard = new Keyboard();
	}

	public void displayStrategyChoiseInformation(Team team) {
		LOG.info(String.format("Choose STRATEGY: (1) - Random;  (2) - Alternately"));
		LOG.info(String.format("Strategy for team [ %s ]", team.getTeamName()));
	}

}
