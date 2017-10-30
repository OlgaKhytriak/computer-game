package com.epam.lab.task2.battle;

import org.apache.log4j.Logger;

import com.epam.lab.task2.io.Keyboard;
import com.epam.lab.task2.io.StrategyInfoDisplayer;
import com.epam.lab.task2.io.TeamInfoDisplayer;

public class StrategyChooser {
	private final Keyboard readerFromKeyboard;
	private StrategyInfoDisplayer strategyInfoDisplayer;
	private static final Logger LOG = Logger.getLogger(TeamListFiller.class);
	private Battle battle;
	
	public StrategyChooser(Battle battle) {
		readerFromKeyboard = new Keyboard();
		strategyInfoDisplayer=new StrategyInfoDisplayer(battle);
		
	}
	public int chooseStrategy(Team team) {
		strategyInfoDisplayer.displayStrategyChoiseInformation(team);
		Integer strategy=readerFromKeyboard.readIntegerFromKeyboard("");
		return strategy;
		
	}
}
