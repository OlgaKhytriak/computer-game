package droids;

/**
 * @author okhytadmin
 *
 */
public class SimpleRepairDroid extends Droid implements RepairDroid {
	
	
	public SimpleRepairDroid() {
		Integer h=BASIC_VALUE*1;
		setMaxHealth(h);
	}

	/* SimpleRepairDroid treats injuredDroid by conversation ALL its own energy into the injuredDroid's life points
	 */
	public void repair(Droid injuredDroid) {
		Integer injuredDroidHealth=injuredDroid.getHealth();
		Integer maxHelth=injuredDroid.getMaxHealth();
		Integer energy=getEnergy();
		if (energy>0) {
		if (injuredDroidHealth<maxHelth) {
			while ((injuredDroidHealth<maxHelth)&(energy>0)) {
				injuredDroidHealth++;
				energy--;
			}
		System.out.println("Åðó åreatment is done successfull !");
		System.out.println("Health of njureddroid = "+injuredDroidHealth);
		System.out.println("Energy of SimpleRepairDroid droid = "+energy);
		setEnergy(energy);
		injuredDroid.setHealth(injuredDroidHealth);
		}
		else System.out.println("You are not enjured. You dont need repair!");
		}
		else System.out.println("You have no energy for treat!");
	}

	/* 
	 * If your energy >=3 you can walk. When you reach desired position your energy reduces on 3 point.
	 * If your energy <3 you can't walk.
	 * Parameters are the coordinates x, y of the game's field into which the droid shoul be moved  
	 */
	@Override
	public void move(Integer x, Integer y) {
		if (getEnergy()>=3){
			setPositionX(x);
			setPositionY(y);
			setEnergy(getEnergy()-3);}
			else {
				System.out.println("You dont have enough energy to move");
				return;
			}
		
	}

	
	
}
