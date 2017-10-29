package com.olga.droidsgame;

import org.apache.log4j.Logger;
import com.olga.droidsgame.battle.Battle;

/**
 * @author okhytadmin
 *
 */
public class StartGame {
	private static final Logger LOG = Logger.getLogger(StartGame.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("START GAME");
		new StartGame().allActions();
	}

	public void allActions() {
		Battle battle = new Battle();
		battle.startBattle();
	}
}
