package com.epam.lab.task2;

import org.apache.log4j.Logger;

import com.epam.lab.task2.battle.Battle;

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
		LOG.info("GAME OVER");
	}

	public void allActions() {
		Battle battle = new Battle();
		battle.startBattle();
	}
}
