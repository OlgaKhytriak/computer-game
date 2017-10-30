package com.epam.lab.task2.droids;

import com.epam.lab.task2.constants.DriodConstants;

public class Droideka extends DefenderBattleDroid implements DefenderDroid{


	
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

