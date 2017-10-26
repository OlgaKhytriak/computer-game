package com.olga.droids;

import com.olga.additional.DriodInformation;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {
	private static final Integer maxEnergy = BASIC_VALUE * 2;
	private static final Integer maxHealth = BASIC_VALUE * 2;
	private final DriodInformation droidInfo;

	public SimpleBattleDroid() {
		super(maxEnergy,maxHealth);
		setDroidType(DroidType.SIMPLE_BATTLE_DROID);
		droidInfo = new DriodInformation(this);
	}
	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		Integer energy = getEnergy();
				while ((enemyDroidHealth > 0) && (energy > 0)) {//ALL energy is used to reduce heals points.
				enemyDroidHealth--;
				energy--; 
			}
			enemyDroid.setHealth(enemyDroidHealth);
			setEnergy(energy);
			droidInfo.printEnergyInformation();	
	}
	public DriodInformation getDroidInfoPrinter() {
		return droidInfo;
	}
}
