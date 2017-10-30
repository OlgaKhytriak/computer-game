package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

public class SuperDoctor extends SimpleRepairDroid implements ChargeEnergyDroid, RepairDroid{
	private final SimpleChargeEnergyDroid charger;
	public SuperDoctor() {
		charger=new SimpleChargeEnergyDroid();
		setBasicParameters();
}
	@Override
	public void charge(SimpleDroid injuredDroid) {
		charger.setEnergy(getEnergy());
		charger.charge(injuredDroid); 
		setEnergy(charger.getEnergy());
		
	}

	private void setBasicParameters() {
		setMaxEnergy(DriodConstants.MAX_BEGIN_SUPER_DOCTOR_ENERGY);
		setMaxHealth(DriodConstants.MAX_BEGIN_SUPER_DOCTOR_HEALTH);
		setEnergy(DriodConstants.MAX_BEGIN_SUPER_DOCTOR_ENERGY);
		setHealth(DriodConstants.MAX_BEGIN_SUPER_DOCTOR_HEALTH);
	}
}
