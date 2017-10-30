package com.epam.lab.task2.droids;

import com.epam.lab.task2.constants.DriodConstants;

public class DefenderRepairDroid extends SimpleRepairDroid implements DefenderDroid{
	public DefenderRepairDroid(){
		setBasicParameters();
	}
	
	@Override
		public void defenceItself(SimpleDroid droidAttacker) {
		absorbEnergy(droidAttacker);
		droidAttacker.setEnergy(0);		
	}
	private void absorbEnergy(SimpleDroid droidAttacker) {
		setEnergy(getEnergy()+droidAttacker.getEnergy());
	}
	private void setBasicParameters() {
		setMaxEnergy(DriodConstants.MAX_BEGIN_DEFENDER_REPAIR_DROID_ENERGY);
		setMaxHealth(DriodConstants.MAX_BEGIN_DEFENDER_REPAIR_DROID_HEALTH);
		setEnergy(DriodConstants.MAX_BEGIN_DEFENDER_REPAIR_DROID_ENERGY);
		setHealth(DriodConstants.MAX_BEGIN_DEFENDER_REPAIR_DROID_HEALTH);
	}

}
