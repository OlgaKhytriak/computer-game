package com.olga.droidsgame.droids;

public class SuperPowerfullDroid extends SuperDroid implements BellicoseDroid,DefenderDroid,RepairDroid,ChargeEnergyDroid{
	
	private final SimpleChargeEnergyDroid charger;
	public SuperPowerfullDroid(){
		charger=new SimpleChargeEnergyDroid();
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
}
