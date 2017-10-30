package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

public class DefenderBattleDroid extends SimpleBattleDroid implements DefenderDroid, BellicoseDroid {
	
	public DefenderBattleDroid() {
		setBasicParameters();
	}
@Override
public void defenceItself(SimpleDroid droidAttacker) {
	Integer attackerEnergy=droidAttacker.getEnergy();
	droidAttacker.setEnergy(attackerEnergy/2);	
}

private void setBasicParameters() {
	setMaxEnergy(DriodConstants.MAX_BEGIN_DEFENDER_BETTLE_DROID_ENERGY);
	setMaxHealth(DriodConstants.MAX_BEGIN_DEFENDER_BETTLE_DROID_HEALTH);
	setEnergy(DriodConstants.MAX_BEGIN_DEFENDER_BETTLE_DROID_ENERGY);
	setHealth(DriodConstants.MAX_BEGIN_DEFENDER_BETTLE_DROID_HEALTH);
}
}
