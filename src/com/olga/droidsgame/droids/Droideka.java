package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

public class Droideka extends DefenderBattleDroid implements DefenderDroid, BattleDroid{


	
	public Droideka() {
		setBasicParameters();
		}
	@Override
	public void defenceItself(SimpleDroid droidAttacker) {
		absorbEnergy(droidAttacker);
		droidAttacker.setEnergy(0);	
		shoot(droidAttacker);
	}
	private void absorbEnergy(SimpleDroid droidAttacker) {
		setEnergy(getEnergy()+droidAttacker.getEnergy());
	}
	private void setBasicParameters() {
		setMaxEnergy(DriodConstants.MAX_BEGIN_DROIDEKA_DROID_ENERGY);
		setMaxHealth(DriodConstants.MAX_BEGIN_DROIDEKA_DROID_HEALTH);
		setEnergy(DriodConstants.MAX_BEGIN_DROIDEKA_DROID_ENERGY);
		setHealth(DriodConstants.MAX_BEGIN_DROIDEKA_DROID_HEALTH);
	}
		
	}

