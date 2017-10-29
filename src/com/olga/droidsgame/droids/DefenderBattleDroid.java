package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DroidType;

public class DefenderBattleDroid extends SimpleBattleDroid implements DefenderDroid, BellicoseDroid {
	
	public DefenderBattleDroid() {
		setDroidType(DroidType.BATTLE_DEFENDER_DROID);
	}


@Override
public void defenceItself(SimpleDroid droidAttacker) {
	Integer attackerEnergy=droidAttacker.getEnergy();
	droidAttacker.setEnergy(attackerEnergy/2);
	
}



}
