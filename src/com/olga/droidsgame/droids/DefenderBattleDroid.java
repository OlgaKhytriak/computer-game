package com.olga.droidsgame.droids;

public class DefenderBattleDroid extends SimpleBattleDroid implements DefenderDroid, BellicoseDroid {
	
	public DefenderBattleDroid() {
		
	}
@Override
public void defenceItself(SimpleDroid droidAttacker) {
	Integer attackerEnergy=droidAttacker.getEnergy();
	droidAttacker.setEnergy(attackerEnergy/2);	
}
}
