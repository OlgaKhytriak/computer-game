package com.olga.droidsgame.droids;

public class DefenderRepairDroid extends SimpleRepairDroid implements RepairDroid, DefenderDroid{

	@Override
	
	public void defenceItself(SimpleDroid droidAttacker) {
		absorbEnergy(droidAttacker);
		droidAttacker.setEnergy(0);		
	}
	private void absorbEnergy(SimpleDroid droidAttacker) {
		setEnergy(getEnergy()+droidAttacker.getEnergy());
	}
// поглинає  всю енергію того хто в нього стріляв і додає її до очків своїє енергії. 
	//Не вміє битися але вміє лікувати
}
