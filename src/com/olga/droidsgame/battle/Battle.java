package com.olga.droidsgame.battle;

import java.util.concurrent.ThreadLocalRandom;

import com.olga.droidsgame.droids.BattleDroid;
import com.olga.droidsgame.droids.DroidType;
import com.olga.droidsgame.droids.RepairDroid;
import com.olga.droidsgame.droids.SimpleDroid;
import com.olga.droidsgame.io.TeamInfoDisplayer;

public class Battle {
	private Team team1;
	private Team team2;
	private Integer turn;
	private TeamInfoDisplayer teamInfo1;
	private TeamInfoDisplayer teamInfo2;

	public Battle(Team team1, Team team2) {
		setTeam1(team1);
		setTeam2(team2);
		turn = 0;
		teamInfo1=new TeamInfoDisplayer(team1);
		teamInfo2=new TeamInfoDisplayer(team2);
	}

	public void startBattle() {
		System.out.println("-----TURN  №  " + turn + "  ------");
		teamInfo1.printTeamList();
		teamInfo2.printTeamList();
			if (0 == team1.sumEnergy() && 0 == team2.sumEnergy()) {
			System.out.println("Both teams have no energy. ");
			teamInfo1.printTeamList();
			teamInfo2.printTeamList();
			System.out.println(" !!!   Dead heat  !!!!!");
			return;
		}
		while (!team1.getTeamList().isEmpty() && !team2.getTeamList().isEmpty()) {
			turn++;
			System.out.println("-----TURN  №  " + turn + "  (1->2)------");
			if (0 == team1.sumEnergy() && 0 == team2.sumEnergy()) {
				System.out.println("Both teams have no energy");
				teamInfo1.printTeamList();
				teamInfo2.printTeamList();
				System.out.println(" !!!   Dead heat  !!!!!");
				return;
			}
			fightTeams(team1, team2);
			teamInfo1.printTeamList();
			teamInfo2.printTeamList();
			if (!team2.getTeamList().isEmpty()) {
				turn++;
				System.out.println("-----TURN  №  " + turn + "  (2->1) ------");
				fightTeams(team2, team1);
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

	public void fightTeams(Team teamAttacker, Team teamVictim) {
		// System.out.println("Teams start fighting");
		SimpleDroid drAttacker1 = choisRandomDroid(teamAttacker);
		SimpleDroid drVictim1 = choisRandomDroid(teamVictim);
		fightTwo(drAttacker1, drVictim1);
		if (!drVictim1.isAlive()) {
			teamVictim.deleteTeamMember(drVictim1);
			Integer numberOfTeaMembers=teamVictim.getCurrentNumberOfTeamMembers();
			teamVictim.setNumberOfTeamMembers(numberOfTeaMembers);
		}
		// System.out.println("Teams finish fighting");
	}

	public void fightTwo(SimpleDroid droidAttacker, SimpleDroid droidVictim) {
		if (0 == droidAttacker.getEnergy()) {
			System.out.println("No energy"); //якщо нема енергії він мав би передати хід
			return;
		}
		DroidType attackerType = droidAttacker.getDroidType();
		DroidType victimType = droidVictim.getDroidType();
		if (DroidType.SIMPLE_BATTLE_DROID.equals(attackerType) || DroidType.SUPER_DROID.equals(attackerType)) {
			BattleDroid droidCanShoot = (BattleDroid) droidAttacker;// What is it? : I don't understand what I have done with interface in this case???
			droidCanShoot.shoot(droidVictim);
		} else { ///ТУТ НЕ ПРАЦЮЄ
			SimpleDroid injuredDroid=droidAttacker.getMyTeam().findFirstInjuredDroid();
			//injuredDroid.printInfo();
			if (null==injuredDroid) {
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
