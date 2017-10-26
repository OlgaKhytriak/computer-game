package com.olga.droids;

import com.olga.additional.PrinterOfDriodInformation;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {
	private static final Integer maxEnergy = BASIC_VALUE * 2;
	private static final Integer maxHealth = BASIC_VALUE * 2;
	private final PrinterOfDriodInformation droidInfoPrinter;

	public SimpleBattleDroid() {
		super(maxEnergy,maxHealth);
		setDroidType(DroidType.SIMPLE_BATTLE_DROID);
		droidInfoPrinter = new PrinterOfDriodInformation(this);
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		Integer energy = getEnergy();
		if (energy > 0) {
			while ((enemyDroidHealth > 0) && (energy > 0)) {//ALL energy is used to reduce heals points.
				enemyDroidHealth--;
				energy--; //
			}
			enemyDroid.setHealth(enemyDroidHealth);
			setEnergy(energy);
		} else {
			droidInfoPrinter.printEnergyInformation();
		}
	}
	
	

	public PrinterOfDriodInformation getDroidInfoPrinter() {
		return droidInfoPrinter;
	}

}
