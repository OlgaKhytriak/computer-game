package com.olga.droidsgame.droids;

public class BattleLazerDroid extends SimpleBattleDroid implements BellicoseDroid{
// Сильний напад. Подвоює енергію нападу
	
	private final SimpleBattleDroid fighter;
	public BattleLazerDroid() {
	fighter = new SimpleBattleDroid();}
	
	
		@Override
		public void shoot(SimpleDroid enemyDroid) {
			fighter.setEnergy(getEnergy()*2);
			fighter.shoot(enemyDroid);
			setEnergy(fighter.getEnergy()/2);
		}
		
	}

