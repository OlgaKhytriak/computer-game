package droids;

/**
 * @author okhytadmin
 *
 */
public class Droideka extends Droid implements BattleDroid {
	private static final double EFFECTIVENESS_COEFFICIENT=2;
	public static final Integer MAX_HEALTH=(int) (BASIC_HEALTH*EFFECTIVENESS_COEFFICIENT);
	public static final Integer MAX_ENERGY=(int) (BASIC_ENERGY*EFFECTIVENESS_COEFFICIENT);
	public Droideka() {
		Integer h=BASIC_VALUE*2;
		setMaxHealth(h);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see droids.BattleDroid#shoot()
	 */
	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}

	/*
	 * If your energy >=1 you can walk. When you reach desired position your energy
	 * reduces on 1 point. If your energy <1 you can't walk. Parameters are the
	 * coordinates x, y of the game's field into which the droid shoul be moved
	 */
	@Override
	public void move(Integer x, Integer y) {
		if (getEnergy() >= 2) {
			setPositionX(x);
			setPositionY(y);
			setEnergy(getEnergy() - 2);
		} else {
			System.out.println("You dont have enough energy to move");
			return;
		}

	}

}
