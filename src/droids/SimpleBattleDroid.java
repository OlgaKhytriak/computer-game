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
		// TODO Auto-generated method stub
		
	}

}
