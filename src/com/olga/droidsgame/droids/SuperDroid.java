package com.olga.droidsgame.droids;

/**
 * @author okhytadmin
 *
 */
public class SuperDroid extends SimpleDroid implements RepairDroid, BattleDroid {
	private static final Integer maxEnergy = BASIC_VALUE * 3;
	private static final Integer maxHealth = BASIC_VALUE * 3;
	private final SimpleRepairDroid doctor; // Create doctor
	private final  SimpleBattleDroid fighter; // Create fighter

	public SuperDroid() { 
		super(maxEnergy,maxHealth);
		setDroidType(DroidType.SUPER_DROID);
		doctor=new SimpleRepairDroid();
		fighter=new SimpleBattleDroid(); 
	}
	public void repair(SimpleDroid injuredDroid) {
		doctor.setEnergy(getEnergy());// Sent points of SuperDroid's energy to doctor
		doctor.repair(injuredDroid);  // Doctor treats injuredDroid
		setEnergy(doctor.getEnergy());// SuperDroid gets residual energy
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		fighter.setEnergy(getEnergy());
		fighter.shoot(enemyDroid);
		setEnergy(fighter.getEnergy());
		
	}

}
