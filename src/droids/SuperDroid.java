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

	@Override
	public void shoot(Droid enemyDroid) {
		// TODO Auto-generated method stub
		
	}

}
