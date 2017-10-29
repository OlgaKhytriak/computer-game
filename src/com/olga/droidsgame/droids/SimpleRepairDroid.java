package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

/**
 * @author okhytadmin
 *
 */
public class SimpleRepairDroid extends SimpleDroid implements RepairDroid {

	public SimpleRepairDroid() {
		super(DriodConstants.MAX_BEGIN_REPAIR_DROID_ENERGY, DriodConstants.MAX_BEGIN_REPAIR_DROID_HEALTH);
		}

	public void repair(SimpleDroid injuredDroid) {
		Integer injuredDroidHealth = injuredDroid.getHealth();
		Integer maxHelth = injuredDroid.getMaxHealth();
		Integer energy = getEnergy();
		while ((injuredDroidHealth < maxHelth) && (energy > 0)) {
			injuredDroidHealth++;
			energy--;
		}
		setEnergy(energy);
		injuredDroid.setHealth(injuredDroidHealth);
	}

}
