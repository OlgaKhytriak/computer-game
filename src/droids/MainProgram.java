package droids;

/**
 * @author okhytadmin
 *
 */
public class MainProgram {

	/*
	 * � ����� ����������� ����������
	 * 123
	 * 123
	 * 123
	 * 123
	 * 123
	 * 
	 * public abstract class Droid; public class SuperDroid extends Droid implements
	 * BattleDroid, RepairDroid; public class SimpleRepairDroid extends Droid
	 * implements RepairDroid; public class Droideka extends Droid implements
	 * BattleDroid; public interface BattleDroid; public interface RepairDroid;
	 * public interface RoketDroid extends BattleDroid;
	 * 
	 * ��� �������� ����� Battle among droids: Use all your knowledge. Droids should
	 * have health, energy level, impact level etc. Use your creativity.
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainProgram().allActions();

	}

	public void allActions() {
		// testTreatmentBySimpleRepairDroid() ;
		// testTreatmentBySuperDroid() ;
		testBattle();
	}

	public void testBattle() {
		Keyboard reader = new Keyboard();
		int n=reader.readIntegerFromKeyboard("Specify the amount of teams:");
		Team team1=new Team(n);
		//team1.fillInTeamList();
		Team team2=new Team(n);
		//team2.fillInTeamList();
		//team1.printTeamList();
		//team2.printTeamList();
		Battle battle=new Battle(team1, team2);
		battle.randomNumber();
		
	}

	public void testTreatmentBySimpleRepairDroid() {
		SimpleRepairDroid droidDoctor = new SimpleRepairDroid();
		SimpleRepairDroid droidPatient = new SimpleRepairDroid();
		droidDoctor.setEnergy(0);
		droidPatient.setHealth(10);
		droidDoctor.repair(droidPatient);
	}

	public void testTreatmentBySuperDroid() {
		SuperDroid droidDoctor = new SuperDroid();
		SimpleRepairDroid droidPatient = new SimpleRepairDroid();
		droidDoctor.setEnergy(5);
		droidPatient.setHealth(2);
		droidDoctor.repair(droidPatient);
		System.out.println("SuperDroid's energy = " + droidDoctor.getEnergy());
	}
}
