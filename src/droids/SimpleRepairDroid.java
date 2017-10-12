package droids;

/**
 * @author okhytadmin
 *
 */
public class SimpleRepairDroid extends Droid implements RepairDroid {
	
	public SimpleRepairDroid() {

	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * If your energy >0 you can walk. When you reach desired position your energy reduces on 1 point.
	 * If your energy =0 you can't walk.
	 * Parameters are the coordinates x, y of the game's field into which the droid shoul be moved  
	 */
	@Override
	public void move(byte x, byte y) {
		if (getEnergy()>0){
			setPositionX(x);
			setPositionY(y);
			setEnergy(getEnergy()-1);}
			else {
				System.out.println("You dont have enough energy to move");
				return;
			}
		
	}

	
	
}
