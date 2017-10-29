package com.olga.droidsgame.droids;

public class SuperDoctor extends SimpleRepairDroid implements ChargeEnergyDroid, RepairDroid{
	private final SimpleChargeEnergyDroid charger;
	public SuperDoctor() {
		charger=new SimpleChargeEnergyDroid();
}
	@Override
	public void charge(SimpleDroid injuredDroid) {
		charger.setEnergy(getEnergy());
		charger.charge(injuredDroid); 
		setEnergy(charger.getEnergy());
		
	}
// Вміє заряджати та лікувати
}
