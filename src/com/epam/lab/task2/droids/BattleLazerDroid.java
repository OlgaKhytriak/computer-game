package com.epam.lab.task2.droids;

import com.epam.lab.task2.constants.DriodConstants;

public class BattleLazerDroid extends SimpleBattleDroid{

	private final SimpleBattleDroid fighter;
	
	public BattleLazerDroid() {
		setBasicParameters();
		fighter = new SimpleBattleDroid();}
		
		@Override
		public void shoot(SimpleDroid enemyDroid) {
			fighter.setEnergy(getEnergy()*2);
			fighter.shoot(enemyDroid);
			setEnergy(fighter.getEnergy()/2);
		}
		
		private void setBasicParameters() {
			setMaxEnergy(DriodConstants.MAX_BEGIN_BATTLE_LAZER_DROID_ENERGY);
			setMaxHealth(DriodConstants.MAX_BEGIN_BATTLE_LAZER_DROID_HEALTH);
			setEnergy(DriodConstants.MAX_BEGIN_BATTLE_LAZER_DROID_ENERGY);
			setHealth(DriodConstants.MAX_BEGIN_BATTLE_LAZER_DROID_HEALTH);
		}
	}

