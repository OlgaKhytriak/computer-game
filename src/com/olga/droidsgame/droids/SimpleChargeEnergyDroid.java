package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

public class SimpleChargeEnergyDroid extends SimpleDroid implements ChargeEnergyDroid {
	public SimpleChargeEnergyDroid() {
		super(DriodConstants.MAX_BEGIN_CHARGE_DROID_ENERGY, DriodConstants.MAX_BEGIN_CHARGE_DROID_HEALTH);
	}

	public void charge(SimpleDroid injuredDroid) {
		Integer injuredDroidEnergy = injuredDroid.getEnergy();
		Integer maxEnergy = injuredDroid.getMaxEnergy();
		Integer energy = getEnergy();
		while ((injuredDroidEnergy < maxEnergy) && (energy > 0)) {
			injuredDroidEnergy++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setEnergy(injuredDroidEnergy);
	}
}
