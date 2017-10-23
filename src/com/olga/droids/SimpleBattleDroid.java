package com.olga.droids;

public class SimpleBattleDroid extends SimpleDroid implements BattleDroid {

	public SimpleBattleDroid() {
		Integer h = BASIC_VALUE * 1;
		Integer en = BASIC_VALUE * 1;
		setMaxHealth(h);
		setMaxEnergy(en);
		setEnergy(en);
		setHealth(h);
		setDroidType(DroidType.SIMPLE_BATTLE_DROID);
		setAlive(true);

	}

	@Override
	public void shoot(SimpleDroid enemyDroid) {
		/*System.out.print("BEFORE SHOOT. Shooted droid info. ");
		printInfo();
		System.out.print("BEFORE SHOOT. Wounded droid info.");
		enemyDroid.printInfo();
		*/
		Integer enemyDroidHealth = enemyDroid.getHealth();
		Integer energy = getEnergy();

		if (0 == energy) {
			System.out.println("You have no energy to shoot!");
			return;
		}
		/*if (energy > 0) {
			if (enemyDroidHealth >= energy) {

				while ((enemyDroidHealth > 0) && (energy > 0)) {
					enemyDroidHealth--;
					energy--;
				}
			} else {
				//System.out.println("");
				enemyDroid.setHealth(0);
				setEnergy(energy - enemyDroidHealth);
			}
		}*/
		if (energy > 0) {
			while ((enemyDroidHealth > 0) && (energy > 0)) {
				enemyDroidHealth--;
				energy--;
			enemyDroid.setHealth(0);
			setEnergy(energy - enemyDroidHealth);
		}
	}

		enemyDroid.setHealth(enemyDroidHealth);
		setEnergy(energy);
		if (0 == enemyDroid.getHealth()) {
			enemyDroid.setAlive(false);
		}
		/*System.out.print("AFTER SHOOT. Shooted droid info. ");
		printInfo();
		System.out.print("AFTER SHOOT. Wounded droid info.");
		enemyDroid.printInfo();
		*/
	}

}
