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

	
	/*
	 * If your energy >=3 you can walk. When you reach desired position your energy
	 * reduces on 3 point. If your energy <3 you can't walk. Parameters are the
	 * coordinates x, y of the game's field into which the droid shoul be moved
	 */
	@Override
	public void move(Integer x, Integer y) {
		if (getEnergy() >= 3) {
			setPositionX(x);
			setPositionY(y);
			setEnergy(getEnergy() - 3);
		} else {
			System.out.println("You dont have enough energy to move");
			return;
		}

	}


	@Override
	public void shoot(Droid enemyDroid) {
		// TODO Auto-generated method stub
		
	}

}
