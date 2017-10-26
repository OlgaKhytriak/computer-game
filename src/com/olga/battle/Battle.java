package com.olga.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droids.BattleDroid;
import com.olga.droids.SimpleDroid;
import com.olga.droids.DroidType;
import com.olga.droids.RepairDroid;

public class Battle {
	private Team team1;
	private Team team2;
	private Integer turn;

	public Battle(Team team1, Team team2) {
		setTeam1(team1);
		setTeam2(team2);
		turn = 0;
	}

	public void startBattle() {
		System.out.println("-----TURN  �  " + turn + "  ------");
		team1.printTeamList("TEAM � 1: ");
		team2.printTeamList("TEAM � 2: ");
			if (0 == team1.sumEnergy() && 0 == team2.sumEnergy()) {
			System.out.println("Both teams have no energy. ");
			team1.printTeamList("TEAM � 1: ");
			team2.printTeamList("TEAM � 2: ");
			System.out.println(" !!!   Dead heat  !!!!!");
			return;
		}
		while (!team1.getTeamList().isEmpty() && !team2.getTeamList().isEmpty()) {
			turn++;
			System.out.println("-----TURN  �  " + turn + "  (1->2)------");
			if (0 == team1.sumEnergy() && 0 == team2.sumEnergy()) {
				System.out.println("Both teams have no energy");
				team1.printTeamList("TEAM � 1: ");
				team2.printTeamList("TEAM � 2: ");
				System.out.println(" !!!   Dead heat  !!!!!");
				return;
			}
			fightTeams(team1, team2);
			team1.printTeamList("TEAM � 1: ");
			team2.printTeamList("TEAM � 2: ");
			if (!team2.getTeamList().isEmpty()) {
				turn++;
				System.out.println("-----TURN  �  " + turn + "  (2->1) ------");
				fightTeams(team2, team1);
				team1.printTeamList("TEAM � 1: ");
				team2.printTeamList("TEAM � 2: ");
			} else {
				System.out.println("!!!   Team 1 win   !!!!!");
				return;
			}
		}
		if (team1.getTeamList().isEmpty()) {
			System.out.println("Team 2 win  !!!!!");
		}

	}

	public void fightTeams(Team teamAttacker, Team teamVictim) {
		// System.out.println("Teams start fighting");
		SimpleDroid drAttacker1 = choisRandomDroid(teamAttacker);
		SimpleDroid drVictim1 = choisRandomDroid(teamVictim);
		fightTwo(drAttacker1, drVictim1);
		if (!drVictim1.isAlive()) {
			teamVictim.deleteElement(drVictim1);
			Integer numberOfTeaMembers=teamVictim.getCurrentNumberOfTeamMembers();
			teamVictim.setNumberOfTeamMembers(numberOfTeaMembers);
		}
		// System.out.println("Teams finish fighting");
	}

	public void fightTwo(SimpleDroid droidAttacker, SimpleDroid droidVictim) {
		if (0 == droidAttacker.getEnergy()) {
			System.out.println("No energy"); //���� ���� ����㳿 �� ��� �� �������� ���
			return;
		}
		DroidType attackerType = droidAttacker.getDroidType();
		DroidType victimType = droidVictim.getDroidType();
		if (DroidType.SIMPLE_BATTLE_DROID.equals(attackerType) || DroidType.SUPER_DROID.equals(attackerType)) {
			BattleDroid droidCanShoot = (BattleDroid) droidAttacker;// What is it? : I don't understand what I have done with interface in this case???
			droidCanShoot.shoot(droidVictim);
		} else { ///��� �� ����ު
			SimpleDroid injuredDroid=droidAttacker.getMyTeam().findFirstInjuredDroid();
			if (injuredDroid.equals(null)) {
				System.out.println("No injured droids for repairing");
			}
			else {
				RepairDroid droidCanRepair = (RepairDroid) droidAttacker;
				droidCanRepair.repair(injuredDroid);
			}
		}

	}

	private SimpleDroid choisRandomDroid(Team team) {
		int max = team.getCurrentNumberOfTeamMembers();
		int index = ThreadLocalRandom.current().nextInt(0, max);
		//System.out.println(index);
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

}