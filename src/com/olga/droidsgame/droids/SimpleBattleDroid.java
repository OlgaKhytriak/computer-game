package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;
import com.olga.droidsgame.io.DriodInfoDisplayer;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid, BellicoseDroid {

	public SimpleBattleDroid() {
		super(DriodConstants.MAX_BEGIN_BATTLE_DROID_ENERGY, DriodConstants.MAX_BEGIN_BATTLE_DROID_HEALTH);
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		if ((enemyDroid instanceof DefenderDroid)) {
			((DefenderDroid) enemyDroid).defenceItself(this);
		}
		Integer energy = getEnergy();
		while ((enemyDroidHealth > 0) && (energy > 0)) {// ALL energy is used to reduce heals points.
			enemyDroidHealth--;
			energy--;
		}
		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
	}

}
