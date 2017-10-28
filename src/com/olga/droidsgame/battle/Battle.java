package com.olga.droidsgame.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.constants.DroidType;
import com.olga.droidsgame.droids.BattleDroid;
import com.olga.droidsgame.droids.RepairDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.droids.ChargeDroid;
import com.olga.droidsgame.io.TeamInfoDisplayer;

public class Battle {
	private Team team1;
	private Team team2;
	private Integer turn;
	private TeamInfoDisplayer teamInfo1;
	private TeamInfoDisplayer teamInfo2;
	private DroidChooser droidChooser1;
	private DroidChooser droidChooser2;

	public Battle(Team team1, Team team2, DroidChooser droidChooser1, DroidChooser droidChooser2) {
		setTeam1(team1);
		setTeam2(team2);
		turn = 0;
		teamInfo1 = new TeamInfoDisplayer(team1);
		teamInfo2 = new TeamInfoDisplayer(team2);
		setDroidChooser1(droidChooser1);
		setDroidChooser2(droidChooser2);
	}

	public void startBattle() {
		System.out.println("-----TURN  №  " + turn + "  ------");
		teamInfo1.printTeamList();
		teamInfo2.printTeamList();
		if (0 == team1.sumAllTeamEnergy() && 0 == team2.sumAllTeamEnergy()) {
			System.out.println("Both teams have no energy. ");
			teamInfo1.printTeamList();
			teamInfo2.printTeamList();
			System.out.println(" !!!   Dead heat  !!!!!");
			return;
		}
		while (!team1.getTeamList().isEmpty() && !team2.getTeamList().isEmpty()) {
			turn++;
			System.out.println("-----TURN  №  " + turn + "  (1->2)------");
			if (0 == team1.sumAllTeamEnergy() && 0 == team2.sumAllTeamEnergy()) {
				System.out.println("Both teams have no energy");
				teamInfo1.printTeamList();
				teamInfo2.printTeamList();
				System.out.println(" !!!   Dead heat  !!!!!");
				return;
			}
			attakTeam1OnTeam2();
			teamInfo1.printTeamList();
			teamInfo2.printTeamList();
			if (!team2.getTeamList().isEmpty()) {
				turn++;
				System.out.println("-----TURN  №  " + turn + "  (2->1) ------");
				attakTeam2OnTeam1();
				teamInfo1.printTeamList();
				teamInfo2.printTeamList();
			} else {
				System.out.println("!!!   Team 1 win   !!!!!");
				return;
			}
		}
		if (team1.getTeamList().isEmpty()) {
			System.out.println("Team 2 win  !!!!!");
		}
	}

	public void attakTeam1OnTeam2() {
		SimpleDroid drAttacker = droidChooser1.choose();
		SimpleDroid drVictim = droidChooser2.choose();
		fightTwo(drAttacker, drVictim);
		if (!drVictim.isAlive()) {
			team2.deleteTeamMember(drVictim);
			Integer numberOfTeaMembers = team2.getCurrentNumberOfTeamMembers();
			team2.setNumberOfTeamMembers(numberOfTeaMembers);
		}

	}

	public void attakTeam2OnTeam1() {
		SimpleDroid drAttacker = droidChooser2.choose();
		SimpleDroid drVictim = droidChooser1.choose();
		fightTwo(drAttacker, drVictim);
		if (!drVictim.isAlive()) {
			team1.deleteTeamMember(drVictim);
			Integer numberOfTeaMembers = team1.getCurrentNumberOfTeamMembers();
			team1.setNumberOfTeamMembers(numberOfTeaMembers);
		}
	}

	public void fightTwo(SimpleDroid droidAttacker, SimpleDroid droidVictim) {
		if (0 == droidAttacker.getEnergy()) {
			System.out.println("No energy"); // якщо нема енергії він просто не ходить
			return;
		}
		DroidType attackerType = droidAttacker.getDroidType();
		DroidType victimType = droidVictim.getDroidType();
		if (DroidType.SIMPLE_BATTLE_DROID.equals(attackerType) || DroidType.SUPER_DROID.equals(attackerType)) {
			BattleDroid droidCanShoot = (BattleDroid) droidAttacker;// What is it? : I don't understand what I have done
																	// with interface in this case???
			droidCanShoot.shoot(droidVictim);
		} else if (DroidType.SIMPLE_REPAIR_DROID.equals(attackerType)) {
			SimpleDroid injuredDroid = droidAttacker.getMyTeam().findFirstInjuredDroid();
			// injuredDroid.printInfo();
			if (null == injuredDroid) {
				System.out.println("No injured droids for repairing");
			} else {
				RepairDroid droidCanRepair = (RepairDroid) droidAttacker;
				droidCanRepair.repair(injuredDroid);
			}
		}else if (DroidType.SIMPLE_CHARGE_DROID.equals(attackerType)) {
			// переписати длЯ ЕНЕРГЫЪ
			SimpleDroid injuredDroid = droidAttacker.getMyTeam().findFirstDischargedDroid();
			// injuredDroid.printInfo();
			if (null == injuredDroid) {
				System.out.println("No Discharged droids for Charging");
			} else {
				ChargeDroid droidCanCharge = (ChargeDroid) droidAttacker;
				droidCanCharge.charge(injuredDroid);
			}
			
		}
		

	}

	private SimpleDroid choisRandomDroid(Team team) {
		int max = team.getCurrentNumberOfTeamMembers();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		// System.out.println(index);
		return team.getTeamList().get(index);
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public DroidChooser getDroidChooser2() {
		return droidChooser2;
	}

	public void setDroidChooser2(DroidChooser droidChooser2) {
		this.droidChooser2 = droidChooser2;
	}

	public DroidChooser getDroidChooser1() {
		return droidChooser1;
	}

	public void setDroidChooser1(DroidChooser droidChooser1) {
		this.droidChooser1 = droidChooser1;
	}

}
