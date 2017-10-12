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
	 * If your energy =0 you cant walk.
	 * Parameters are the coordinates x, y of the game's field into which the droid shoul be moved  
	 */
	@Override
	public void walk(byte x, byte y) {
		if (this.getEnergy()>0){
			this.setPositionX(x);
			this.setPositionY(y);
			this.setEnergy(this.getEnergy()-1);}
			else {
				System.out.println("You dont have enough energy to w");
				return;
			}
		
	}

	
	
}
