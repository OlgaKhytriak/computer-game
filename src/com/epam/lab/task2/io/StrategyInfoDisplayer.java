package com.epam.lab.task2.io;

import org.apache.log4j.Logger;

import com.epam.lab.task2.battle.Battle;
import com.epam.lab.task2.battle.Team;
import com.epam.lab.task2.battle.TeamListFiller;

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
