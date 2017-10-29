package com.olga.droidsgame.droids;

import com.olga.droidsgame.constants.DriodConstants;

public class Droideka extends DefenderBattleDroid implements DefenderDroid, BellicoseDroid{


	
	public Droideka() {
		// !!! Написати
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
		
	}

