package droids;

/**
 * @author okhytadmin
 *
 */
public class SuperDroid extends Droid implements RepairDroid, BattleDroid {
	private final SimpleRepairDroid doctor; // Create doctor
	private final  SimpleBattleDroid fighter;

	public SuperDroid() {
		Integer h = BASIC_VALUE * 3;
		Integer en = BASIC_VALUE * 3;
		setMaxHealth(h);
		setMaxHealth(h);
		setEnergy(en);
		setEnergy(en);
		setHealth(h);
		 doctor=new SimpleRepairDroid();
		 fighter=new SimpleBattleDroid();
	}

	public void repair(Droid injuredDroid) {
		doctor.setEnergy(getEnergy());// Sent points of SuperDroid's energy to doctor
		doctor.repair(injuredDroid);  // Doctor treats injuredDroid
		setEnergy(doctor.getEnergy());// SuperDroid gets residual energy

	}

	/*
	 * If your energy >=1 you can walk. When you reach desired position your energy
	 * reduces on 1 point. If your energy <1 you can't walk. Parameters are the
	 * coordinates x, y of the game's field into which the droid will be moved
	 */
	@Override
	public void move(Integer x, Integer y) {
		if (getEnergy() >= 1) {
			setPositionX(x);
			setPositionY(y);
			setEnergy(getEnergy() - 1);
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
