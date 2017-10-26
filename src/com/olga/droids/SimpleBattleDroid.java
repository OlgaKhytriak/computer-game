package com.olga.droids;

import com.olga.additional.PrinterOfDriodInformation;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {
	private final PrinterOfDriodInformation droidInfoPrinter;

	public SimpleBattleDroid() {
		Integer h = BASIC_VALUE * 1;
		Integer en = BASIC_VALUE * 1;
		setMaxHealth(h);
		setMaxEnergy(en);
		setEnergy(en);
		setHealth(h);
		setDroidType(DroidType.SIMPLE_BATTLE_DROID);
		setAlive(true);
		// setDroidInfoPrinter(new PrintDriodInformation(this));
		droidInfoPrinter = new PrinterOfDriodInformation(this);
	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		Integer energy = getEnergy();
		if (energy > 0) {
			while ((enemyDroidHealth > 0) && (energy > 0)) {
				enemyDroidHealth--;
				energy--;
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
