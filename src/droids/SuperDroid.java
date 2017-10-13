package droids;

/**
 * @author okhytadmin
 *
 */
public class SuperDroid extends Droid implements RepairDroid {

	public SuperDroid() {
		Integer h = BASIC_VALUE * 3;
		setMaxHealth(h);
	}

	public void repair(Droid injuredDroid) {
		SimpleRepairDroid doctor = new SimpleRepairDroid(); // Create doctor
		Integer h = injuredDroid.getHealth(); // Points of injuredDroid's health
		Integer maxH = injuredDroid.getMaxHealth(); // Max health of injuredDroid
		Integer needH = maxH - h; // How much points we need to injuredDroid be health
		Integer en = getEnergy(); // Points of SuperDroid energy
		if (needH <= en) { // If we have enough quantity of energy to treat injuredDroid up to 100%
			doctor.setEnergy(needH); // Doctor has got SuperDroid's energy
			doctor.repair(injuredDroid);
			setEnergy(en - needH);
			System.out.println("Energy of SuperDroid  = " + getEnergy());
		} else if ((en > 0) & (needH > en)) {
			doctor.setEnergy(en);
			doctor.repair(injuredDroid);
			setEnergy(0);
			System.out.println("Energy of SuperDroid  = " + getEnergy());
		}

		else {
			System.out.println("You have no energy for treat!");
			return;
		}

	}

	/*
	 * If your energy >=1 you can walk. When you reach desired position your energy
	 * reduces on 1 point. If your energy <1 you can't walk. Parameters are the
	 * coordinates x, y of the game's field into which the droid shoul be moved
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

}
