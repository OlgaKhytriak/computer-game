package com.olga.droidsgame;
import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.battle.AlternatelyDroidChooser;
import com.olga.droidsgame.battle.Battle;
import com.olga.droidsgame.battle.RandomDroidChooser;
import com.olga.droidsgame.battle.Team;
import com.olga.droidsgame.droids.SimpleBattleDroid;
import com.olga.droidsgame.droids.SimpleRepairDroid;
import com.olga.droidsgame.droids.SuperDroid;
import com.olga.droidsgame.io.DriodInfoDisplayer;
import com.olga.droidsgame.io.Keyboard;
import org.apache.log4j.Logger;

/**
 * @author okhytadmin
 *
 */
public class StartGame {
	private static final Logger LOG=Logger.getLogger(StartGame.class);
	//kjbkbdkbkjzb
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("START GAME");
		new StartGame().allActions();
			

	}

	public void allActions() {
		// testTreatmentBySimpleRepairDroid() ;
		// testTreatmentBySuperDroid() ;
		testBattle();
		
		//SimpleBattleDroid d=new SimpleBattleDroid();
		//DriodInfoDisplayer prt = new DriodInfoDisplayer(d);
		//prt.printEnergyInformation();
		
		//testDroidChoice();
		
	}

	public void testBattle() {
		Keyboard reader = new Keyboard();
		int n=reader.readIntegerFromKeyboard("Specify the amount of teams:");
		Team team1=new Team(n);
		Team team2=new Team(n);
		Battle battle=new Battle(team1, team2,new RandomDroidChooser(team1),new AlternatelyDroidChooser(team2));
		battle.startBattle();
		
	}
	public void testDroidChoice() {
		Keyboard reader = new Keyboard();
		int n=reader.readIntegerFromKeyboard("Specify the amount of teams:");
		Team team3=new Team(n);
		AlternatelyDroidChooser chooser=new AlternatelyDroidChooser(team3);
		chooser.setDroidJustMadeMove(team3.getTeamList().get(2));
		chooser.choose();
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
