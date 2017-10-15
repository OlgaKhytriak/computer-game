package droids;

public class SimpleBattleDroid extends Droid implements BattleDroid{

	public SimpleBattleDroid() {
		Integer h = BASIC_VALUE * 1;
		Integer en = BASIC_VALUE * 1;
		setMaxHealth(h);
		setEnergy(en);
		setEnergy(en);
		setHealth(h);
		
	}

	@Override
	public void shoot(Droid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
		//Integer maxHelth = injuredDroid.getMaxHealth();
		Integer energy = getEnergy();
		if (0==energy) {
			System.out.println("You have no energy to shoot!");
			return;
		}
		if (energy > 0) {
			if (enemyDroidHealth >= energy) {
				while ((enemyDroidHealth > 0) & (energy > 0)) {
					enemyDroidHealth--;
					energy--;
				}	
			}
			else  {
				enemyDroid.setHealth(0);
				setEnergy(energy-enemyDroidHealth);
				}
		}
				
		/*
				
				if (injuredDroidHealth < maxHelth)
					System.out.println("But it is not full");
				System.out.println("Health of injureddroid = " + injuredDroidHealth);
				System.out.println("Energy of doctor = " + energy);
				setEnergy(energy);
				injuredDroid.setHealth(injuredDroidHealth);
			}
		}}*/

}

}
