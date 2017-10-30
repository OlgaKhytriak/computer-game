package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

public class DefenderRepairDroid extends SimpleRepairDroid implements RepairDroid, DefenderDroid{
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
