package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DroidType;
import com.olga.droidsgame.constants.DriodConstants;
import com.olga.droidsgame.io.DriodInfoDisplayer;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {
	private final DriodInfoDisplayer droidInfo;
	

	public SimpleBattleDroid() {
		super(DriodConstants.MAX_BEGIN_BATTLE_DROID_ENERGY, DriodConstants.MAX_BEGIN_BATTLE_DROID_HEALTH);
		setDroidType(DroidType.SIMPLE_BATTLE_DROID);
		droidInfo = new DriodInfoDisplayer(this);
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		Integer energy = getEnergy();
		while ((enemyDroidHealth > 0) && (energy > 0)) {// ALL energy is used to reduce heals points.
			enemyDroidHealth--;
			energy--;
		}
		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
		droidInfo.printEnergyInformation();
	}

	public DriodInfoDisplayer getDroidInfoPrinter() {
		return droidInfo;
	}
}
