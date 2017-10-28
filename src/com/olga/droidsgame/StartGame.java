package com.olga.droidsgame;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.olga.droidsgame.battle.AlternatelyDroidChooser;
import com.olga.droidsgame.battle.Battle;
import com.olga.droidsgame.battle.RandomDroidChooser;
import com.olga.droidsgame.battle.Team;
import com.olga.droidsgame.droids.BellicoseDroid;
import com.olga.droidsgame.droids.SimpleBattleDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.droids.SimpleRepairDroid;
import com.olga.droidsgame.droids.SuperDroid;
import com.olga.droidsgame.io.DriodInfoDisplayer;
import com.olga.droidsgame.io.Keyboard;

import droids.BattleDroid;


/**
 * @author okhytadmin
 *
 */
public class StartGame {
private static final Logger LOG=Logger.getLogger(StartGame.class);
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
		//testBattle();
		
		//SimpleBattleDroid d=new SimpleBattleDroid();
		//DriodInfoDisplayer prt = new DriodInfoDisplayer(d);
		//prt.printEnergyInformation();
		
		//testDroidChoice();
		SuperDroid droidToDelete=new SuperDroid();
		if (droidToDelete instanceof BellicoseDroid) {
			System.out.println("111111111111111111111111111");
		}
		
	}

	public void testBattle() {
		Keyboard reader = new Keyboard();
		int n=reader.readIntegerFromKeyboard("Specify the amount of teams:");
		Team team1=new Team(n);
		team1.fillInTeamList();
		
		Team team2=new Team(n);
		team2.fillInTeamList();
		//team1.printTeamList();
		//team2.printTeamList();
		Battle battle=new Battle(team1, team2,new AlternatelyDroidChooser(team1),new AlternatelyDroidChooser(team2));
		//battle.randomNumber();
		battle.startBattle();
		
	}
	public void testDroidChoice() {
		Keyboard reader = new Keyboard();
		int n=reader.readIntegerFromKeyboard("Specify the amount of teams:");
		Team team3=new Team(n);
		team3.fillInTeamList();
		AlternatelyDroidChooser chooser=new AlternatelyDroidChooser(team3);
		//chooser.setDroidJustMadeMove(team3.getTeamList().get(2));
		//SimpleBattleDroid droid= new SimpleBattleDroid();
		SimpleDroid droidToDelete=chooser.choose();
		if (droidToDelete instanceof SuperDroid) {
			System.out.println("111111111111111111111111111");
		}
		team3.deleteTeamMember(droidToDelete);
		chooser.choose();
		 droidToDelete=chooser.choose();
		 team3.deleteTeamMember(droidToDelete);
		chooser.choose();
		chooser.choose();
		chooser.choose();
		chooser.choose();
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
