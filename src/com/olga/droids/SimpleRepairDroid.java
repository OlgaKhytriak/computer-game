package com.olga.droids;

/**
 * @author okhytadmin
 *
 */
public class SimpleRepairDroid extends SimpleDroid implements RepairDroid {
	private static final Integer maxEnergy = BASIC_VALUE * 2;
	private static final Integer maxHealth = BASIC_VALUE * 2;
	
	public SimpleRepairDroid() {  
		super(maxEnergy,maxHealth);
		setDroidType(DroidType.SIMPLE_REPAIR_DROID);
	}
	/*
	 * SimpleRepairDroid treats injuredDroid by conversation ALL its own energy into
	 * the injuredDroid's life points
	 */
	public void repair(SimpleDroid injuredDroid) {
		Integer injuredDroidHealth = injuredDroid.getHealth();
		Integer maxHelth = injuredDroid.getMaxHealth();
		Integer energy = getEnergy();
		//if (injuredDroidHealth == maxHelth) {
		//	System.out.println("You are not enjured. You dont need repair!");
		//	return;
		//}
		//if (energy > 0) {
			//if (injuredDroidHealth < maxHelth) {
				while ((injuredDroidHealth < maxHelth) && (energy > 0)) {
					injuredDroidHealth++;
					energy--;
				}
				//System.out.println("The tåreatment is done successfull !");
				//if (injuredDroidHealth < maxHelth)
					//System.out.println("But it is not full");
				//System.out.println("Health of injureddroid = " + injuredDroidHealth);
				//System.out.println("Energy of doctor = " + energy);
				setEnergy(energy);
				injuredDroid.setHealth(injuredDroidHealth);
			//}
		//} else
			//System.out.println("You have no energy for treat!");
	}


}
