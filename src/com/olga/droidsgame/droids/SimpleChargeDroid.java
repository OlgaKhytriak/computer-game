package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;
import com.olga.droidsgame.constants.DroidType;

public class SimpleChargeDroid extends SimpleDroid implements ChargeDroid{
	public SimpleChargeDroid() {
		super(DriodConstants.MAX_BEGIN_CHARGE_DROID_ENERGY, DriodConstants.MAX_BEGIN_CHARGE_DROID_HEALTH);
		setDroidType(DroidType.SIMPLE_CHARGE_DROID);
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
