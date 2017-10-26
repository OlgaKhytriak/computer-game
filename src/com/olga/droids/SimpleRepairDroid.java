package com.olga.droids;

/**
 * @author okhytadmin
 *
 */
public class SimpleRepairDroid extends SimpleDroid implements RepairDroid {
	private static final Integer maxEnergy = BASIC_VALUE * 2;
	private static final Integer maxHealth = BASIC_VALUE * 2;

	public SimpleRepairDroid() {
		super(maxEnergy, maxHealth);
		setDroidType(DroidType.SIMPLE_REPAIR_DROID);
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
