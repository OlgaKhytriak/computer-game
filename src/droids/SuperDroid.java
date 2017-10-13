package droids;

/**
 * @author okhytadmin
 *
 */
public class SuperDroid extends Droid implements RepairDroid{
		
	public SuperDroid() {
		setMaxHealth(BASIC_VALUE*2);
	}

	
	public void repair(Droid droid) {
		// TODO Auto-generated method stub
		
	}
	/* 
	 * If your energy >=1 you can walk. When you reach desired position your energy reduces on 1 point.
	 * If your energy <1 you can't walk.
	 * Parameters are the coordinates x, y of the game's field into which the droid shoul be moved  
	 */
	@Override
	public void move(Integer x, Integer y) {
		if (getEnergy()>=1){
			setPositionX(x);
			setPositionY(y);
			setEnergy(getEnergy()-1);}
			else {
				System.out.println("You dont have enough energy to move");
				return;
			}
		
	}

	
}
