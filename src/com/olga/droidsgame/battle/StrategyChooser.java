package com.olga.droidsgame.battle;

import org.apache.log4j.Logger;

import com.olga.droidsgame.io.Keyboard;
import com.olga.droidsgame.io.StrategyInfoDisplayer;
import com.olga.droidsgame.io.TeamInfoDisplayer;

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
