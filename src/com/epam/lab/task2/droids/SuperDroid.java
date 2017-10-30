package com.epam.lab.task2.droids;

import com.epam.lab.task2.constants.DriodConstants;

/**
 * @author okhytadmin
 *
 */
public class SuperDroid extends SimpleDroid implements RepairDroid, BattleDroid  {
	private final SimpleRepairDroid doctor;
	private final SimpleBattleDroid fighter;
	
	public SuperDroid() {
		super(DriodConstants.MAX_BEGIN_SUPER_DROID_ENERGY, DriodConstants.MAX_BEGIN_SUPER_DROID_HEALTH);
		doctor = new SimpleRepairDroid();
		fighter = new SimpleBattleDroid();
	}

	public void repair(SimpleDroid injuredDroid) {
		doctor.setEnergy(getEnergy());// Sent points of SuperDroid's energy to doctor
		doctor.repair(injuredDroid); // Doctor treats injuredDroid
		setEnergy(doctor.getEnergy());// SuperDroid gets residual energy
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		fighter.setEnergy(getEnergy());
		fighter.shoot(enemyDroid);
		setEnergy(fighter.getEnergy());

	}

}
