package droids;

public class SimpleBattleDroid extends Droid implements BattleDroid{

	public SimpleBattleDroid() {
		Integer h = BASIC_VALUE * 1;
		Integer en = BASIC_VALUE * 1;
		setMaxHealth(h);
		setEnergy(en);
		setEnergy(en);
		setHealth(h);
		setDroidType(DroidType.SIMPLE_BATTLE_DROID);
		setAlive(true);
		
	}

	@Override
	public void shoot(Droid enemyDroid) {
		Integer enemyDroidHealth = enemyDroid.getHealth();
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
				
		if (0==enemyDroid.getHealth()) {enemyDroid.setAlive(false);}
}

}
