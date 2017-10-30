package com.epam.lab.task2.droids;

import com.epam.lab.task2.constants.DriodConstants;

public class SuperPowerfullDroid extends SuperDroid implements DefenderDroid,ChargeEnergyDroid{
	
	private final SimpleChargeEnergyDroid charger;
	public SuperPowerfullDroid(){
		charger=new SimpleChargeEnergyDroid();
		setBasicParameters();
	}

	@Override
	public void charge(SimpleDroid injuredDroid) {
		charger.setEnergy(getEnergy());
		charger.charge(injuredDroid); 
		setEnergy(charger.getEnergy());
		
	}
	@Override
	public void defenceItself(SimpleDroid droidAttacker) {
		Integer attackerEnergy=droidAttacker.getEnergy();
		droidAttacker.setEnergy(0);	
		
	}
	private void setBasicParameters() {
		setMaxEnergy(DriodConstants.MAX_BEGIN_SUPER_POWERFULL_DROID_ENERGY);
		setMaxHealth(DriodConstants.MAX_BEGIN_SUPER_POWERFULL_DROID_HEALTH);
		setEnergy(DriodConstants.MAX_BEGIN_SUPER_POWERFULL_DROID_ENERGY);
		setHealth(DriodConstants.MAX_BEGIN_SUPER_POWERFULL_DROID_HEALTH);
	}
}
