package droids;

/**
 * @author okhytadmin
 *
 */
public class MainProgram {

	/*
	 * є кусок початкового псевдокоду
	 * 
	 * public abstract class Droid; public class SuperDroid extends Droid implements
	 * BattleDroid, RepairDroid; public class SimpleRepairDroid extends Droid
	 * implements RepairDroid; public class Droideka extends Droid implements
	 * BattleDroid; public interface BattleDroid; public interface RepairDroid; public
	 * interface RoketDroid extends BattleDroid;
	 * 
	 * тра написати прогу Battle among droids: Use all your knowledge. Droids should
	 * have health, energy level, impact level etc. Use your creativity.
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainProgram().allActions();
		
	}

	public void allActions() {
		//testTreatmentBySimpleRepairDroid() ;
		//testTreatmentBySuperDroid() ;
		testABC();
	}
	public void testABC() {
		C ccc=new C();
	}
	
	public void testTreatmentBySimpleRepairDroid() {
		SimpleRepairDroid droidDoctor=new SimpleRepairDroid();
		SimpleRepairDroid droidPatient=new SimpleRepairDroid();
		droidDoctor.setEnergy(0);
		droidPatient.setHealth(10);
		droidDoctor.repair(droidPatient);
	}
	public void testTreatmentBySuperDroid() {
		SuperDroid droidDoctor=new SuperDroid();
		SimpleRepairDroid droidPatient=new SimpleRepairDroid();
		droidDoctor.setEnergy(5);
		droidPatient.setHealth(2);
		droidDoctor.repair(droidPatient);
		System.out.println("SuperDroid's energy = "+droidDoctor.getEnergy());
	}
}
